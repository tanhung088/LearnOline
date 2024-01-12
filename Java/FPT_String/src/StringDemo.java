
public class StringDemo {
	public static void main(String[] args) {
		String Name = "Tien Sy";
		// Length
		System.out.println("Length = " + Name.length());
		
		// Lay ki tu tai vi tri index = 2
		System.out.println("Element  index 2 is : " + Name.charAt(2));
		
		//Ghep chuoi
		System.out.println("Add string ' Tran' :" + (Name.concat("Tran")));
	}
}
