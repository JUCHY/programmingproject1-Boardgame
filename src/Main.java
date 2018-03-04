
public class Main extends play{
	public static void main(String[] args) {	
			//createsboard
			DoublyLinkedList<block> board= new DoublyLinkedList<block>();
			board = createboard(board);
			//createsplayers
			gamemethods.createplayers(4,board);
			//plays
			playgames1(100,25,board);
			//playgames2(200,1200,board);
			//playgames3(1000, 50, board);
			//playgames4(1000,50,board);
			System.out.println("---------------------------------------------");
			//returns avg moves and win %
			gamemethods.returnwins();
			
		
			
			
}

}
