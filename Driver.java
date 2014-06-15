import java.io.*; 
import java.util.*; 


public class Driver{
    
    private String name; 
    private String rescuee; 
    
    public void main(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Welcome  warrior! You have been summoned on a mission of upmost importance.  State your name");
	if (sc.hasNext()){
	    name = sc.nextLine(); 
	}

	try {
       	    Thread.sleep(1000);
       	} 
	catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
       	}
	 System.out.println("\n\nMarvelous, " + name + ", who you would like to rescue?" + "\n" + "Enter 1 if you want to save the PRINCESS, enter 2 if you want to save the knight");
        int i = sc.nextInt();
        if (i == 1)
            rescuee = "PRINCESS";
        else
            rescuee = "KNIGHT";
	System.out.println("\n\n" + name + ", you have chosen to save the " + rescuee + " your task lays ahead.  Proceed towards the castle.\n\n"); 
	try {
       	    Thread.sleep(1000);
       	} 
	catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
       	}	 
    }

    public boolean runGame(Tree tree){
	int i = 0; //spot you are at
      	Scanner sn = new Scanner(System.in); 
	int deaths = 0; 
       	boolean victory = false;
	Integer next = null; 
	while(i < tree.size() && deaths != 3){
	    if(i == 0 && deaths == 0){//if this is the absolute first time at the first node
		System.out.println("Your first task awaites.  Complete each challenge in a timley manner. " + "\n" + 
				   "However, if you fail to complete your task THREE times, your corpse will be discarded and the " + rescuee + "\n" +
				   "will be locked in the castle for forever and always");
		try {
		    Thread.sleep(5000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println(tree.get(i).getStory1()); 
		if( tree.get(i).getGame().runMe()){ //boolean statement to see if they won
		    System.out.println(tree.get(i).getStory2()); 
		    next = sn.nextInt(); 
		    if(next == 0)//if the want to go left (left from the birds eye view of a tree, with root at the top)
			i = i * 2 + 1;
		    if(next == 1){
			i = i * 2 + 2; 
			//	System.out.println(i); 
		    }
		    
		}
		else{
		    deaths++; 
		    if(deaths == 3)
			System.out.println("YOU HAVE FAILED"); 
		    else{
     			System.out.println(name + ", you have failed at your task!  Be wary of your faults." + "\n" + 
				       "You must retry the first level.  You have " + (3 - deaths) + " lives left"); 
		    }
		}
	    }//end of first if
	    else if((i * 2 + 1) > tree.size() - 1){
		System.out.println("Warrior, " + name + " you have now reached the last level.  To save your " + rescuee + " you must finish this one last task." + "\n");
		System.out.println(tree.get(i).getStory1()); 
       		if(tree.get(i).getGame().runMe()){ 
		    System.out.println("Congradulations! You have saved your " + rescuee + ".  You may now ride off into the sunset and live hapily.");
		    return true; 
		}
		else{
		    deaths++; 
		    if(deaths == 3)
			System.out.println("YOU HAVE FAILED");
		    else{
			System.out.println("So close, yet so far!  Be wary of your faults." + "\n" + "  You have"+ (3 - deaths) + " lives left"); 
			i = (i - 1) / 2; 
		    }
		}
	    }
	    else{
		System.out.println(tree.get(i).getStory1()); 
		if( tree.get(i).getGame().runMe()){ //boolean statement to see if they won
       		    System.out.println(tree.get(i).getStory2()); 
		    next = sn.nextInt(); 
		    if(next == 0)//if the want to go left (left from the birds eye view of a tree with root at the top)
			i = i * 2 + 1;
		    if(next == 1)//if they want to go right
			i = i * 2 + 2; 
		}
		else { 
		    deaths++; 
		    if(deaths == 3){
			System.out.println("YOU HAVE FAILED"); 
		    }
		    else if(i == 0){
			System.out.println(name + ", you have failed at your task! Be wary of your faults." + "\n" + 
					   "You must retry the first level.  You have " + (3 - deaths) + " lives left"); 
		    }
		    else{
			System.out.println(name + ", you have failed at your task!  Be wary of your faults." + "\n" + 
				       "You have been moved back a level and must recomplete the prior task. " + " You have " + (3 - deaths) + " lives left" ); 
			i = (i - 1) / 2;//move you back
		    }
		}
	    }
	    
				   
	}//close while
	return victory; 
    }//close rungame

    public String getRescuee(){ 
	return this.rescuee; 
    }
		

	 


    public static void main(String[] args){
	Driver d = new Driver(); 
	Tree n = new Tree(); 
	n.add(new TreeNode (new  EasyMath(), "A Wise Old Man stands in your way. You must defeat him in a game of wits to move on!", 
			    "There is nothing between you and the castle! Do you want to (0) enter through the main gate? or (1) enter through the bridge of death?")); 
       	n.add(new TreeNode (new Hangman(), "As you're crossing the moat to the main gate a dragon emerges from the depths below.  He gives a mighty roar as he prepares to feast on your flesh. You propose a challenge. If you can defeat him in a game of hangman he will point you on the way to your " +  d.getRescuee() + ".  If you lose, however, he will point you in the way of his stomach.", "You've defeated the dragon and he prepares to point you on your way but the tricky dragon, angry for losing his dinner, refuses to tell you which way to go.  He opens the gate and flys away. You must choose to (0) go down the stairs to the dark cellar. or (1) climb the long winding stairs toward the top.")); 
	n.add(new TreeNode (new PBTrivia(), "The old man from scene twenty-four appears.  He is the keeper of the bridge of death.  He asks each traveler three questions, no, five questions.  He who answers the three questions, no, five questions, may cross it safely.  What if you get a question wrong, you ask? You are cast into the gorge of eternal peril.  Answer the three questions, no, five questions, as best you can.  God be with you.", "Right, off you go.  After crossing the bridge of death, you enter the castle.  Here you must choose to (0) go down the left corridor or (1)the right corridor.  What is your choice?")); 
	n.add(new TreeNode (new PBTrivia(), "In the corner you gaze upon a man sitting by candlelight.  He jumps to his feet at the sight of your presence.  To your surprise, he says “Hello.  My name is Inigo Montoya.  You killed my father. Prepare to die.”  You are confused because Inigo already avenged his fathers death in The Princess Bride.  Inigo is surprised you know his film so well and offers you a proposition.  If you can get through his trivia questions, you will survive.  Fail, and face the consequences.", 
			    "You've impressed Inigo.  Leaving you with one last riddle he bids you farewell on your mission and the rest of your life.  His riddle states, “my father's killer had six fingers on this hand.  Your answer will be the direction you go.”  The RIGHT answer will lead you on the RIGHT path.  Do you want to go (0)Left or (1)Right.")); 
       	n.add(new TreeNode (new HardMath(), "Once at the top of the winding stairs, you encounter Bender from the hit TV series Futurama.  Puffing his cigar and drinking a juice box, he demands you leave his presence.  You plea with him, explaining that you are trying to save your " + d.getRescuee() + ".  Bender says that if your brain power can beat his computing power, you can move past him.", "You've outsmarted bender.  Walking through a cloud of smoke you continue to walk down a corridor.  But wait, theres a fork.  Do you want to continue (0)left or (1)right?")); 
	n.add(new TreeNode (new Hangman(), "After choosing to walk down the left corridor, Andre the Giant jumps out from behind a corner.  He tells you the he posses the strength of thirty men, to which you respond but do you posses the wits of a Stuyvesant student? Andre is insulted and challenges you to play him in hangman.  If you win, you may continue.", 
			    "You've outsmarted the giant and he lets you proceed through the corridor.  A daed end is approaching and you have two choices.  Do you want to (0)walk up the staircase or (1) open the door  the magically appeared on your right?"));
	n.add(new TreeNode (new Hangman(), "Ni! Ni! Ni! We are the Knights who say...Ni!  The keepers of the sacred word, says the Knight who says Ni!.  You proclaim, Knight who says Ni!,  I am a simple traveler who only seeks my " + d.getRescuee() + ".  Ni!” Says the Knight.  Well, what is it you want? You question.  We want...to be entertained! You must beat me in a game of hangman or you will never pass, alive!"));
	n.add(new TreeNode (new BattleShipDriver(), "Prepare to play battleship"));
	n.add(new TreeNode (new BattleShipDriver(), "Prepare to play battleship"));
	n.add(new TreeNode (new BattleShipDriver(), "Prepare to play battleship"));
	n.add(new TreeNode (new BattleShipDriver(), "Prepare to play battleship"));
	n.add(new TreeNode (new BattleShipDriver(), "Prepare to play battleship"));
	n.add(new TreeNode (new BattleShipDriver(), "Prepare to play battleship"));
	n.add(new TreeNode (new BattleShipDriver(), "Prepare to play battleship"));
	n.add(new TreeNode (new BattleShipDriver(), "Prepare to play battleship"));
	d.main(); 
	d.runGame(n);
    }		
    //DOES GETGAME.RUNME() RETURN BOOLEAN? YES.

}//class

    
/*Unresolved-If we move back a level each time a person looses, do we want the inroduction speech to play again? If not, we night want to change it so that the person does not have to move back a level.  Also, do we want to personalize loosing statements? Instead of it saying, be wary of your faults....do we want each character at each obsticle to say a new thing?  Ex: Andre would laugh at you.  Dragon would feel bad and give you another try. 
 */
	    
	
    
