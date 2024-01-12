import java.util.Scanner;

public class CafeReceipt {
	private String TypeCafe;
	private float PriceFor1kg;
	private double Weight;
	
	public CafeReceipt() {
		
	}
	public CafeReceipt(String TypeCafe, float PriceFor1kg, double Weight) {
		this.TypeCafe = TypeCafe;
		this.PriceFor1kg = PriceFor1kg;
		this.Weight = Weight;
	}
	
	public double SumReciept() {
		return this.PriceFor1kg*this.Weight;
	}
	
	//ham kiem tra khoi luong mua cua khach hang co lon hon khoi luong cua mat hang hien tai hay khong
	public boolean CheckWeight() {
		Scanner sc = new Scanner(System.in);
		double InputWeight;
		System.out.println("Enter weight to buy: ");
		InputWeight = sc.nextDouble();
		if(this.Weight < InputWeight) {
			return true;
		}else {
			return false;
		}
	}
}
