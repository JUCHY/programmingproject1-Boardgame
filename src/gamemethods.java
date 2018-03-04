
public class gamemethods{
		static Player[] contestants = null;
		//creates x players
		public static void createplayers(int x, DoublyLinkedList<block> playmat) {
			contestants = new Player[x];
			for(int i=0; i<x; i++) {
				Player newest = new Player(i+1, playmat);
				contestants[i] =newest;
			}
				
			}
		//resets game
		//places on players on to starting position, and clears board
		public static void gamereset() {
			for(int i = 0; i< contestants.length; i++) {
				Player checkedplayer = contestants[i];	
				checkedplayer.gamereset();	
			}
			
		}
		//prints board
		//prints in S motion
		public static void printboard(DoublyLinkedList<block> board) {		
			DoublyLinkedList<block> tempblock = new DoublyLinkedList<block>();
			boolean reverseornot = true;
			for(int i = 0; i < board.size()-1; i+=11) {
						
				for(int x = 0; x <11; x++) {
				block currentblock = board.getElementAt(i+x);
				if(reverseornot) {
				tempblock.addLast(currentblock);
				}
				else {
					tempblock.addFirst(currentblock);
				}
				
				
				}
				System.out.println(tempblock.toString());
				tempblock = new DoublyLinkedList<block>();
				reverseornot = !reverseornot;
			}
			System.out.println(board.last().toString());
			
		}
			
			


	//prints out average moves made and percent won of each player
	public static void returnwins() {	
		for(int i = 0; i< contestants.length; i++) {
			Player endloopplayer = contestants[i];	
			String win = endloopplayer.returnwins();
			int player = i+1;
			String playername = "Player "+ player;
			System.out.println(playername+"\n"+win);
		}
		
	}
	public static DoublyLinkedList<block> createboard(DoublyLinkedList<block> board) {
		
		for(int i = 0; i < 89; i++) {
			if(i == 88) {
				block newest = new block(4);
				newest.setnum(i);
				board.addLast(newest);
				}
			else {
				block newest = new block(i);
				newest.setnum(i);
				board.addLast(newest);
				}
		}
		return board;
	}

}
