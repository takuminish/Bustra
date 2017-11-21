package Game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Base.GameEnvironment;
import Base.Panel;
import Game.Enemy.EasyEnemy;
import Game.Enemy.Enemy;
import Game.Enemy.HardEnemy;
import Game.Enemy.NormalEnemy;

public class Field extends Panel{

	private Enemy enemy;
	private TextFrame Tframe;
	private PlayerFrame Pframe;
    
    public Field(int PlayerHP,String deficult) {

    	if (deficult.equals("easy")) {
	        this.enemy = new EasyEnemy();
    	} else if (deficult.equals("normal")) {
    		this.enemy = new NormalEnemy();
    	} else if (deficult.equals("hard")) {
    		this.enemy = new HardEnemy();
    	}
        this.Tframe = new TextFrame(this.enemy.getName(), this.damagenorma());
        this.Pframe = new PlayerFrame(PlayerHP);
        this.add(this.Tframe);
        this.add(this.Pframe);
        this.add(this.enemy);
        this.enemy.setBounds(GameEnvironment.ENEMYX,GameEnvironment.ENEMYY,GameEnvironment.ENEMYWIDTH,GameEnvironment.ENEMYHEIGHT);
        this.Tframe.setBounds(GameEnvironment.TEXTFRAMEX,GameEnvironment.TEXTFRAMEY,GameEnvironment.TEXTFRAMEWIDTH,GameEnvironment.TEXTFRAMEHEIGHT);
        this.Pframe.setBounds(5,5,75,75);
    }
    public void TextChange(String str) {
    	this.Tframe.ChangeText(str);
    }
    public void paintComponent(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, getWidth(), getHeight());

    }
    
    public void DamagePlayer(int PlayerHP) {
    	this.Pframe.setHPText(PlayerHP);
    }
    
    public void EnemeyDamage() {
    	this.enemy.Damage();
    }
    
    public int damagenorma() {
    	return this.enemy.getNorma();
    }
    
    public int getEnemyHp() {
    	return  this.enemy.getHp();
    }
    
    public void clear() {
    	this.enemy.clear();
    }
    
    public void gameover() {
    	this.Tframe.gameover();
    	this.Pframe.gameover();
    }
    
    public Enemy getEnemy() {
    	return this.enemy;
    }
}
