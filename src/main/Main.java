package main;
import levels.*;

public class Main {
	public static int scorePlayerOne =0;
	public static int scorePlayerTwo =0;
	public static void main(String args[]){
		Thread levelOne = new Thread(new LevelOne());
		levelOne.start();
		try{
			levelOne.join();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
