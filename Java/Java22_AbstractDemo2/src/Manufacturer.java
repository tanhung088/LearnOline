
public class Manufacturer {
	private String manuName;
	private String countryName;
	public Manufacturer(String manuName, String countryName) {
		super();
		this.manuName = manuName;
		this.countryName = countryName;
	}
	public String getManuName() {
		return manuName;
	}
	public void setManuName(String manuName) {
		this.manuName = manuName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
