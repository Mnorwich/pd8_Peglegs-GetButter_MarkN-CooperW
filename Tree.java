/*****************************************************
 Class Tree uses an ArrayList of TreeNodes to keep story and minigames in place.
 *****************************************************/

import java.util.ArrayList;


public class Tree {

    //instance vars
    private ArrayList<TreeNode> _heap; //underlying container
    
    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public Tree(){
	_heap = new ArrayList<TreeNode>();
     }//O(1)


    
    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() {
	return _heap.isEmpty();
    }//O(1)


    /* adds value to last position in the heap such that it mantains a balanced complete nature */

    public void add( TreeNode n ){
	_heap.add(n);
    }
    
    public int size(){
	return _heap.size(); 
    }

    public TreeNode get(int i){
	return _heap.get(i); 
    }




    //~~~~~~~~~~~~~~~v~  MISC HELPERS ~v~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~^~  MISC HELPERS ~^~~~~~~~~~~~~~~~



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more
)
     *****************************************************/
    public String toString()  {
	return _heap.toString();
    }





    //main method for testing
	public static void main( String[] args ) {
	    TreeNode n = new TreeNode(new EasyMath(), "hi");
	    n.getGame().runMe();
	    
    }//end main()

}//end class ALHeap
