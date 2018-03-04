public class Player{
	//players position on the board as numerical value
	//first tile is represented by 0, last tile is 88
	int position = 0;
	int totalwins = 0;
	DoublyLinkedList<block> board= null;
	//this is where the player's location on the board is stored
	block currentposition = null;
	//current position is set to resetposition eachtime the game is reset
	block resetposition = null;
	//playerid, determines whether the player is player 1,2,3 or 4
	int playerid = 0;
	//number of moves made during the game
	int move = 0;
	//total number of gamesplayed
	float gamesplayed = 0;
	//singlelinkedlist representation of moves made each game
	SinglyLinkedList<Integer> moves = new SinglyLinkedList<Integer>();
	//represents whether this player has won the game
	boolean won = false;
	public Player(int player, DoublyLinkedList<block> boardo) {
		playerid = player;
		board = boardo;
		currentposition = boardo.first();
		resetposition = boardo.first();
		currentposition.placeplayer(this);
	}
	
	public void moveplayer(int x) {
		move++;
		
		if(position +x >=88) {
			currentposition.removeplayer();
			currentposition = board.last();
			position = position +x;
			currentposition.placeplayer(this);
			return;
			
		}
		int change = x;
		currentposition.removeplayer();
		block newplace = board.getElementAt(position +x);
		if(newplace.containplayers()) {
			change = change -2;
			
		}
		else if(newplace.gettype()==3) {
			change = change + 2;			
		}
		else if(newplace.gettype() == 1) {
			change = change -1;			
		}
		//if 87th square(which is blue),wherein there's no player on that square, is hit, player will win regardless
		if(position +change >=88) {
			currentposition.removeplayer();
			currentposition = board.last();
			position = position +change;
			currentposition.placeplayer(this);
			return;
			
		}
		
		block finalposition = board.getElementAt(position+change);
		currentposition = finalposition;
		currentposition.placeplayer(this);
		position = position + change;
		
	}
	//wins if on position 88(last tile on the board)
	public boolean checkwin() {
		if(position>=88) {
			won = true;
			totalwins++;
			return true;
		}
		else {
			return false;
		}
	}
	//resets players position on the board
	public void gamereset() {
		if(won) {
		moves.addLast(move);
		won = false;
		}
		position = 0;
		move = 0;
		gamesplayed++;
		if(currentposition!=null) {
		currentposition.removeplayer();
		}
		currentposition = resetposition;
		currentposition.placeplayer(this);
	}
	//returns win ration as a percent and the averages moves made.
	public String returnwins() {
		int avgmove = averagemove();
		return "Wins: " + (totalwins/gamesplayed)*100+"%" +"\n"+"Average moves: "+ avgmove;
	}
	//returns playerid
	public int getplayerid() {
		return playerid;
	}
	//returns string representation of the player
	public String toString() {
		String x = Integer.toString(playerid);
		return x;
	}
	//calculates the average move made
	//clears move singlylinkedlist
	public int averagemove() {
		int sum = 0;
		int size = moves.size();
		if(size!=0) {
			for(int x =0; x < size; x++) {
				int num = moves.removeFirst();
				sum = sum+num;
			}
			sum = sum/size;
		}
		return sum;		
		
	}
	//calculates the average move made
	//does not clear move singlylinkedlist
	public int averagemove2() {
		int sum = 0;
		int size = moves.size();
		if(size!=0) {
			for(int x =0; x < size; x++) {
				int num = moves.removeFirst();
				moves.addLast(num);
				sum = sum+num;
			}
			sum = sum/size;
		}
		return sum;		
		
	}
}
	