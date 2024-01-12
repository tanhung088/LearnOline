public class ConvertDemo {
	public static void main(String[] args) {
		int a = 5;
		int b = 6;
		//ep kieu implicit
		float c = a;
		float d = b;		
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		//ep kieu explicit
		int e = (int)c;
		int f = (int)d;
		System.out.println("e = " + e);
		System.out.println("f = " + f);
		// ep kieu giua bien voi doi tuong
		int x = new Integer(5);
		System.out.println("x = " + x);
	}
}
