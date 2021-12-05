package preparation;

import java.util.ArrayList;

import individual.*;;

public class Team implements Comparable<Team> {
	private String Name;
	private Coach coach;
	private ArrayList<Player> Players;
	private int GroupPoints;

	public Team(String n, Coach ch) {
		Name = n;
		coach = ch;
		Players = new ArrayList<Player>();
		GroupPoints = 0;
	}

	public String getName() {
		return Name;
	}

	public void setName(String n) {
		Name = n;
	}

	public Coach getcoach() {
		return coach;
	}

	public void setC(Coach c) {
		coach = c;
	}

	public ArrayList<Player> getPlayers() {
		return Players;
	}

	public void setPlayers(ArrayList<Player> players) {
		Players = players;
	}

	public int getGroupPoints() {
		return GroupPoints;
	}

	public void setGroupPoints(int groupPoints) {
		GroupPoints = groupPoints;
	}

	public void AddPlayer(Player P) {
		Players.add(P);
	}
	public String toString() {
		return  "\n"+Name+" : "+GroupPoints+"\n";
	}

	@Override
	public int compareTo(Team t) {
		return t.GroupPoints - this.GroupPoints;
	}

}
