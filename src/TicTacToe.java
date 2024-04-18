import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions =  new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions =  new ArrayList<Integer>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		char [] [] gameboard = {
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
			};
		printGameBoard(gameboard);
		
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter positon (1-9):");
		int playerpos = sc.nextInt();
		if (playerpos<1 || playerpos >9) {
			System.out.println("Position taken chose a differnet a position");
			playerpos = sc.nextInt();
		
		}
		while(playerPositions.contains(playerpos) || cpuPositions.contains(playerpos)){
			System.out.println("Position taken chose a differnet a position");
			playerpos = sc.nextInt();
		}
//		System.out.println(pos);
		placePeice(gameboard,playerpos,"player");
		String result = checkWinner();
		Random rand = new Random();
		int cpuPos = rand.nextInt(9) + 1;
		while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
			cpuPos = rand.nextInt(9) + 1;
			
		}
		placePeice(gameboard,cpuPos,"cpu");
		printGameBoard(gameboard);
		result = checkWinner();
		if(result.length()>0 ) {
			System.out.print(result);
			break;
		}
		
	}
		
}
	public static void printGameBoard(char [][] gameBoard) {
		for(char [] row: gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.print("\n");
		}
	}
	public static void placePeice(char [][]gameboard,int pos ,String User) {
		char symbol = ' ';
		if(User.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		}
		else {
			symbol = 'O';
			cpuPositions.add(pos);
		}
		
		switch(pos) {
		case 1:
			gameboard[0][0] = symbol;
			break;
		case 2:
			gameboard[0][2] = symbol;
			break;
		case 3:
			gameboard[0][4] = symbol;
			break;
		case 4:
			gameboard[2][0] = symbol;
			break;
		case 5:
			gameboard[2][2] = symbol;
			break;
		case 6:
			gameboard[2][4] = symbol;
			break;
		case 7:
			gameboard[4][0] = symbol;
			break;
		case 8:
			gameboard[4][2] = symbol;
			break;
		case 9:
			gameboard[4][4] = symbol;
			break;
		default:
			break;
			
		//printGameBoard(gameboard);
		}
		printGameBoard(gameboard);
	}
	public static String checkWinner() {
		List toprow  = Arrays.asList(1,2,3);
		List Middlerow  = Arrays.asList(4,5,6);
		List Bottomrow  = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List MidCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(3,5,7);
		
		List<List> winning = new ArrayList<List>();
		winning.add(leftCol);
		winning.add(toprow);
		winning.add(Middlerow);
		winning.add(Bottomrow);
		winning.add(MidCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l: winning) {
			if(playerPositions.containsAll(l)) {
				return "Congratulations";
			}
			else if(cpuPositions.containsAll(l)) {
				return "CPU wins";
			}
			else if(playerPositions.size() + cpuPositions.size() == 9) {
				return "cat";
			}
		}
		return "";

	}

}
