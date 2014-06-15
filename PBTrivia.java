public class PBTrivia extends Trivia{
        
    public PBTrivia(){	
	String[] tempquestions = {  "What is special about Count Rugen?\n1) He has three eyes.\n2) He has six fingers on his right hand\n3) He is missing his left hand\n4) He has no Teeth",
				    "What actor plays Fezzik? \n1) Andre the Giant \n2) Inigo Montoya\n3) Chris Sarandon \n4) Cary Elwes",
				    "What does RUS stand for? \n1) Really Ugly Strangers. \n2)Ravens of Unpredictable Strength \n3)Rodents of Unusual Size \n4)Rapid Use Storage",
				    "What is the name of the evil Prince? \n1) Prince Farquaad \n2) Prince Joeffrey Lanister \n3) Westley \n4) Prince Hemperdinck"};	
	
	int[] tempanswers = {2, 1, 3, 4};
	




	questions = tempquestions;
	answers = tempanswers;

	
    }

    public boolean runMe(){
	System.out.println("You must answer each question about The Princess Bride in order to move on, but be weary! Two wrong answers and you lose! \n\n");
	return super.runMe();
    }


    public static void main(String[]args){
	MiniGame m = new PBTrivia();
	m.runMe();
    }
}