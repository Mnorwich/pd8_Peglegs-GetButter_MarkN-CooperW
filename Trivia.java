import java.io.*;
import java.util.*;

public class Trivia implements MiniGame{
    protected String[] questions;
    protected int[] answers;
    

    public boolean runMe(){
	String question;
	int answer;
	int ans;

	Scanner sc = new Scanner(System.in);


	
	int lives = 2;

	for(int i = 0; i < questions.length; i++){
	    question = questions[i];
	    answer = answers[i];
	    System.out.println(question);
	    while(!sc.hasNextInt()){
		System.out.println("Please give an Integer answer");
		sc.nextLine();
	    }
	    ans = sc.nextInt();
	    if(ans == answer){
		System.out.println("Correct!");
	    }
	    else{
		lives--;
		System.out.println("Wrong!");
	    }
	    
	    if(lives == 0){
		System.out.println("You Loose!");
		return false;
	    }
	}

	System.out.println("Congradulations! You've won!");
	return true;
	
	
    }
}