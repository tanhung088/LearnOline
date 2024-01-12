
public class Person {
	private String Name;
	private String Gender;
	private int Age;
	public Person() {
	}
	public Person(String name, String gender, int age) {
		Name = name;
		Gender = gender;
		Age = age;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	// tao cac ham cho class cha
	public void eat() {
		System.out.print("Eating cake");
	}
	public void sleep() {
		System.out.print("Sleeping...");
	}
}
