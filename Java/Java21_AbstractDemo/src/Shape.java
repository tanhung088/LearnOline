
public abstract class Shape {
	protected Coordinate Coor;

	//ham dung co doi so
	public Shape(Coordinate coor) {
		this.Coor = coor;
	}

	public Coordinate getCoor() {
		return Coor;
	}

	public void setCoor(Coordinate coor) {
		Coor = coor;
	}
	
	public abstract double Area();
	
}
