package individual;

public class Coach extends Person{
	private int Skill;
	public Coach (String n,int x,int s){
		super(n,x);
		Skill=s;
	}
	
	public int getSkill() {
		return Skill;
	}
	public void setSkill(int skill) {
		Skill = skill;
	}


	public String toString() {
		return super.toString()+"\n Skill = " + Skill;
	}
	

}
