package levels;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.Main;

public class LevelTwo extends JFrame implements KeyListener, Runnable{
	private static boolean flag;
	private static boolean alreadyPressed;
	private static String images[]={"twitter.png","mask.png","android.png","ant.png"};
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		JLabel playerOne = new JLabel("Score:"+Main.scorePlayerOne);
		JLabel playerTwo = new JLabel("Score:"+Main.scorePlayerTwo);
		this.setSize(1000, 1000);
		playerOne.setBounds(0, 0, 100, 1000);
		playerTwo.setBounds(900, 0, 100, 1000);
		JLabel pGOne = new JLabel();
		JLabel pGTwo =new JLabel();
		JLabel pGThree =new JLabel();
		JLabel pGFour =new JLabel();
		pGOne.setBounds(100,0,400,500);
		pGTwo.setBounds(500,0,400,500);
		pGThree.setBounds(100,500,400,500);
		pGFour.setBounds(500,500,400,500);
		this.add(playerOne);
		this.add(playerTwo);
		this.add(pGOne);
		this.add(pGTwo);
		this.add(pGThree);
		this.add(pGFour);
		pGOne.setOpaque(true);
		pGTwo.setOpaque(true);
		pGThree.setOpaque(true);
		pGFour.setOpaque(true);
		JLabel labels[]={pGOne,pGTwo,pGThree,pGFour};
		this.setLayout(null);
		this.setVisible(true);
		this.addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JOptionPane.showMessageDialog(this, "Level Two: Press when THREE images are the same");
		Random rand= new Random();
		int i=0;
		int cnt=5;
		do{
			int vals[]={-1,-1,-1,-1};
			int count[]={0,0,0,0};
			for(int j=0;j<4;j++){
				labels[j].setIcon(null);
			}
			alreadyPressed=false;
			flag=false;
			while(!alreadyPressed){
				int label=rand.nextInt(4);
				int image=rand.nextInt(4);
				labels[label].setIcon(new ImageIcon(images[image]));
				if(vals[label]==-1){
					count[image]++;
					vals[label]=image;
					if(count[image]>=3){
						flag=true;
					}
				}
				else{
					
					if(count[vals[label]]>=3){
						count[vals[label]]--;
						flag=false;
					}
					else{
						count[vals[label]]--;
					}
					count[image]++;
					if(count[image]>=3){
						flag=true;
					}
					vals[label]=image;
				}
				try {
				    Thread.sleep(1000);    
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			}
			playerOne.setText("Score:"+Main.scorePlayerOne);
			playerTwo.setText("Score:"+Main.scorePlayerTwo);
			i++;
		}while(i<cnt);
		if(Main.scorePlayerOne>Main.scorePlayerTwo){
			JOptionPane.showMessageDialog(this, "Player One Wins!");
		}
		else if(Main.scorePlayerTwo>Main.scorePlayerOne){
			JOptionPane.showMessageDialog(this, "Player Two Wins!");
		}
		else{
			JOptionPane.showMessageDialog(this, "It's a Tie!");
		}
		//this.setVisible(false);
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
