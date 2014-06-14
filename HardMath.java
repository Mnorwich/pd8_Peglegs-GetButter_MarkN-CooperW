import java.util.*;
import java.io.*;

public class HardMath implements MiniGame{
    
    
    
    public boolean runMe(){
       	Scanner sc = new Scanner(System.in);
	int n1 = (int)(Math.random() *100); 
	int n2 = (int)(Math.random() *100);
	int n3 = (int)(Math.random() * 10)+1; 
	int opp= (int)(Math.random() *3);
	int negate = (int)(Math.random() * 3); 
	if (negate == 1)
	    n1 = n1*-1; 
	if(negate == 2)
	    n2 = n2*-1;
	if (negate == 3){
	    n1 = n1*-1; 
	    n2 = n2*-1; 
	}
		
	    
	if(opp == 0){
	    System.out.println("|" + n1 + " + " + n2 + "| % " + n3 + "= ?");
	    while(!sc.hasNextInt()){
		System.out.println("Please give an integer answer");
		sc.nextLine();
	    }
	    int ans = sc.nextInt();
	    if( ans == Math.abs(n1 + n2) % n3){
		System.out.println("Correct!");
		return true;
	    }
	    System.out.println("Wrong!");
	    return false;
	}else if(opp == 1){
	    System.out.println("|" + n1 + " - " + n2 + "| % " + n3 + " = ?");
	        while(!sc.hasNextInt()){
		System.out.println("Please give an integer answer");
		sc.nextLine();
	    }
	    int ans = sc.nextInt();
	    if(ans == Math.abs(n1 - n2) % n3){
		System.out.println("Correct!");
		return true;
	    }
	    System.out.println("Wrong!");
	    return false;
	}else if(opp == 2){
	    System.out.println("|" + n1 + " * " + n2 + "| & " + n3 + " = ?");
	    while(!sc.hasNextInt()){
		System.out.println("Please give an integer answer");
		sc.nextLine();
	    }
	    int ans = sc.nextInt();
	    if(ans == Math.abs(n1 * n2) % n3){
		System.out.println("Correct!");
		return true;
	    }
	    System.out.println("Wrong!");
	    return false;
	}
	return false;

    }


    /* public static void main (String[] args){
	HardMath math = new HardMath(); 
	math.runMe(); 
    }*/
}
