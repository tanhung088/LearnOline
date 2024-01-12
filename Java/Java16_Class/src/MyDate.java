import java.util.Objects;

public class MyDate {
	private int day;
	private int month;
	private int year;
	// tao constructor no parameter
	public MyDate() {

	}
	
	//tao constructor with paramter
	public MyDate(int day, int month, int year) {
		if (day >= 1 && day <= 31) {
			this.day = day;
		} else {
			this.day = 1;
		}
		if (month >= 1 && month <= 12) {
			this.month = month;
		} else {
			this.month = 1;
		}
		if (year >= 1) {
			this.year = year;
		}else {
			this.year = 1;
		}
	}
	
	// get and set
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day >= 1 && day <= 31) {
			this.day = day;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month >= 1 && month <= 31) {
			this.month = month;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year >= 1 && year <= 31) {
			this.year = year;
		}
	}

	//ham in ra ngay
	public void printDay() {
		System.out.println("Day :" + this.day);
	}
	//ham in ra month
	public void printMonth() {
		System.out.println("Month :" + this.month);
	}
	//ham in ra year
	public void printYear() {
		System.out.println("Year :" + this.year);
	}
	//ham in ra day-month-year
	public void printAll() {
		System.out.println("Date : "+ this.day + "-" + this.month + "-" + this.year);
	}

	//ham toString
	@Override
	public String toString() {
		return "MyDate [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		return this.day == other.day && this.month == other.month && this.year == other.year;
	}
	
	
	
}
