
public class test {
	public static void main(String[] args) {
		Manufacturer mn1 = new Manufacturer("Hang 1", "Viet Nam");
		Manufacturer mn2 = new Manufacturer("Hang 2", "USA");
		Manufacturer mn3 = new Manufacturer("Hang 3", "Indian");
		
		transport t1 = new plane("May bay 1", mn1, "Xang");
		t1.acceleration();
		System.out.println("Manufacturer of t1 : " +t1.getName());
		System.out.println("GOi cac ham co trong t1 may bay ");
		plane p1 = new plane();
		p1.planeLand();
		p1.planeTakingOff();
	}
}
