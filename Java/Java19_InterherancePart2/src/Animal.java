
public class Animal {
	String nameAnimail;
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
	public Animal(String nameAnimail) {
		this.nameAnimail = nameAnimail;
	}
	
	public String getNameAnimail() {
		return nameAnimail;
	}
	public void setNameAnimail(String nameAnimail) {
		this.nameAnimail = nameAnimail;
	}
	
	//ham eat
	public void eat() {
		System.out.print("Eating.....\n");
	}
}
