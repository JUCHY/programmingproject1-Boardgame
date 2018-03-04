public class block {
		//blocktype 0,1,2,3,4 represent block Start, red, green, blue,finish, respectively
		private int blocktype = 0;
		//Blocknum represented on board
		private int blocknum =0;
		SinglyLinkedList<Player> players = new SinglyLinkedList<Player>();
		public block(int type) {
			if(type>3) {
				type = type%3;
				if(type==0) {
					type = 3;
				}
			}
			blocktype = type;
		}
		//returns blocktype
		public int gettype() {
			return blocktype;
		}
		//places player object onto block
		public void placeplayer(Player x) {
			players.addLast(x);
		}
		//returns true if this block contains a player
		public boolean containplayers() {
			return players.size() > 0;
		}
		//removes first player to land on bock
		public void removeplayer(){
			players.removeFirst();				
		}
		//returns string representation of block
		public String toString() {
			if(containplayers()) {
				String printout = "["+ players.toString()+"]";
				return printout;				
			}
			else {
				return "[ ]";
			}
		}
			
		
		public void setnum(int something) {
			blocknum = something;
		}
		public int getnum() {
			return blocknum;
		}
		//Returns string representation of blocktype
		public String gettypecolor() {
			if(blocktype == 0) {
				return "Start";
			}
			else if(blocktype == 1) {
				return "Red";
			}
			else if(blocktype == 2) {
				return "Green";
			}
			else if(blocktype == 3) {
				return "Blue";
			}
			else if(blocktype == 4) {
				return "Finish";
			}
			else {
				return "None";
			}
			
		}
		//removes all player on board
		public void reset(){
			while(players.size()>0) {
				players.removeFirst();
			}
		}
	}

