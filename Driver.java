import java.io.*; 
import java.util.*; 


public class Driver{
    
    private String name; 
    private String rescuee; 
    
    public void main(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Welcome  warrior! You have been summoned on a mission of upmost importance.  State your name");
	name = sc.next(); 
	while (name.length() == 0){
	    System.out.println("You have not entered anything! Please state your name warrior");
	    name = sc.next(); 
	}
	System.out.println("Marvelous, " + name + " it is time to choose your preferance in who you would like to rescue" + "\n" + "Please tell us if you would like to save the PRINCESS or the KNIGHT."); 
	rescuee = sc.next(); 
	while(rescuee.length() == 0){
	    System.out.println(name + "You have not yet told us who you wuold like to save.  Please state your preference, be it PRINCESS or KNIGHT"); 
	    name = sc.next(); 
	}
	System.out.println(name + " you have chosen to save the " + rescuee + " your task lays ahead.  Proceede towards the castle"); 
	//Thread.sleep(1000); //walking towards the castle. 
	 
    }

    public boolean runGame(Tree tree){
	int i = 0; //spot you are at
      	Scanner sc = new Scanner(System.in); 
	int deaths = 0; 
       	boolean victory = false; 
	while(i < tree.size() && deaths <= 3){
	    if(i == 0 && deaths == 0){//if this is the absolute first time at the first node
		System.out.println("Your first task awates.  Complete each challenge in a timly manner. " + "\n" + 
				   "However, if you fail to complete your task THREE times, your corpse will be discarded and the " + rescuee + "\n" +
				   "will be locked in the castle for forever and always");
		//	tree.get(i).getGame().runMe(); //play the game
		if( tree.get(i).getGame().runMe()){ //boolean statement to see if they won
		    System.out.println(tree.get(i).getStory()); 
		    if(sc.nextInt() == 0)//if the want to go left (left from the birds eye view of a tree, with root at the top)
			i = i * 2 + 1;
		    else if(sc.nextInt() == 1)
			i = i * 2 + 2; 
		}
		else{
		    deaths++; 
		    System.out.println(name + ", you have failed at your task!  Beware wary of your faults." + "\n" + 
				       "You must retry the first level.  You have " + (3 - deaths) + "lives left"); 
		}
	    }//end of first if
	    else if(i != tree.size() - 1){
		tree.get(i).getGame().runMe(); //play the game
		if( tree.get(i).getGame().runMe()){ //boolean statement to see if they won
       		    System.out.println(tree.get(i).getStory()); 
		    if(sc.nextInt() == 0)//if the want to go left (left from the birds eye view of a tree with root at the top)
			i = i * 2 + 1;
		    else if(sc.nextInt() == 1)//if they want to go right
			i = i * 2 + 2; 
		}
		else { 
		    deaths++; 
		    System.out.println(name + ", you have failed at your task!  Beware of your faults." + "\n" + 
				       "You have been moved back a level and must recomplete the prior task. " + " You have " + (3 - deaths) + " lives left" ); 
		    i = (i - 1) / 2;//move you back
		}
	    }
	    else if(i == tree.size() - 1){
		System.out.println("Warrior, " + name + " you have now reached the last level.  To save your " + rescuee + "you must finish this one last task." + "\n");
		tree.get(i).getGame().runMe();
		if(tree.get(i).getGame().runMe()){ 
		    System.out.println("Congradulations! You have saved your " + rescuee + "You may now ride off into the sunset and live hapily");
		    victory = true; 
		}
		else{
		    deaths++; 
		    System.out.println("So close, yet so far!  Beware of your faults." + "\n" + "  You have"+ (3 - deaths) + " lives left"); 
		    i = (i - 1) / 2; 
		}
	    }
				   
	}//close while
	return victory; 
    }//close rungame
		
	 


    public static void main(String[] args){
	Driver d = new Driver(); 
	Tree n = new Tree(); 
	n.add(new TreeNode (new EasyMath(), "First game")); 
       	d.main(); 
	d.runGame(n);
	
    }
   
}//class

    
    
	    
	
    
