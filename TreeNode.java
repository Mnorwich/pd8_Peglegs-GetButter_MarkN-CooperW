/*****************************************************
 class TreeNode holds a MiniGame and story
 *****************************************************/

public class TreeNode {
    private MiniGame game;
    private String story1, story2;
      //instance variables / attributes of a TreeNode:


    /*****************************************************
     * default constructor
     * Construct a tree node with specified value, 
     * with null left and right subtrees.
     *****************************************************/
    TreeNode( MiniGame game, String story1, String story2 ){
	this.game = game;
 	this.story1 = story1;
	this.story2 = story2;
    }

    TreeNode(MiniGame game, String story1){
	this.game = game; 
	this.story1 = story1; 
    }
          
 


    /*****************************************************
     * Returns the value stored in this tree node.
     *****************************************************/
    public String getStory1(){
	return story1;
    }
    
    public String getStory2(){
	return story2; 
    }

    public MiniGame getGame(){
	return game;
    }

    /*****************************************************
     * Sets the value of this tree node.
     *****************************************************/
    public void setStory1( String story ) 
    {
	this.story1 = story;
    }
    
    public void setStory2(String story){
	this.story2 = story; 
    }

    public void setGame(MiniGame game){
	this.game = game;
    }


    public String toString(int whichStory ){
	if(whichStory == 1)
	    return getStory1() + "";
       	else 
	    return getStory2() + ""; 
    }
 
}//end class
