import java.util.*;
import java.io.*;

public class BattleShip {
	private char[][] player, opp, display;
	private int rowH, colH, direction, rowD, colD;
	private boolean safety;

	public BattleShip () {
		player = new char[10][10];
		opp = new char[10][10];
		display = new char[10][10];
		safety = false;
		for (int i = 0;i<player.length;i++) {
			for (int j = 0;j<player[0].length;j++) {
				player[i][j] = '-';
				opp[i][j] = '-';
				display[i][j] = '-';
			}
		}
		fillBoard();
	}

    public String showDisplay() {
	String s="";
	s = s + "  1 2 3 4 5 6 7 8 9 10\n";
	for (int i=0;i<display.length;i++) {
		s = s + (i+1);
		if (i<9)
			s = s + " ";
	    for (int j=0;j<display[i].length;j++) {
		s=s+display[i][j]+" ";
	    }
	    s=s+"\n";
	}
	return s;
    }

	public char[][] getPlayer() {
		return player;
	}

	public char[][] getOpp() {
		return opp;
	}
	
    public String showPlayer() {
	String s="";
	s = s + "  1 2 3 4 5 6 7 8 9 10\n";
	for (int i=0;i<player.length;i++) {
		s = s + (i+1) ;
		if (i < 9)
			s = s+" ";
	    for (int j=0;j<player[i].length;j++) {
		s=s+player[i][j]+" ";
	    }
	    s=s+"\n";
	}
	return s;
    }

	public boolean addShipH(int row, int col, int length, char[][] board, char ship) {
		if (col + length > board[0].length || row >= board.length || row < 0 || col < 0)
			return false;
		for (int i = 0;i<length;i++) {
			if (!(board[row][i+col] == '-'))
				return false;
		}
		for (int i = 0;i<length;i++)
			board[row][i+col] = ship;
		return true;
	}
		
	public boolean addShipV(int row, int col, int length, char[][] board, char ship){
		if (row + length > board.length || col >= board[0].length || row < 0 || col < 0)
			return false;
		for (int i = 0;i<length;i++) {
			if (!(board[row+i][col] == '-'))
				return false;
		}
		for (int i = 0;i<length;i++)
			board[row+i][col] = ship;
		return true;
	}

	public int count(char[][] board, char ship) {
		int s = 0;
		for (int i = 0; i<board.length; i++) {
			for (int j = 0; j<board[i].length; j++) {
				if (board[i][j] == ship)
					s++;
			}
		}
		return s;
	}

	public int getRowH(char[][] board, char ship) {
		for (int i = 0; i<board.length; i++) {
			for (int j = 0; j<board[i].length; j++) {
				if ((board[i][j] == ship) && (nextTo(i,j, board, 'H')))
					return i;
			}
		}
		return 0;
	}
	
	public int getColH(char[][] board, char ship) {
		for (int i = 0; i<board.length; i++) {
			for (int j = 0; j<board[i].length; j++) {
				if ((board[i][j] == ship) && (nextTo(i, j, board, 'H')))
					return j;
			}
		}
		return 0;
		}



	public boolean nextTo(int row, int col, char[][] board, char ship) {
		try {
			if (board[row+1][col] == ship)
				return true;
		}
		catch (Exception e) {}
		try {
			if (board[row-1][col] == ship)
				return true;
		}
		catch (Exception e) {}
		try {
			if (board[row][col+1] == ship)
				return true;
		}
		catch (Exception e) {}
		try {
			if (board[row][col-1] == ship)
				return true;
		}
		catch (Exception e) {}
		return false;
	}

	public void fillBoard() {
		boolean b = false;
		Random r = new Random();
		int holes = 2;
		int row, col;
		while (!b) {
			row = r.nextInt(10);
			col = r.nextInt(10);
			if (r.nextInt(2) == 0) {
				b = addShipH(row, col, holes, opp, 'P');
			}
			else {
				b = addShipV(row, col, holes, opp, 'P');
			}
		}
		holes = 3;
		char ship = 'S';
		b = false;
		while (!b) {
			row = r.nextInt(10);
			col = r.nextInt(10);
			if (r.nextInt(2) == 0) {
				b = addShipH(row, col, holes, opp, ship);
			}
			else {
				b = addShipV(row, col, holes, opp, ship);
			}
		}
		ship = 'D';
		b = false;
		while (!b) {
			row = r.nextInt(10);
			col = r.nextInt(10);
			if (r.nextInt(2) == 0) {
				b = addShipH(row, col, holes, opp, ship);
			}
			else {
				b = addShipV(row, col, holes, opp, ship);
			}
		}
		holes = 4;
		ship = 'B';
		b = false;
		while (!b) {
			row = r.nextInt(10);
			col = r.nextInt(10);
			if (r.nextInt(2) == 0) {
				b = addShipH(row, col, holes, opp, ship);
			}
			else {
				b = addShipV(row, col, holes, opp, ship);
			}
		}
		holes = 5;
		ship = 'A';
		b = false;
		while (!b) {
			row = r.nextInt(10);
			col = r.nextInt(10);
			if (r.nextInt(2) == 0) {
				b = addShipH(row, col, holes, opp, ship);
			}
			else {
				b = addShipV(row, col, holes, opp, ship);
			}
		}
	}

	public int attack(int row, int col, char[][] board) {
		if (row < 0 || col < 0 || row >= 10 || col >= 10 || board[row][col] == '+' || board[row][col] == 'H')
			return 0;
		else if (board[row][col] == '-') {
			board[row][col] = '+';
			if (board.equals(opp))
				display[row][col] = '+';
			return 1;
		}
		else {
			board[row][col] = 'H';
			if (board.equals(opp))
				display[row][col] = 'H';
			return 2;
		}
	}

	public boolean check(char[][] board, char ship) {
		for (int i = 0;i<board.length;i++) {
			for (int j = 0;j<board[i].length;j++) {
				if (board[i][j] == ship)
					return true;
			}
		}
		return false;
	}

	public int turn() {
		safety = false;
		int n = 0;
		char ship = '-';
		String s = "";
		int row = 0;
		int col = 0;
		if (count(player, 'P') == 1) {
			rowH = getRowH(player, 'P');
			colH = getColH(player, 'P');
			n = attack(rowH, colH, player);
			if (!check(player, 'P')) {
				System.out.println("Hit at " + (rowH+1) + ", " + (colH+1) + "! Your patrol boat has been sunk!");
				return 2;
			}
			else {
				System.out.println("Hit at " + (rowH+1) + ", " + (colH+1) + "!");
				return 1;
			}
		}
		if (count(player, 'S') == 1 || count(player, 'S') == 2) {
			rowH = getRowH(player, 'S');
			colH = getColH(player, 'S');
			n = attack(rowH, colH, player);
			if (!check(player, 'S')) {
				System.out.println("Hit at " + (rowH+1) + ", " + (colH+1) + "! Your submarine has been sunk!");
				return 2;
			}
			else {
				System.out.println("Hit at " + (rowH+1) + ", " + (colH+1) + "!");
				return 1;
			}
		}
		if (count(player, 'D') == 1 || count(player, 'D') == 2) {
			rowH = getRowH(player, 'D');
			colH = getColH(player, 'D');
			n = attack(rowH, colH, player);
			if (!check(player, 'D')) {
				System.out.println("Hit at " + (rowH+1) + ", " + (colH+1) + "! Your destroyer has been sunk!");
				return 2;
			}
			else {
				System.out.println("Hit at " + (rowH+1) + ", " + (colH+1) + "!");
				return 1;
			}
		}
		if (count(player, 'B') == 1 || count(player, 'B') == 2 || count(player, 'B') == 3) {
			rowH = getRowH(player, 'B');
			colH = getColH(player, 'B');
			n = attack(rowH, colH, player);
			if (!check(player, 'B')) {
				System.out.println("Hit at " + (rowH+1) + ", " + (colH+1) + "! Your battleship has been sunk!");
				return 2;
			}
			else {
				System.out.println("Hit at " + (rowH+1) + ", " + (colH+1) + "!");
				return 1;
			}
		}
		if (count(player, 'A') < 5 && count(player, 'A') > 0) {
			rowH = getRowH(player, 'A');
			colH = getColH(player, 'A');
			n = attack(rowH, colH, player);
			if (!check(player, 'A')) {
				System.out.println("Hit at " + (rowH+1) + ", " + (colH+1) + "! Your aircraft carrier has been sunk!");
				return 2;
			}
			else {
				System.out.println("Hit at " + (rowH+1) + ", " + (colH+1) + "!");
				return 1;
			}
		}
		Random r = new Random();
		while (n == 0) {
			row = r.nextInt(10);
			col = r.nextInt(10);
			ship = player[row][col];
			n = attack(row, col, player);
		}
		if (n == 1) {
			System.out.println("Miss at " + (row + 1) + ", " + (col + 1) + "!");
			return 0;
		}
		else if (n == 2) {
			s = "Hit at " + (row+1) + ", " + (col+1) + "!";
			if (!check(player, ship)) {
				if (ship == 'P')
					s = s + " Your patrol boat has been sunk!";
				if (ship == 'D')
					s = s + " Your destroyer has been sunk!";
				if (ship == 'S')
					s = s + " Your submarine has been sunk!";
				if (ship == 'B')
					s = s + " Your battleship has been sunk!";
				if (ship == 'A')
					s = s + " Your aircraft carrier has been sunk!";
				System.out.println(s);
				return 2;
			}
		}
		rowH = row;
		colH = col;
		System.out.println(s);
		return 1;
	}

	public int turn2() {
		Random r = new Random();
		int n = 0;
		int d = 0;
		int col = colH;
		int row = rowH;
		char ship = '-';
		while (n == 0) {
			col = colH;
			row = rowH;
			d = r.nextInt(4);
			if (d == 0) 
				col++;
			else if (d == 1)
				row++;
			else if (d == 2)
				col--;
			else if (d == 3)
				row--;
			if (row >= 0 && col >= 0 && row < 10 && col < 10)
				ship = player[row][col];
			n = attack(row, col, player);
		}
	//	if (n == 0) 
	//		return 1;
		if (n == 1) {
			System.out.println("Miss at " + (row + 1) + ", " + (col + 1) + "!");
			return 1;
		}
		else if (n == 2) {
			if (ship == 'P' && !check(player, 'P')) {
				System.out.println("Hit at " + (row + 1) + ", " + (col + 1) +"! Your patrol boat has been sunk!");
				return 2;
			}
			else if (!check(player, ship)) {
				System.out.println("Hit at " + (row+1) + ", " + (col+1) +"! Your ship has been sunk!");
				return 2;
			}
			direction = d;
			rowD = row;
			colD = col;
			System.out.println("Hit at " + (row + 1) + ", " + (col + 1) +"!");
		}
		return 3;
	}

	public int turn3() {
		int col = colD;
		int row = rowD;
		int n = 0;
		char ship = '-';
		if (direction == 0)
			col++;
		else if (direction == 1)
			row++;
		else if (direction == 2)
			col--;
		else if (direction == 3)
			row--;
		if (row >= 0 && col >= 0 && row < 10 && col < 10)
			ship = player[row][col];
		n = attack(row, col, player);
		if (n == 0) {
			if (safety)
				return turn();
			else
				return turn4();
		}
		else if (n == 1) {
			System.out.println("Miss at " + (row + 1) + ", " + (col + 1) + "!");
			return 4;
		}
		else if (n == 2) {
			if (!check(player, ship)) {
				String s = "Hit at " + (row+1) + ", " + (col+1) + "!";
				if (ship == 'P')
					s = s + " Your patrol boat has been sunk!";
				else if (ship == 'D')
					s = s + " Your destroyer has been sunk!";
				else if (ship == 'S')
					s = s + " Your submarine has been sunk!";
				else if (ship == 'B')
					s = s + " Your battleship has been sunk!";
				else if (ship == 'A')
					s = s + " Your aircraft carrier has been sunk!";
				System.out.println(s);
				return 2;
			}
			System.out.println("Hit at " + (row + 1) + ", " + (col + 1) +"!");
			colD = col;
			rowD = row;
		}
		return 3;
		
	}

	
	public int turn4() {
		//Random r = new Random();
		safety = true;
		colD = colH;
		rowD = rowH;
		if (direction == 0)
			direction = 2;
		else if (direction == 1)
			direction = 3;
		else if (direction == 2)
			direction = 0;
		else if (direction == 3)
			direction = 1;
		
		return turn3();
		
			
	}

	public int play() {
		boolean b1 = false;
		boolean b2 = false;
		for (int i = 0; i<player.length;i++) {
			for (int j = 0;j<player[i].length;j++) {
				if (!(player[i][j] == '-') && !(player[i][j] == '+') && !(player[i][j] == 'H'))
					b1 = true;
			}
		}
		for (int i = 0; i<player.length;i++) {
			for (int j = 0;j<player[i].length;j++) {
				if (!(opp[i][j] == '-') && !(opp[i][j] == '+') && !(opp[i][j] == 'H') )
					b2 = true;
			}
		}
		if (b1 == true && b2 == true)
			return 0;
		else if (b2 == false)
			return 1;
		else 
			return 2;
	}


	
}













