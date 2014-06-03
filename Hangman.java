import java.util.*;

public class Hangman implements MiniGame{
    private String[] words = {"hello", "computer", "science", "internet", "china", "football", "brown", "playoffs", "document", "application", "desktop", "offense", "strife", "struggle", "murderer", "beleive", "exception", "reality", "somewhere", "comfortable", "loneliness", "happiness", "frustrate"};

    private String word, display, guessedLetters;
    Scanner sc = new Scanner(System.in);

    public Hangman(){}

    public boolean help(String guess, int lives){
	
	if(lives == 0){
	    return false;
	}

	if(word.indexOf(guess) < 0){
	    lives--;
	    guessedLetters += guess;
	    
	    System.out.println(display);
	    System.out.println("Guessed:" + guessedLetters);
	    System.out.println("Lives: " + lives);
	    System.out.println("Oops! Try again!");
	    guess = sc.nextLine();
	    return help(guess, lives);
	}
	
	
	else{
	    int i = (2 * word.indexOf(guess));
	    display = display.substring(0, i)+ guess+ display.substring(i + 1);
	    while(word.indexOf(guess, i/2 + 1) > 0){
		i = (2 * word.indexOf(guess, i/2 + 1));
		display = display.substring(0, i)+ guess+ 
		    display.substring(i + 1);
	    }
	    if(display.indexOf("_") < 0){
		System.out.println(word);
		System.out.println("You Won!");
		return true;
	    }
	    
	    System.out.println(display);
	    System.out.println("Guessed:" + guessedLetters);
	    System.out.println("Lives: " + lives);
	    System.out.println("Nice one! Guess again!");
	    guess = sc.nextLine();
	    return help(guess,lives);
	}
    }

    public boolean runMe(){
	guessedLetters = "";
	word = words[(int)(Math.random() * words.length)];
	display = "";
	for(int i = 0; i < word.length(); i++){
	    display += "_ ";
	}
	System.out.println(display);
	System.out.println("Guessed: " + guessedLetters);
	System.out.println("Lives: " + 6);
	System.out.println("Guess a letter:");
	String guess = sc.nextLine();
	return help(guess,6);
    }

    public static void main(String[]args){
	Hangman h = new Hangman();
	h.runMe();
    }
}