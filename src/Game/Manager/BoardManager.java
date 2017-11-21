package Game.Manager;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Base.GameEnvironment;
import Base.SoundPlayer;
import Game.Drop.DarkDrop;
import Game.Drop.Drop;
import Game.Drop.FireDrop;
import Game.Drop.LightDrop;
import Game.Drop.WaterDrop;
import Game.Drop.WoodDrop;
import Game.Thread.SleepThread;
import Game.Board;

// �Ֆʂ̊Ǘ����s����
// �R���{�̔���A�c�莞�Ԃ̑���͂��̃N���X�ōs����
public class BoardManager {

	private Board board; // Bpard�N���X�̃C���X�^���X
	private int BoardX; // �Ֆʂ̉��̃h���b�v�̐�
	private int BoardY; // �Ֆʂ̏c�̃h���b�v�̐�
	private int dropDiameter; // �h���b�v�̑傫��
	private int dropX;
	private int dropY;
	private int comboN;
	private SoundPlayer[] moveSound = new SoundPlayer[4];
	private SoundPlayer comboSound;

	public BoardManager(Board board) {
		this.board = board;
		this.BoardX = GameEnvironment.BOARDWIDTH;
		this.BoardY = GameEnvironment.BOARDHEIGHT;
		this.dropDiameter = GameEnvironment.DROPDIAMETER;
		ArrayList<Drop> drop = new ArrayList<Drop>();
		for (int k = 0; k < 4; k++) {
			moveSound[k] = new SoundPlayer("tin.wav");
		}
		comboSound = new SoundPlayer("combo.wav");
	}

	// �}�E�X�̍��W���玝�h���b�v�����肵�h���b�v������
	public void holdManagement(int mouseX, int mouseY) {
		this.dropX = mouseX / this.dropDiameter; // �}�E�X�̍��W���獶���牽�Ԗڂ̃h���b�v�Ȃ̂����擾
		this.dropY = mouseY / this.dropDiameter; // �}�E�X�̍��W����ォ�牽�Ԗڂ̃h���b�v�Ȃ̂����擾
		board.getBoard().get(this.dropY).get(this.dropX).hold(mouseX, mouseY); // �h���b�v������

	}

	// �����Ă���h���b�v���}�E�X�̍��W���Q�Ƃ��ē�������
	public void MoveManagement(int mouseX, int mouseY) {
		// ���Ɠ���ւ����
		if (mouseX < this.dropX * this.dropDiameter) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX - 1, this.dropY); // ���̃h���b�v�Ɠ���ւ���
			moveSound[0].init();
			moveSound[0].play();
		}
		// �E�Ɠ���ւ����
		else if (mouseX > this.dropX * this.dropDiameter + this.dropDiameter) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX + 1, this.dropY); // �E�̃h���b�v�Ɠ���ւ���
			moveSound[1].init();
			moveSound[1].play();
		}
		// ��Ɠ���ւ����
		else if (mouseY < this.dropY * this.dropDiameter) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX, this.dropY - 1); // ��̃h���b�v�Ɠ���ւ���
			moveSound[2].init();
			moveSound[2].play();
		}
		// ���Ɠ���ւ����
		else if (mouseY > this.dropY * this.dropDiameter + this.dropDiameter) {
			this.board.dropSwap(this.dropX, this.dropY, this.dropX, this.dropY + 1); // ���̃h���b�v�Ɠ���ւ���
			moveSound[3].init();
			moveSound[3].play();
		}

		this.dropX = board.getHoldDropX(); // ���݂̎����Ă���h���b�v��X���W������Ă����
		this.dropY = board.getHoldDropY(); // ���݂̎����Ă���h���b�v��Y���W������Ă����
		board.getBoard().get(this.dropY).get(this.dropX).move(mouseX, mouseY); // �h���b�v�𓮂�����
	}

	// �����Ă���h���b�v������ēK�؂ȏꏊ�ɒu����
	public void LostManagement() {

		board.getBoard().get(this.dropY).get(this.dropX).lost(30, 30);

	}

	// �R���{������s����
public void comboDicision(Runnable callback) {
		
		this.comboN = 0;
		Thread n = new Thread(() -> {
			ArrayList<Integer> x = new ArrayList<Integer>();    // �R���{�̌��ʏ����h���b�v���i�[�����
			ArrayList<Integer> y = new ArrayList<Integer>();
			int i = GameEnvironment.BOARDHEIGHT-1;
			int j;
			int num;
			int ct1=0;
			int ct2=0;
			int ct3=0;
			int l;
			int m;
			int flag = 1;
			while ( flag != 0 ) {
				//this.FallDrop();
				flag = 0;
				i = 4;
				j = 0;
			while ( i >= 0 ) {
				j = 0;
				while ( j < GameEnvironment.BOARDWIDTH -1 ) {
					ct1 = 0;
					ct2 = 0;
					ct3 = 0;
					num = this.board.getBoard().get(i).get(j).getId();
					if ( num == -1 ) {
						j++;
					} else {
						if ( num == this.board.getBoard().get(i).get(j+1).getId() ) {
							for ( m = j; m < GameEnvironment.BOARDWIDTH-1; m++ ) {
								l = i;
								if ( num == this.board.getBoard().get(l).get(m+1).getId() ) {
									ct1++;
								} else {
									break;
								}
							}
							if ( ct1 >= 2 ) {
								for ( m = j; m <= ct1+j; m++ ) {
									x.add(m);
									y.add(i);
									this.board.getBoard().get(i).get(m).setId();
								}
								this.dropDelete(x,y);
								this.comboN++;
								flag = 1;
								x.clear();
								y.clear();
								j += ct1;
							} else {
								j++;
							}
						} else if ( i != 0 ) {
							if ( num == this.board.getBoard().get(i-1).get(j).getId() ){
								for ( l = i; l > 0; l-- ) {
									m = j;
									if ( num == this.board.getBoard().get(l-1).get(m).getId() ) {
										ct2++;
									} else {
										break;
									}
								}
								if ( ct2 >= 2 ) {
									for ( l = i; l >= i - ct2; l-- ) {
										x.add(j);
										y.add(l);
										this.board.getBoard().get(l).get(j).setId();
									}
									this.dropDelete(x,y);
									this.comboN++;
									flag = 1;
									x.clear();
									y.clear();
								}
							}
							j++;
						} else {
							j++;
						}
					}
					if ( j == 5 && i != 0) {
						num = this.board.getBoard().get(i).get(5).getId();
						if ( num == this.board.getBoard().get(i-1).get(5).getId() ){
							for ( l = i; l > 0; l-- ) {
								if ( num == this.board.getBoard().get(l-1).get(5).getId() ) {
									ct3++;
								} else {
									break;
								}
							}
							if ( ct3 >= 2 ) {
								for ( l = i; l >= i - ct3; l-- ) {
									x.add(5);
									y.add(l);
									this.board.getBoard().get(l).get(5).setId();
								}
								this.dropDelete(x,y);
								this.comboN++;
								flag = 1;
								x.clear();
								y.clear();
							}
						}
					}
				}
				i--;
			}
			System.out.println(this.comboN);
			this.FallDrop();
			}
	    	callback.run();
		});
		n.start();
	}

	public int getCombo() {
		return this.comboN;
	}

	// �h���b�v���폜
	public void dropDelete(ArrayList<Integer> x, ArrayList<Integer> y) {
		Thread renderer = new Thread(() -> {
			this.board.dropDelete(x, y);
		});
		renderer.start();

		try {
			comboSound.init();
			comboSound.play();
			renderer.sleep(450);
			renderer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void FallDrop() {

		Drop tmp;
		for (int k1 = GameEnvironment.BOARDHEIGHT - 1; k1 > 0; k1--) {
			for (int k2 = 0; k2 < GameEnvironment.BOARDWIDTH; k2++) {
				System.out.println(this.board.getBoard().get(k1).get(k2).getVisible() + "");
				if (!this.board.getBoard().get(k1).get(k2).getVisible()) {
					for (int k3 = k1; k3 >= 0; k3--) {
						if (this.board.getBoard().get(k3).get(k2).getVisible()) {
							this.board.dropSwap(k2, k1, k2, k3);
							break;
						}
					}
				}
			}
		}
		for (int k1 = 0; k1 < GameEnvironment.BOARDHEIGHT; k1++) {
			for (int k2 = 0; k2 < GameEnvironment.BOARDWIDTH; k2++) {
				System.out.println(k1 + "," + k2);
				if (!this.board.getBoard().get(k1).get(k2).getVisible()) {
					// this.board.getBoard().get(k1).remove(k2);
					switch (this.board.random()) {
					case 0:
						this.board.getBoard().get(k1).set(k2,
								new FireDrop(this.dropDiameter / 2, this.dropDiameter / 2));
						break; // �����_���̒l��0��������΃h���b�v���i�[�����
					case 1:
						this.board.getBoard().get(k1).set(k2,
								new WaterDrop(this.dropDiameter / 2, this.dropDiameter / 2));
						break; // �����_���̒l��1�������琅�h���b�v���i�[�����
					case 2:
						this.board.getBoard().get(k1).set(k2,
								new WoodDrop(this.dropDiameter / 2, this.dropDiameter / 2));
						break; // �����_���̒l��2��������؃h���b�v���i�[�����
					case 3:
						this.board.getBoard().get(k1).set(k2,
								new DarkDrop(this.dropDiameter / 2, this.dropDiameter / 2));
						break; // �����_���̒l��3��������Ńh���b�v���i�[�����
					case 4:
						this.board.getBoard().get(k1).set(k2,
								new LightDrop(this.dropDiameter / 2, this.dropDiameter / 2));
						break; // �����_���̒l��4����������h���b�v���i�[�����
					}
				}
			}
		}
	}

}
