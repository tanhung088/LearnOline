public class Constant {
	public static void main(String[] args) {
		final int x = 50;
		System.out.println("Constans x = " + x);
		/*
		 * x = 50;
		 * Vì là hằng số nên trong suốt toàn bộ CT sẽ ko được thay đổi.
		 * Nếu thay đổi sẽ gặp lỗi : The final local variable x cannot be assigned
		 * */
	}
}
