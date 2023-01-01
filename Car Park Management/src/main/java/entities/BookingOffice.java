package entities;

import java.sql.Date;

public class BookingOffice {
	private int officeId;
	private Date endContractDeadline;
	private String officeName;
	private String officePhone;
	private String officePlace;
	private int officePrice;
	private Date startContractDealine;
	private int tripId;
	private Trip trip;
	
	public BookingOffice() {
		
	}

	public BookingOffice(int officeId, Date endContractDeadline, String officeName, String officePhone,
			String officePlace, int officePrice, Date startContractDealine, int tripId) {
		this.officeId = officeId;
		this.endContractDeadline = endContractDeadline;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDealine = startContractDealine;
		this.tripId = tripId;
	}
	
	

	public BookingOffice(Date endContractDeadline, String officeName, String officePhone, String officePlace,
			int officePrice, Date startContractDealine, Trip trip) {
		super();
		this.endContractDeadline = endContractDeadline;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDealine = startContractDealine;
		this.trip = trip;
	}

	public BookingOffice(int officeId, Date endContractDeadline, String officeName, String officePhone,
			String officePlace, int officePrice, Date startContractDealine, Trip trip) {
		super();
		this.officeId = officeId;
		this.endContractDeadline = endContractDeadline;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDealine = startContractDealine;
		this.trip = trip;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public Date getEndContractDeadline() {
		return endContractDeadline;
	}

	public void setEndContractDeadline(Date endContractDeadline) {
		this.endContractDeadline = endContractDeadline;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOfficePlace() {
		return officePlace;
	}

	public void setOfficePlace(String officePlace) {
		this.officePlace = officePlace;
	}

	public int getOfficePrice() {
		return officePrice;
	}

	public void setOfficePrice(int officePrice) {
		this.officePrice = officePrice;
	}

	public Date getStartContractDealine() {
		return startContractDealine;
	}

	public void setStartContractDealine(Date startContractDealine) {
		this.startContractDealine = startContractDealine;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	@Override
	public String toString() {
		return "BookingOffice [officeId=" + officeId + ", endContractDeadline=" + endContractDeadline + ", officeName="
				+ officeName + ", officePhone=" + officePhone + ", officePlace=" + officePlace + ", officePrice="
				+ officePrice + ", startContractDealine=" + startContractDealine + ", tripId=" + tripId + "]";
	}
	
	
	
	
}
