package individual;

public class Person {
	private String Name;
	private int Age;
	Person (String n,int x){
		Name = n;
		Age = x;
	}

	
	
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}




	public String toString() {
		return "Person [Name=" + Name + ", Age=" + Age + "]";
	}
	
}
