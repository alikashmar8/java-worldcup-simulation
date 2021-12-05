package preparation;

import java.util.ArrayList;
import java.util.Collections;

public class Group {
	private String Name;
	private ArrayList<Team> GTeams;

	public Group(String n) {
		Name = n;
		GTeams = new ArrayList<Team>();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public ArrayList<Team> getTeams() {
		Collections.sort(GTeams);
		return GTeams;
	}

	public void AddTeam(Team T) {
		GTeams.add(T);
	}
@Override
	public String toString() {
		String s=  "Group"+Name+"\n------ \n";
		for(int i = 0 ; i<GTeams.size();i++) {
			s += GTeams.get(i).toString();
		}
		return s;
	}
	

	
	
}
