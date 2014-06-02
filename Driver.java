import java.io.*; 
import java.util.*; 


public class Driver{
    
    private String name; 
    private String rescuee; 
    
    public void main(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Welcome  warrior! You have been summoned on a mission of upmost importance.  State your name");
	if (sc.hasNext()){
	    name = sc.next(); 
	}
	// else{
      	// 	System.out.println("You have not entered anything! Please state your name warrior");
	// 	name = sc.next(); 
	    
	// }
	try {
       	    Thread.sleep(1000);
       	} 
	catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
       	}
	System.out.println("\n\nMarvelous, " + name + ", it is time to choose your preferance in who you would like to rescue" + "\n" + "Please tell us if you would like to save the PRINCESS or the KNIGHT."); 
	rescuee = sc.next(); 
	// while(rescuee.length() == 0){
	//     System.out.println(name + "You have not yet told us who you wuold like to save.  Please state your preference, be it PRINCESS or KNIGHT"); 
	//     name = sc.next(); 
	// }
	System.out.println("\n\n" + name + ", you have chosen to save the " + rescuee + " your task lays ahead.  Proceede towards the castle.\n\n"); 
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
		System.out.println("Your first task awates.  Complete each challenge in a timly manner. " + "\n" + 
				   "However, if you fail to complete your task THREE times, your corpse will be discarded and the " + rescuee + "\n" +
				   "will be locked in the castle for forever and always");
		try {
		    Thread.sleep(5000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		if( tree.get(i).getGame().runMe()){ //boolean statement to see if they won
		    System.out.println(tree.get(i).getStory()); 
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
		if( tree.get(i).getGame().runMe()){ //boolean statement to see if they won
       		    System.out.println(tree.get(i).getStory()); 
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
		

	 


    public static void main(String[] args){
	Driver d = new Driver(); 
	Tree n = new Tree(); 
	n.add(new TreeNode (new EasyMath(), "Do you want to go right(1) or left(0)")); 
       	n.add(new TreeNode (new EasyMath(), "Do you want to go right(1) or left(0)")); 
	n.add(new TreeNode (new EasyMath(), "Do you want to go right(1) or left(0)")); 
	n.add(new TreeNode (new EasyMath(), "Do you want to go right(1) or left(0)")); 
       	n.add(new TreeNode (new EasyMath(), "Do you want to go right(1) or left(0)")); 
	n.add(new TreeNode (new EasyMath(), "Do you want to go right(1) or left(0)")); 
	
       	d.main(); 
	d.runGame(n);
	
    }
   
		
		
    //DOES GETGAME.RUNME() RETURN BOOLEAN? YES.

}//class

    
    
	    
	
    
