import java.util.Random;

public class play extends gamemethods{
	public static DoublyLinkedList<block> board;
	static Random rand = new Random();
	
	//Plays one game
	//prints out board at specified moves value
	//takes in number of moves + board
	public static void playgame(int moves, DoublyLinkedList<block> board) {
			boolean goon = true;
			int iterate = contestants.length;
			int played = 0;
			while(goon) {
				for(int i = 0; i< iterate; i++) {
					Player currentplayer = contestants[i];	
					int die = rand.nextInt(6);
					die = die+1;
					currentplayer.moveplayer(die);
					played++;
					if (played == moves)
						{
						printboard(board);
						}

					if(currentplayer.checkwin()== true) {
						goon=false;
						gamereset();
						
					}
					
				}
			}
		}
	//playgames
	//takes in just the board
	public static void playgame(DoublyLinkedList<block> board) {
		boolean goon = true;
		while(goon) {
			for(int i = 0; i< contestants.length; i++) {
				Player currentplayer = contestants[i];	
				int die = rand.nextInt(6);
				die = die+1;
				currentplayer.moveplayer(die);
				if(currentplayer.checkwin()== true) {
					goon=false;
					gamereset();
					
				}
				
			}
		}
	}
	//Always plays a 1000 games
	//prints out board at move value within the specified gamevalue
	//takes in numberofgames, moves, and board
	public static void playgames1(int numberofgames, int moves, DoublyLinkedList<block> board) {
		
		for(int i = 0; i < 1000; i++) {
			boolean goon = true;
			int played = 0;
			while(goon) {
				for(int x = 0; x< contestants.length; x++) {
					Player currentplayer = contestants[x];	
					int die = rand.nextInt(6);
					die = die+1;
					currentplayer.moveplayer(die);
					played++;
					if (played == moves && i+1 == numberofgames)
						{
						System.out.println("Game Number: " + (i+1));
						printboard(board);
						}
					
					if(currentplayer.checkwin()== true) {
						goon=false;
						gamereset();
						break;
						
						
					}
					
				}
			}
		}
	}
	//Plays number of games of specified value
	//prints out board at move value irregardless of gamenumber
	//takes in numberofgames, moves, board
	public static void playgames2(int numberofgames, int moved, DoublyLinkedList<block> board) {
		int played = 0;
		for(int i = 0; i < numberofgames; i++) {
			boolean goon = true;
			while(goon) {
				for(int x = 0; x< contestants.length; x++) {
					Player currentplayer = contestants[x];	
					int die = rand.nextInt(6);
					die = die+1;
					currentplayer.moveplayer(die);
					played++;
					if (played == moved)
						{
						System.out.println("Game Number: " + (i+1));
						printboard(board);
						}

					if(currentplayer.checkwin()== true) {
						goon=false;
						gamereset();
						break;
						
						
					}
					
				}
			}
		}
	}
	//Plays number of games of specified value
	//prints out board at move value irregardless of gamenumber
	//prints out board every set number of moves
	//takes in numberofgames, moves, board
	public static void playgames3(int numberofgames, int moves, DoublyLinkedList<block> board) {
		int played = 0;
		for(int i = 0; i < numberofgames; i++) {
			boolean goon = true;
			while(goon) {
				for(int x = 0; x< contestants.length; x++) {
					Player currentplayer = contestants[x];	
					int die = rand.nextInt(6);
					die = die+1;
					currentplayer.moveplayer(die);
					played++;
					if (played == moves)
						{
						played = 0;
						System.out.println("---------------------------------------------");
						System.out.println("Game Number: " + (i+1));
						printboard(board);
						System.out.println("---------------------------------------------");
						}

					if(currentplayer.checkwin()== true) {
						goon=false;
						gamereset();
						break;
					}
				}
			}
		}
	}
	//Plays number of games of specified value
	//prints out board at end of game every set number of games
	//takes in numberofgames, games, board
	public static void playgames4(int numberofgames, int games, DoublyLinkedList<block> board) {
		int played = 1;
		for(int i = 0; i < numberofgames; i++) {
			boolean goon = true;
			while(goon) {
				for(int x = 0; x< contestants.length; x++) {
					Player currentplayer = contestants[x];	
					int die = rand.nextInt(6);
					die = die+1;
					currentplayer.moveplayer(die);
							
					if(currentplayer.checkwin()== true) {
						if (played == games){
							played = 0;
							System.out.println("---------------------------------------------");
							System.out.println("Game Number: " + (i+1));
							printboard(board);
							System.out.println("---------------------------------------------");
							}
							goon=false;
							gamereset();
							break;								
							}	
						}					
					}
					played++;
		}
	}
	}
