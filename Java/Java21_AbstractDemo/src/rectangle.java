
public class rectangle extends Shape {
	private int length, height;

	public rectangle(Coordinate coor, int length, int height) {
		super(coor);
		this.length = length;
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public double Area() {
		return ((double)this.length*this.height);
	}
	
}
