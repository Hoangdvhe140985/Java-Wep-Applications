package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Employee;
import entities.Trip;

public interface TripDAO {
	Trip getTripById(int id) throws SQLException;
	
	boolean addTrip(Trip trip) throws SQLException;
	
	boolean deleleTrip(int id) throws SQLException;
	
	List<Trip> getAllTrip() throws SQLException;
	
	boolean updateTrip(Trip trip) throws SQLException;
	
	public int getNumberOfTrips() throws SQLException;
	
	public List<Trip> getTripsByIndexPage(int index, int pageSize) throws SQLException;
	
	List<Trip> getTripsByDayMonthYear(int day, int month, int year) throws SQLException;
	
	int getNumberOfTripsByDayMonthYear(int day, int month, int year) throws SQLException;
	
	public List<Trip> getTripsByDMYAndIndexPage(int day, int month, int year, int index, int pageSize) throws SQLException;
	
	List<Trip> getTrip() throws SQLException;
}
