/*****************************************************
 class TreeNode holds a MiniGame and story
 *****************************************************/

public class TreeNode {
    private MiniGame game;
    private String story;
      //instance variables / attributes of a TreeNode:


    /*****************************************************
     * default constructor
     * Construct a tree node with specified value, 
     * with null left and right subtrees.
     *****************************************************/
    TreeNode( MiniGame game, String story ){
	this.game = game;
 	this.story = story;
    }
          
 


    /*****************************************************
     * Returns the value stored in this tree node.
     *****************************************************/
    public String getStory(){
	return story;
    }

    public MiniGame getGame(){
	return game;
    }

    /*****************************************************
     * Sets the value of this tree node.
     *****************************************************/
    public void setStory( String story ) 
    {
	this.story = story;
    }

    public void setGame(MiniGame game){
	this.game = game;
    }


    public String toString(){
	return getStory() + "";
    }
 
}//end class