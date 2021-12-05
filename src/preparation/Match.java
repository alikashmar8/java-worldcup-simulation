package preparation;

public class Match {
	private Team A;
	private Team B;
	private int ScoreA;
	private int ScoreB;
	public Match(Team A,Team B,int x,int y) {
		this.A = A;
		this.B = B;
		ScoreA = x;
		ScoreB = y;
	}
	
	public Match (Team A,Team B) {
		this.A = A;
		this.B = B;
	}
	public Team Winner() {
		if (ScoreA > ScoreB) 
			return A;
		else return B;
		
	}
	
	public int getScoreA() {
		return ScoreA;
	}
	public void setScoreA(int scoreA) {
		ScoreA = scoreA;
	}
	public int getScoreB() {
		return ScoreB;
	}
	public void setScoreB(int scoreB) {
		ScoreB = scoreB;
	}
	public Team getA() {
		return A;
	}
	public Team getB() {
		return B;
	}
	
	public String tostring() {
		return A.getName() + " vs " +B.getName();
	}
	
}
