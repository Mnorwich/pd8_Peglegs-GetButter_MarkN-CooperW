import java.util.*;
import java.io.*;

public class EasyMath implements MiniGame{
    public EasyMath(){
    }
    
    public boolean runMe(){
	Scanner sc = new Scanner(System.in);
	int n1 = (int)(Math.random() *100);
	int n2 = (int)(Math.random() *100);
	int opp= (int)(Math.random() *3);
	if(opp == 0){
	    System.out.println(n1 + " + " + n2 + " = ?");
	    while(!sc.hasNextInt()){
		System.out.println("Please give an integer answer");
		sc.nextLine();
	    }
	    int ans = sc.nextInt();
	    if( ans == n1 + n2){
		System.out.println("Correct!");
		return true;
	    }
	    System.out.println("Wrong!");
	    return false;
	}else if(opp == 1){
	    System.out.println(n1 + " - " + n2 + " = ?");
	        while(!sc.hasNextInt()){
		System.out.println("Please give an integer answer");
		sc.nextLine();
	    }
	    int ans = sc.nextInt();
	    if(ans == n1 - n2){
		System.out.println("Correct!");
		return true;
	    }
	    System.out.println("Wrong!");
	    return false;
	}else if(opp == 2){
	    System.out.println(n1 + " * " + n2 + " = ?");
	    while(!sc.hasNextInt()){
		System.out.println("Please give an integer answer");
		sc.nextLine();
	    }
	    int ans = sc.nextInt();
	    if(ans == n1 * n2){
		System.out.println("Correct!");
		return true;
	    }
	    System.out.println("Wrong!");
	    return false;
	}
	return false;
    }
}
