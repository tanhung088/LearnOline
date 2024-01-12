
public class Circle extends Shape {
	private double r;

	public Circle(Coordinate coor, double r) {
		super(coor);
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public double Area() {
		return Math.PI*this.r*this.r;
	}
	
		
}
