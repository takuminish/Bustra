package Game.Manager;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Base.GameApp;
import Base.GameScene;
import Base.SoundPlayer;
import Game.Field;
public class FieldManager {

	private Field field; 
	private int damagenorma;
	private int PlayerHP;
	private String enemyName;
    private SoundPlayer attackSound;
    private SoundPlayer damageSound;
    private SoundPlayer gameOverSound;
    private SoundPlayer gameClearSound;
	    
	public FieldManager(Field field, int PlayerHP) {
		this.field = field;
		this.PlayerHP = PlayerHP;
		this.damagenorma = this.field.damagenorma();
	    this.enemyName = this.field.getEnemy().getName();
	    this.attackSound = new SoundPlayer("atack.wav");
	    this.gameOverSound = new SoundPlayer("GameOver.wav");
	    this.damageSound = new SoundPlayer("damage.wav");
	}
	public void DamageDecision(int comboN) {
		if (comboN < this.damagenorma) {
			this.field.TextChange("<html>ミス!反撃を受けた!<br>もう一度" + this.damagenorma +"コンボ以上で攻撃だ</html>");
			this.PlayerHP--;
			this.field.DamagePlayer(this.PlayerHP);
			GameApp.scene = GameScene.game;
			if (this.PlayerHP <= 0) {
				this.gameOverSound.init();
				this.gameOverSound.play();
				this.field.gameover();
				GameApp.scene = GameScene.gameOver;
			}
			damageSound.init();
			damageSound.play();
		} else {
			this.field.TextChange("<html>攻撃成功!!<br>" + this.damagenorma + "コンボ以上でさらに攻撃成功!!</html>");
			this.field.EnemeyDamage();
			GameApp.scene = GameScene.game;
			if (this.field.getEnemyHp() <= 0) {
				this.field.clear();
				this.field.TextChange(this.enemyName + "を倒した");
				GameApp.scene = GameScene.gameClear;
			} else {
		     	this.damagenorma = this.field.damagenorma();
			}
			attackSound.init();
			attackSound.play();
			
			
		}
		
	}
}
