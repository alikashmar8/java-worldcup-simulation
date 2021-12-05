package Driver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import preparation.*;
import individual.*;

public class Game {
	public static ArrayList<Player> Players;
	public static ArrayList<Team> Teams;
	public static ArrayList<Team> GTeams;
	public static ArrayList<Team> Q1;
	public static ArrayList<Team> Q2;
	public static ArrayList<Group> Groups;
	public static ArrayList<Integer> num;
	public static ArrayList<Match> Matches;
	public static ArrayList<Team> Qualified;
	public static Scanner in = new Scanner(System.in);
	public static Random rand = new Random();
	


	
	public static void save() throws Exception{
		DataOutputStream team;
		try {
			team = new DataOutputStream(new FileOutputStream("Teams.txt"));
			
                        
			for(int i = 0; i< Teams.size(); i ++){
				team.writeUTF(Teams.get(i).getName());
				team.writeUTF(Teams.get(i).getcoach().getName());
                team.writeInt(Teams.get(i).getcoach().getAge());
                team.writeInt(Teams.get(i).getcoach().getSkill());
                
                Players = Teams.get(i).getPlayers();
                                team.writeInt(Players.size());
                                
                                for(int j=0;j<Players.size();j++ ){
				team.writeUTF(Players.get(j).getName());
                                team.writeInt(Players.get(j).getAge());
                                team.writeInt(Players.get(j).getPlayerNumber());
                                team.writeInt(Players.get(j).getOvr());
                           
                                }
			
                        }
                       team.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			                 System.out.println("Eror in save");
		
		}
	}
        
        
        public static void Load() throws Exception{
		DataInputStream load;
		String nT,Cn,Pn;
                int Ca,Cs,Pa,PN,ovr,pSize;
                int i=0;
		
		try {
			load = new DataInputStream(new FileInputStream("Teams.txt"));
			
				while(load.available()>0){
				nT =  load.readUTF();
				Cn = load.readUTF();
				Ca=load.readInt();
                                Cs=load.readInt();
                                Team T = new Team(nT,new Coach(Cn,Ca,Cs));
                                Teams.add(T);
                                pSize = load.readInt();
                                for(int j=0;j< pSize;j++){
                                Pn =  load.readUTF();
                                Pa=load.readInt();
                                PN=load.readInt();
                                ovr=load.readInt();
                               
                                Player P=new Player(Pn,Pa,PN,ovr);
				Players.add(P);
                                Team t=Teams.get(i);
                                t.AddPlayer(P);
                                }
                                i++;
                                
                                }
			load.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			                 System.out.println("Error in load");
		}
        }
        
	public static int getChoice0() {
		int choice;
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("1 - Editing menu        ><");
		System.out.println("2 - Start tournament    ><");
		System.out.println("0 - Exit                ><");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("Enter your choice");
		choice = in.nextInt();
		return choice;
	}
	public static int getChoice1() {
		int choice;
		System.out.println("__________________________________");
		System.out.println("1 - Create a team                 |");
		System.out.println("2 - print list of teams           |"); 
		System.out.println("3 - Create a player               |"); 
		System.out.println("4 - Print Team information        |");
		System.out.println("5 - Edit Team name                |");
		System.out.println("6 - Remove a team                 |");
		System.out.println("0 - Back                          |");
		System.out.println("__________________________________|");
		System.out.println("Enter your choice");
		choice = in.nextInt();
		return choice;
	}
	public static int getChoice2() {
		int choice;
		System.out.println("______________________________________");
		System.out.println("1 - Draw group stage                  |");
		System.out.println("2 - Assign group stage points         |");
		System.out.println("3 - Draw round 16                     |");
		System.out.println("4 - Simulate the results of round 16  |");
		System.out.println("5 - Draw the quarter finals           |");
		System.out.println("6 - simulll the quarter finals        |");
		System.out.println("7 - Draw semi final match             |");
		System.out.println("8 - Give semi final scores            |");
		System.out.println("9 - Play the final                    |");
		System.out.println("0 - Back                              |");
		System.out.println("______________________________________|");
		System.out.println("Enter your choice");
		choice = in.nextInt();
		return choice;
	}

	public static void addPlayer() {
		String Name;
		int Age;
		int i = 0;
		Player p;
		int Num;
		int ovr;
		String Tname;
		Team T = null;
		System.out.println("---------------------------");
		System.out.println("You will add a new player");
		System.out.println("---------------------------");
		System.out.println("Enter his name:");
		Name = in.next();
		System.out.println("Enter his age: ");
		Age = in.nextInt();
		System.out.println("Enter his shirt number :");
		Num = in.nextInt();
		System.out.println("enter his overall rating :");
		ovr = in.nextInt();
		p = new Player(Name, Age, Num, ovr);
		System.out.println("In which team does he play ?");
		System.out.println("Available teams :");
		printListOfTeams();
		System.out.println("Type the name of the wanted team :");
		Tname = in.next();

		for (i = 0; i < Teams.size(); i++) {
			if (Teams.get(i).getName().equalsIgnoreCase(Tname)) {
				T = Teams.get(i);
			}
		}
		T.AddPlayer(p);
	}

	public static void printListOfTeams() {
		for (int i = 0; i < Teams.size(); i++) {
			System.out.println(Teams.get(i).getName());
			System.out.println("---------------------------");
			// Teams.get(i).printlistofplayers();

		}
		System.out.println(Teams.size());
	}

	public static void CreateTeam() {

		String teamName;
		String coachname;
		int coachage;
		int skill;
		Coach c;
		Team T;
		// boolean addmore;
		System.out.println("---------------------------");
		System.out.println("You will Create a new team");
		System.out.println("---------------------------");
		System.out.println("enter his name:");
		teamName = in.next();
		System.out.println("---------------------------");
		System.out.println("what is his coach name ?");
		System.out.println("---------------------------");
		coachname = in.next();
		System.out.println("enter his age: ");
		coachage = in.nextInt();
		System.out.println("---------------------------");
		System.out.println("how much is his managment skill ?");
		skill = in.nextInt();
		c = new Coach(coachname, coachage, skill);

		T = new Team(teamName, c);
		Teams.add(T);
	}

	public static void PrintInfo() {
		Team T = null;
		String name;
		int i;
		boolean correct = true;
		// ArrayList <Player> Players;
		System.out.println("Available Teams:");
		printListOfTeams();
		System.out.println("--------------------");
		while (correct) {
		System.out.println("Type the name of the Team you want to display its info :");
		System.out.println("--------------------");
		name = in.next();
		for ( i = 0; i < Teams.size(); i++) {
			if (Teams.get(i).getName().equalsIgnoreCase(name)) {
				T = Teams.get(i);
				break;
			}
		}
			if (i == Teams.size()) {
				System.out.println("Please enter a correct name !");
			}
			else correct = false;
		
		}
	

		System.out.println("The Team is : " + T.getName());
		System.out.println("--------------------");
		System.out.println("His coach name is : " + T.getcoach().getName());
		System.out.println("--------------------");
		Players = T.getPlayers();
		System.out.println("His squad is : ");
		System.out.println("--------------------");
		for ( i = 0; i < Players.size(); i++) {
			System.out.println(Players.get(i).getPlayerNumber() + " - " + Players.get(i).getName() + "   age : "
					+ Players.get(i).getAge());
		}
	}

	public static void editTeamName() {
		String Name, Tname;
		Team T = null;
		System.out.println("Available teams :");
		printListOfTeams();
		System.out.println("Type team name you want to change :");
		Name = in.next();
		for (int i = 0; i < Teams.size(); i++) {
			if (Teams.get(i).getName().equals(Name)) {
				T = Teams.get(i);
			}
		}
		System.out.println("Enter the new name :");
		Tname = in.next();
		T.setName(Tname);

	}

	public static void removeTeam() {
		String name;
		System.out.println("Available Teams : ");
		printListOfTeams();
		System.out.println("Type the name of th team you want to remove :");
		name = in.next();
		for (int i = 0; i < Teams.size(); i++) {
			if (Teams.get(i).getName().equals(name)) {
				Teams.remove(i);
				System.out.println("REMOVING DONE !!");
				break;
			}
		}
	}

	public static int drawGroupStage() {
		 if(Teams.size()!=32) {
		 System.out.println("The number of Teams should be 32 !!");
		 System.out.println("There is now "+ Teams.size()+" Teams");
		 return 0;
		 }
		Group G;
		String name;

		for (int i = 1; i < 9; i++) {
			System.out.println("Enter the group of number " + i + " name (A,B,C,D,E,F,G,H....)");
			name = in.next();
			G = new Group(name);
			for (int j = 0; j < 4; j++) {
				int randomIndex = rand.nextInt(Teams.size());
				G.AddTeam(Teams.get(randomIndex));
				Teams.remove(randomIndex);
			}
			Groups.add(G);
		}
		for(int i = 0 ; i<Groups.size();i++)
		System.out.println(Groups.get(i).toString());
		return 0;
	}
	public static void assignGroupPoints() {
		Group G;
		int k;

		ArrayList<Team> T = new ArrayList<Team>();
		for (int i = 0; i < Groups.size(); i++) {
			G = Groups.get(i);
			T = G.getTeams();

			for (k = 0; k < 9; k++) {
				num.add(k);
			}

			for (int j = 0; j < 4; j++) {
				int randomIndex = rand.nextInt(num.size());
				int pts = num.get(randomIndex);
				T.get(j).setGroupPoints(pts);
				num.remove(randomIndex);

			}
			num.removeAll(num);
		}
		for(int i= 0;i<Groups.size();i++) {
		Collections.sort(Groups.get(i).getTeams());
		System.out.println(Groups.get(i).toString());
		}
		//System.out.println(Groups);
	}

	

	public static void Round16() {
		Group G;
		Match M;
		String A;
		Team X,Y;
		for(int i=0;i<Groups.size();i++) {
			G = Groups.get(i);
			GTeams = G.getTeams();
			Q1.add(GTeams.get(0));
			Q2.add(GTeams.get(1));
		}

		System.out.println("Matches of round 16 :");
		System.out.println("#####################");
		for (int i = 0 ;i<Q1.size();i++) {
			int random = rand.nextInt(Q2.size());
			X = Q1.get(i);
			Y = Q2.get(random);
			M = new Match(X,Y);
			System.out.println("-------------");
			A = M.tostring();
			System.out.println(A);
			Q2.remove(random);
			Matches.add(M);
		}	
		System.out.println("#####################");
	}

	public static void giveScore16() {
		Match M;
		Team T;
		int ScoreA, ScoreB;
		num.removeAll(num);
		System.out.println("The scores for this round are");
		System.out.println("[____][____][____][____][____]");
		for (int i = 0; i < Matches.size(); i++) {
			for (int k = 0; k < 5; k++) {
				num.add(k);
			}
			int random = rand.nextInt(num.size());

			M = Matches.get(i);
			ScoreA = num.get(random);
			num.remove(random);
			int random1 = rand.nextInt(num.size());
			ScoreB = num.get(random1);
			M.setScoreA(ScoreA);
			M.setScoreB(ScoreB);
			T = M.Winner();
			System.out.println("\n"+M.getA().getName()+" "+M.getScoreA()+" - "+M.getScoreB()+" "+M.getB().getName());
			Qualified.add(T);
			num.removeAll(num);
		}
		
	}

	public static void quarterFinal() {
		Matches.removeAll(Matches);
		int random;
		Team A, B;
		Match M;
		String S;
		System.out.println("The draw for quarter finals are :");
		System.out.println("----------------------------------");
		for ( ; !Qualified.isEmpty(); ) {
			random = rand.nextInt(Qualified.size());
			A = Qualified.get(random);
			Qualified.remove(random);
			random = rand.nextInt(Qualified.size());
			B = Qualified.get(random);
			Qualified.remove(random);
			M = new Match(A, B);
			S = M.tostring();
			System.out.println(S);
			System.out.println("------------------------");
			Matches.add(M);
		}
	}

	public static void assignQuarterFinalsPoints() {
		//Qualified.removeAll(Qualified);
		int random;
		int ScoreA, ScoreB;
		Match M;
		Team T;
		num.removeAll(num);
		System.out.println("The scores of this round are :");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		for (int i = 0; i < Matches.size(); i++) {
			for (int k = 0; k < 5; k++) {
				num.add(k);
			}
			M = Matches.get(i);
			random = rand.nextInt(num.size());
			ScoreA = num.get(random);
			num.remove(random);
			random = rand.nextInt(num.size());
			ScoreB = num.get(random);
			M.setScoreA(ScoreA);
			M.setScoreB(ScoreB);
			System.out.println("\n"+M.getA().getName()+" "+M.getScoreA()+" - "+M.getScoreB()+" "+M.getB().getName());
			T = M.Winner();
			Qualified.add(T);
		}
	}
	public static void drawSemiFinal() {
		Team A,B;
		Match M;
		int i,random;
		Matches.removeAll(Matches);
		System.out.println("Semi final matches are :");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
		for(i=0;i<Qualified.size();i++) {
			random = rand.nextInt(Qualified.size());
			A = Qualified.get(random);
			Qualified.remove(random);
			random = rand.nextInt(Qualified.size());
			B = Qualified.get(random);
			Qualified.remove(random);
			M = new Match(A,B);
			System.out.println( M.getA().getName()+" vs "+M.getB().getName());
			System.out.println("-----------------------");
			Matches.add(M);
		}
		
	}
	public static void giveSemiFinalScore() {
		int i,goals;
		Match M;
		Team T,A;
		Qualified.removeAll(Qualified);
		System.out.println("_________________________");
		System.out.println("Give score for match :   |");
		System.out.println("_________________________");
		for(i = 0; i<Matches.size();i++) {
			M = Matches.get(i);
			System.out.println( M.getA().getName()+" vs "+M.getB().getName());
			System.out.println("------------------");
			System.out.print(M.getA().getName()+" : ");
			goals = in.nextInt();
			M.setScoreA(goals);
			System.out.print(M.getB().getName() + " : ");
			goals = in.nextInt();
			System.out.println("*******************");
			M.setScoreB(goals);
			T = M.Winner();
			Qualified.add(T);
			//Matches.remove(i);
		}
		Matches.removeAll(Matches);
		A = Qualified.get(0);
		T = Qualified.get(1);
		M = new Match(T,A);
		System.out.println("The final match of the world cup is :");
//		s = M.toString();
//		System.out.println(s);
		System.out.println("*******************************************************");
		System.out.println("** "+ M.getA().getName()+" vs "+M.getB().getName()+" **");
		System.out.println("********************************************************");
		Matches.add(M);
	}
	public static void giveFinalScore() {
		Team T;
		int goals;
		Match M = Matches.get(0);
		System.out.println("Give the score of the final match !!");
		System.out.println(" ");
		System.out.println( M.getA().getName()+" vs "+M.getB().getName());
		System.out.println("----------------------");
		System.out.print(M.getA().getName()+" : ");
		goals = in.nextInt();
		M.setScoreA(goals);
		System.out.print(M.getB().getName() + " : ");
		goals = in.nextInt();
		M.setScoreB(goals);
		T = M.Winner();
		System.out.println("*****************************************************************************");
		System.out.println("*****************************************************************************");
		System.out.println("*** Congratulations to " + T.getName() + " for winning the 2018 world cup ***");
		System.out.println("*****************************************************************************");	
		System.out.println("*****************************************************************************");
	}

	public static void main(String[] args) throws Exception {
		int choice,choice1,choice2;
		boolean repeat = true;
		Players = new ArrayList<Player>();
		Teams = new ArrayList<Team>();
		Groups = new ArrayList<Group>();
		num = new ArrayList<Integer>();
		Q1 = new ArrayList<Team>();
		Q2 = new ArrayList<Team>();
		GTeams = new ArrayList<Team>();
		Matches = new ArrayList<Match>();
		Qualified = new ArrayList<Team>();
		
		Load();
		while (repeat) {
			choice = getChoice0();
			while (choice==1) {
				choice1 = getChoice1();
				switch (choice1) {
			case 1:
				CreateTeam();
				save();
				break;
			case 2:
				printListOfTeams();
				break;
			case 3:
				addPlayer();
				save();
				break;
			case 4:
				PrintInfo();
				break;
			case 5:
				editTeamName();
				save();
				break;
			case 6:
				removeTeam();
				save();
				break;
			case 0 :
				choice = 3;
				break;
			default :
				System.out.println("Please enter a valid choice !!!");
				break;
					

				}
			}
				
			while(choice == 2) {
				choice2 = getChoice2();
				switch (choice2) {
				case 1:
					drawGroupStage();
					break;
				case 2:
					assignGroupPoints();
					break;
				case 3:
					Round16();
					break;
				case 4:
					giveScore16();
					break;
				case 5:
					quarterFinal();
					break;
				case 6:
					assignQuarterFinalsPoints();
					break;
				case 7 :
					drawSemiFinal();
					break;
				case 8 :
					giveSemiFinalScore();
					break;
				case 9 :
					giveFinalScore();
					break;
				case 0 :
					choice = 3;
					break;
				default :
					System.out.println("Please enter a valid choice !!");
					break;
				}
			}
		while (choice == 0) {
			repeat = false;
			choice = 3;
		}
		}
	}
}