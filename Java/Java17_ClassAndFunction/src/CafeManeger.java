
public class CafeManeger {
	public static void main(String[] args) {
		CafeReceipt cf = new CafeReceipt("Trung Nguyen", 100, 2);
		System.out.println("Receipt = " + cf.SumReciept());
		System.out.println("CheckWieght is " + cf.CheckWeight());
	}
}
