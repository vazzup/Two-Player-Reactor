package levels;

import levels.*;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.Main;

public class LevelOne extends JFrame implements KeyListener, Runnable{
	private static boolean flag;
	private static boolean alreadyPressed;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		JLabel playerOne = new JLabel("Score:"+Main.scorePlayerOne);
		JLabel playerTwo = new JLabel("Score:"+Main.scorePlayerTwo);
		this.setSize(400, 400);
		playerOne.setBounds(0,0,100, 400);
		playerTwo.setBounds(300, 0, 100, 400);
		JLabel playGround = new JLabel();
		playGround.setBounds(100,0,200,400);
		playGround.setBackground(Color.WHITE);
		playGround.setOpaque(true);
		playerOne.setOpaque(true);
		playerTwo.setOpaque(true);
		this.add(playerOne);
		this.add(playerTwo);
		this.add(playGround);
		this.setLayout(null);
		this.setVisible(true);
		this.addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JOptionPane.showMessageDialog(this, "Press your key when it turns green");
		Random rand= new Random();
		int count =5;
		int i=0;
		do{
			playGround.setBackground(Color.WHITE);
			flag=alreadyPressed=false;
			try {
			    Thread.sleep(rand.nextInt((5000-1000)+1)+1000);    
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			flag=true;
			playGround.setBackground(Color.GREEN);
			try {
			    Thread.sleep(1000);    
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			playerOne.setText("Score:"+Main.scorePlayerOne);
			playerTwo.setText("Score:"+Main.scorePlayerTwo);
			i++;
		}while(i<count);
		playGround.setBackground(Color.WHITE);
		JOptionPane.showMessageDialog(this, "Level Over");
		Thread levelTwo= new Thread(new LevelTwo());
		levelTwo.start();
		this.setVisible(false);
		try{
			levelTwo.join();
		}
		catch(Exception e){
			System.out.println(e);
		}
}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_A){
			if(!alreadyPressed){
				if(flag)Main.scorePlayerOne++;
				else Main.scorePlayerOne--;
				alreadyPressed=true;
			}
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_L){
			if(!alreadyPressed){
				if(flag)Main.scorePlayerTwo++;
				else Main.scorePlayerTwo--;
				alreadyPressed=true;
			}
		}
		if(arg0.getKeyCode()==KeyEvent.VK_X){
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	
}
