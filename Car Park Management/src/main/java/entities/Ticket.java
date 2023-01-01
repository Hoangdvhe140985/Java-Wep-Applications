package entities;

import java.sql.Time;

public class Ticket {
	private int ticketId;
	private Time bookingTime;
	private String customerName;
	private String licensePlate;
	private int tripId;
	private String tripName;
	

	public Ticket() {
		
	}

	public Ticket(int ticketId, Time bookingTime, String customerName, String licensePlate, int tripId) {
		this.ticketId = ticketId;
		this.bookingTime = bookingTime;
		this.customerName = customerName;
		this.licensePlate = licensePlate;
		this.tripId = tripId;
	}

	public Ticket(int ticketId, Time bookingTime, String customerName, String licensePlate, int tripId,
			String tripName) {
		super();
		this.ticketId = ticketId;
		this.bookingTime = bookingTime;
		this.customerName = customerName;
		this.licensePlate = licensePlate;
		this.tripId = tripId;
		this.tripName = tripName;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Time getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Time bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	
	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", bookingTime=" + bookingTime + ", customerName=" + customerName
				+ ", licensePlate=" + licensePlate + ", tripId=" + tripId + "]";
	}
	
	
	
	
	
}
