package individual;

public class Player extends Person {
	private int PlayerNumber;
	private int ovr;
	
	public Player(String n,int a,int num,int rate){
		super(n,a);
		PlayerNumber = num;
		ovr = rate;
		}

	
	public int getPlayerNumber() {
		return PlayerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		PlayerNumber = playerNumber;
	}
	public int getOvr() {
		return ovr;
	}
	public void setOvr(int ovr) {
		this.ovr = ovr;
	}
	public String toString() {
		return super.toString()+"\n his number is "+ovr+"Shirt Number"+PlayerNumber;
		
		
	}

}
