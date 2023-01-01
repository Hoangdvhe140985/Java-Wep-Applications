package entities;

public class Car {
	private String licensePlate;
	private String carColor;
	private String carType;
	private String company;
	private int parkId;
	private String parkName;
	
	
	public Car() {
		
	}


	public Car(String licensePlate, String carColor, String carType, String company, int parkId) {
		this.licensePlate = licensePlate;
		this.carColor = carColor;
		this.carType = carType;
		this.company = company;
		this.parkId = parkId;
	}


	public Car(String licensePlate, String carType, String carColor, String company, int parkId, String parkName) {
		super();
		this.licensePlate = licensePlate;
		this.carColor = carColor;
		this.carType = carType;
		this.company = company;
		this.parkId = parkId;
		this.parkName = parkName;
	}


	public String getParkName() {
		return parkName;
	}


	public void setParkName(String parkName) {
		this.parkName = parkName;
	}


	public String getLicensePlate() {
		return licensePlate;
	}


	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}


	public String getCarColor() {
		return carColor;
	}


	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}


	public String getCarType() {
		return carType;
	}


	public void setCarType(String carType) {
		this.carType = carType;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public int getParkId() {
		return parkId;
	}


	public void setParkId(int parkId) {
		this.parkId = parkId;
	}


	@Override
	public String toString() {
		return "Car [licensePlate=" + licensePlate + ", carColor=" + carColor + ", carType=" + carType + ", company="
				+ company + ", parkId=" + parkId + "]";
	}
	
	
	
	
}
