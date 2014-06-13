import java.util.*;
import java.io.*;

public class BattleShipDriver implements MiniGame{
    public boolean runMe(){
	boolean i = false; 
		try{
		BattleShip game = new BattleShip();
		Scanner sc = new Scanner(System.in);
		String s;
		int n;
		int a = 0;
		int col;
		int row;
		int turn;
		boolean b;
		char ship;
		//Thread t;
		System.out.println("Prepare for the duel of BattleShip");
		//	Thread.sleep(2000);
      		//Thread.sleep(5000);
		System.out.println("Here is your board:\n" + game.showPlayer());
		//Thread.sleep(2000);
		System.out.println("You must first place your patrol boat on the board. It has a length of two units.");
		//Thread.sleep(3000);
		System.out.println("Would you like to place your patrol boat vertically or horizontally?");
		System.out.println("1. Vertically\n2. Horizontally");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		n = sc.nextInt();
		while (n != 1 && n != 2) {
			System.out.println("Incorrect input. Please try again:\n1. Vertically\n2. Horizontally");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			    }

			n = sc.nextInt();
		}
		System.out.println("Select a row:");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		row = sc.nextInt() - 1;
		System.out.println("Select a column:");
		col = sc.nextInt() - 1;
		if (n == 1) {
			while (!game.addShipV(row, col, 2, game.getPlayer(), 'P')) {
				System.out.println("This ship cannot be placed here. Please choose a valid location.\nSelect a row:");
				while(!sc.hasNextInt()){
				    System.out.println("Please give and Integer response");
				    sc.nextLine();
				}
			row = sc.nextInt() - 1;
			System.out.println("Select a column:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			col = sc.nextInt() - 1;
			}
		}
		else if (n == 2) {
			while (!game.addShipH(row, col, 2, game.getPlayer(), 'P')) {
				System.out.println("This ship cannot be placed here. Please choose a valid location.\nSelect a row:");
			row = sc.nextInt() - 1;
			System.out.println("Select a column:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			col = sc.nextInt() - 1;
			}
		}
		System.out.println("Now you must place your submarine. It has a length of three units.");
		//Thread.sleep(3000);
		System.out.println(game.showPlayer());
		System.out.println("Would you like to place your submarine vertically or horizontally?");
		System.out.println("1. Vertically\n2. Horizontally");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		n = sc.nextInt();
		while (n != 1 && n != 2) {
			System.out.println("Incorrect input. Please try again:\n1. Vertically\n2. Horizontally");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			n = sc.nextInt();
		}
		System.out.println("Select a row:");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		row = sc.nextInt() - 1;
		System.out.println("Select a column:");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		col = sc.nextInt() - 1;
		if (n == 1) {
			while (!game.addShipV(row, col, 3, game.getPlayer(), 'S')) {
			    System.out.println("This ship cannot be placed here. Please choose a valid location.\nSelect a row:");
			    while(!sc.hasNextInt()){
				System.out.println("Please give and Integer response");
				sc.nextLine();
			    }
			    row = sc.nextInt() - 1;
			    System.out.println("Select a column:");
			    while(!sc.hasNextInt()){
				System.out.println("Please give and Integer response");
				sc.nextLine();
			    }
			    col = sc.nextInt() - 1;
			}
		}
		else if (n == 2) {
		    while (!game.addShipH(row, col, 3, game.getPlayer(), 'S')) {
			System.out.println("This ship cannot be placed here. Please choose a valid location.\nSelect a row:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			row = sc.nextInt() - 1;
			System.out.println("Select a column:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			col = sc.nextInt() - 1;
		    }
		}
		System.out.println("Now you must place your destroyer. It also has a length of three units.");
		System.out.println(game.showPlayer());
		//Thread.sleep(3000);
		System.out.println("Would you like to place your destroyer vertically or horizontally?");
		System.out.println("1. Vertically\n2. Horizontally");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		n = sc.nextInt();
		while (n != 1 && n != 2) {
			System.out.println("Incorrect input. Please try again:\n1. Vertically\n2. Horizontally");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			n = sc.nextInt();
		}
		System.out.println("Select a row:");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		row = sc.nextInt() - 1;
		System.out.println("Select a column:");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		col = sc.nextInt() - 1;
		if (n == 1) {
		    while (!game.addShipV(row, col, 3, game.getPlayer(), 'D')) {
			System.out.println("This ship cannot be placed here. Please choose a valid location.\nSelect a row:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			row = sc.nextInt() - 1;
			System.out.println("Select a column:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			col = sc.nextInt() - 1;
		    }
		}
		else if (n == 2) {
		    while (!game.addShipH(row, col, 3, game.getPlayer(), 'D')) {
			System.out.println("This ship cannot be placed here. Please choose a valid location.\nSelect a row:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			row = sc.nextInt() - 1;
			System.out.println("Select a column:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			col = sc.nextInt() - 1;
			}
		}
		System.out.println("Now you must place your battleship. It has a length of four units.");
		System.out.println(game.showPlayer());		
		//Thread.sleep(3000);
		System.out.println("Would you like to place your battleship vertically or horizontally?");
		System.out.println("1. Vertically\n2. Horizontally");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		n = sc.nextInt();
		while (n != 1 && n != 2) {
			System.out.println("Incorrect input. Please try again:\n1. Vertically\n2. Horizontally");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			n = sc.nextInt();
		}
		System.out.println("Select a row:");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		row = sc.nextInt() - 1;
		System.out.println("Select a column:");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		col = sc.nextInt() - 1;
		if (n == 1) {
		    while (!game.addShipV(row, col, 4, game.getPlayer(), 'B')) {
			System.out.println("This ship cannot be placed here. Please choose a valid location.\nSelect a row:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			row = sc.nextInt() - 1;
			System.out.println("Select a column:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			col = sc.nextInt() - 1;
			}
		}
		else if (n == 2) {
			while (!game.addShipH(row, col, 4, game.getPlayer(), 'B')) {
			    System.out.println("This ship cannot be placed here. Please choose a valid location.\nSelect a row:");
			    while(!sc.hasNextInt()){
				System.out.println("Please give and Integer response");
				sc.nextLine();
			    }
			    row = sc.nextInt() - 1;
			    System.out.println("Select a column:");
			    while(!sc.hasNextInt()){
				System.out.println("Please give and Integer response");
				sc.nextLine();
			    }
			    col = sc.nextInt() - 1;
			}
		}
		System.out.println("Now you must place your aircraft carrier. It has a length of five units.");
		System.out.println(game.showPlayer());		
		//Thread.sleep(3000);
		System.out.println("Would you like to place your aircraft carrier vertically or horizontally?");
		System.out.println("1. Vertically\n2. Horizontally");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		n = sc.nextInt();
		while (n != 1 && n != 2) {
			System.out.println("Incorrect input. Please try again:\n1. Vertically\n2. Horizontally");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			n = sc.nextInt();
		}
		//*********************************************************************************************************
		System.out.println("Select a row:");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		row = sc.nextInt() - 1;
		System.out.println("Select a column:");
		while(!sc.hasNextInt()){
		    System.out.println("Please give and Integer response");
		    sc.nextLine();
		}
		col = sc.nextInt() - 1;
		if (n == 1) {
			while (!game.addShipV(row, col, 5, game.getPlayer(), 'A')) {
				System.out.println("This ship cannot be placed here. Please choose a valid location.\nSelect a row:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}	
			row = sc.nextInt() - 1;
			System.out.println("Select a column:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			col = sc.nextInt() - 1;
			}
		}
		else if (n == 2) {
			while (!game.addShipH(row, col, 5, game.getPlayer(), 'A')) {
				System.out.println("This ship cannot be placed here. Please choose a valid location.\nSelect a row:");
			while(!sc.hasNextInt()){
			    System.out.println("Please give and Integer response");
			    sc.nextLine();
			}
			row = sc.nextInt() - 1;
			System.out.println("Select a column:");
			col = sc.nextInt() - 1;
			}
		}
//Ships have been placed
		System.out.println("You get to go first.");
		//Thread.sleep(1500);
		System.out.println("Here is your display. It will appear on each of your turns.");
		//	Thread.sleep(2500);
		turn = 0;
		while (game.play() == 0) {
			if (turn == 0) {
				System.out.println(game.showDisplay() + "\n//////////////\n\n" + game.showPlayer() + "\n");
				//Thread.sleep(1000);
				System.out.println("Your turn to attack! Choose a row:");
				while(!sc.hasNextInt()){
				    System.out.println("Please give and Integer response");
				    sc.nextLine();
				}
				row  = sc.nextInt() - 1;
				System.out.println("Choose a column:");
				while(!sc.hasNextInt()){
				    System.out.println("Please give and Integer response");
				    sc.nextLine();
				}
				col = sc.nextInt() - 1;
				while (row >= 10 || col >= 10 || col < 0 || row < 0) {
					System.out.println("Invalid input. Please try again.");
					System.out.println("Choose a row:");
					while(!sc.hasNextInt()){
					    System.out.println("Please give and Integer response");
					    sc.nextLine();
					}
					row = sc.nextInt() - 1;
					System.out.println("Choose a column");
					while(!sc.hasNextInt()){
					    System.out.println("Please give and Integer response");
					    sc.nextLine();
					}
					col = sc.nextInt() - 1;
				}
				ship = game.getOpp()[row][col];
				n = game.attack(row, col, game.getOpp());
				while (n == 0) {
					System.out.println("You have already selected this location. Please try again.");
					System.out.println("Choose a row:");
					while(!sc.hasNextInt()){
					    System.out.println("Please give and Integer response");
					    sc.nextLine();
					}
					row = sc.nextInt() - 1;
					System.out.println("Choose a column:");
					while(!sc.hasNextInt()){
					    System.out.println("Please give and Integer response");
					    sc.nextLine();
					}
					col = sc.nextInt() - 1;
					n = game.attack(row, col, game.getOpp());
				}
				if (n == 1)
					System.out.println("You missed! It is your opponents turn to attack.");
				else if (n == 2)
					if (!game.check(game.getOpp(), ship)) {
						if (ship == 'P')
							System.out.println("HIT! You sunk the patrol boat.");
						if (ship == 'D')
							System.out.println("HIT! You sunk the destroyer.");
						if (ship == 'S')
							System.out.println("HIT! You sunk the submarine.");
						if (ship == 'B')
							System.out.println("HIT! You sunk the battleship.");
						if (ship == 'A')
							System.out.println("HIT! You sunk the aircraft carrier.");
					}
					else
						System.out.println("HIT! It is your opponents turn to attack.");
				// Thread.sleep(3000);
				turn = 1;
			}
			else if (turn == 1) {
				System.out.print("Your opponent is thinking");
				//Thread.sleep(1000);
				System.out.print(".");
				//Thread.sleep(1000);
				System.out.print(".");
				//Thread.sleep(1000);
				System.out.print(".");
				//Thread.sleep(1000);
				System.out.print("\n");
				if (a == 0 || a == 2)
					a = game.turn();
				else if (a == 1)
					a = game.turn2();
				else if (a == 3)
					a = game.turn3();
				else if (a == 4)
					a = game.turn4();
				//Thread.sleep(3000);
				turn = 0;
			}
		}

		if (game.play() == 1)
		    return !i; 
		else
		    return i;  

		}
		catch (Exception e) {

		    return false; 
		}
    }
    public static void main (String args[]){
	BattleShipDriver d = new BattleShipDriver(); 
	d.runMe(); 
    }

    
}
