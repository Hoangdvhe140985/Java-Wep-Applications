package dao.impl;

import java.sql.Date;
import java.sql.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TripDAO;
import entities.Trip;
import utils.DBConnection;
import utils.SQLComand;

public class TripDAOImpl implements TripDAO {
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	@Override
	public Trip getTripById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Trip trip = new Trip();
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_TRIP_BY_ID);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while(rs.next()) {
				trip = new Trip(rs.getInt("tripId"),
						rs.getInt("bookedTicketNumber"),
						rs.getString("carType"),
						rs.getDate("departureDate"),
						rs.getTime("departureTime"),
						rs.getString("destination"),
						rs.getString("driver"),
						rs.getInt("maximumOnlineTicketNumber"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return trip;
	}

	@Override
	public boolean addTrip(Trip trip) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.ADD_TRIP);
			pre.setInt(1, 0);
			pre.setString(2, trip.getCarType());
			pre.setDate(3, trip.getDepartureDate());
			pre.setTime(4, trip.getDepartureTime());
			pre.setString(5, trip.getDestination());
			pre.setString(6, trip.getDriver());
			pre.setInt(7, trip.getMaximumOnlineTicketNumber());
			row = pre.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return row > 0;
	}

	@Override
	public boolean deleleTrip(int id) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.DELETE_TRIP);
			pre.setInt(1, id);
			row = pre.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return row > 0;
	}

	@Override
	public List<Trip> getAllTrip() throws SQLException {
		List<Trip> listTrip = new ArrayList<>();
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_ALL_TRIPS);
			rs = pre.executeQuery();
			while(rs.next()) {
				listTrip.add(new Trip(rs.getInt("tripId"),
						rs.getInt("bookedTicketNumber"), 
						rs.getString("carType"),
						rs.getDate("departureDate"),
						rs.getTime("departureTime"),
						rs.getString("destination"),
						rs.getString("driver"),
						rs.getInt("maximumOnlineTicketNumber")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return listTrip;
	}

	@Override
	public boolean updateTrip(Trip trip) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.UPDATE_TRIP);
			pre.setInt(1, trip.getBookedTicketNumber());
			pre.setString(2, trip.getCarType());
			pre.setDate(3, trip.getDepartureDate());
			pre.setTime(4, trip.getDepartureTime());
			pre.setString(5, trip.getDestination());
			pre.setString(6, trip.getDriver());
			pre.setInt(7, trip.getMaximumOnlineTicketNumber());
			pre.setInt(8, trip.getTripId());
			row = pre.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return row > 0;
	}

	@Override
	public int getNumberOfTrips() throws SQLException {
		// TODO Auto-generated method stub
		int number = 0;
		con = DBConnection.getIntansce().getConnection();
		PreparedStatement pre = con.prepareStatement(SQLComand.GET_NUMBERS_TRIP);
		ResultSet rs = pre.executeQuery();
		if (rs.next()) {
			number = rs.getInt(1);
		}
		return number;
	}

	@Override
	public List<Trip> getTripsByIndexPage(int index, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		List<Trip> list = new ArrayList<>();
		con = DBConnection.getIntansce().getConnection();
		pre = con.prepareStatement(SQLComand.GET_TRIP_BY_INDEX);
		pre.setInt(1, (index - 1) * pageSize);
		pre.setInt(2, pageSize);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			Trip trip = new Trip(rs.getInt("tripId"), rs.getInt("bookedTicketNumber"), rs.getString("carType"),
					rs.getDate("departureDate"), rs.getTime("departureTime"), rs.getString("destination"),
					rs.getString("driver"), rs.getInt("maximumOnlineTicketNumber"));
			list.add(trip);
		}
		return list;
	}

	@Override
	public List<Trip> getTripsByDayMonthYear(int day, int month, int year) throws SQLException {
		// TODO Auto-generated method stub
		List<Trip> list = new ArrayList<>();
		con = DBConnection.getIntansce().getConnection();
		pre = con.prepareStatement(SQLComand.GET_TRIP_BY_DAY_MONTH_YEAR);
		pre.setInt(1, day);
		pre.setInt(2, month);
		pre.setInt(3, year);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			Trip trip = new Trip(rs.getInt("tripId"), rs.getInt("bookedTicketNumber"), rs.getString("carType"),
					rs.getDate("departureDate"), rs.getTime("departureTime"), rs.getString("destination"),
					rs.getString("driver"), rs.getInt("maximumOnlineTicketNumber"));
			list.add(trip);
		}
		return list;
	}

	@Override
	public int getNumberOfTripsByDayMonthYear(int day, int month, int year) throws SQLException {
		int number = 0;
		con = DBConnection.getIntansce().getConnection();
		pre = con.prepareStatement(SQLComand.GET_NUMBER_TRIPS_BY_DAY_MONTH_YEAR);
		pre.setInt(1, day);
		pre.setInt(2, month);
		pre.setInt(3, year);
		ResultSet rs = pre.executeQuery();
		if (rs.next()) {
			number = rs.getInt(1);
		}
		return number;
	}

	@Override
	public List<Trip> getTripsByDMYAndIndexPage(int day, int month, int year, int index, int pageSize) throws SQLException {
		List<Trip> list = new ArrayList<>();
		con = DBConnection.getIntansce().getConnection();
		pre = con.prepareStatement(SQLComand.GET_NUMBER_TRIPS_BY_DAY_MONTH_YEAR_AND_BY_INDEX);
		pre.setInt(1, day);
		pre.setInt(2, month);
		pre.setInt(3, year);
		pre.setInt(4, (index - 1) * pageSize);
		pre.setInt(5, pageSize);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			Trip trip = new Trip(rs.getInt("tripId"), rs.getInt("bookedTicketNumber"), rs.getString("carType"),
					rs.getDate("departureDate"), rs.getTime("departureTime"), rs.getString("destination"),
					rs.getString("driver"), rs.getInt("maximumOnlineTicketNumber"));
			list.add(trip);
		}
		return list;
	}

	@Override
	public List<Trip> getTrip() throws SQLException {
		List<Trip> trip = new ArrayList<>();
		try {

			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_TRIP_BOOKING);
			rs = pre.executeQuery();
			while (rs.next()) {
				Trip t = new Trip();
				t.setTripId(rs.getInt("tripId"));
				t.setDestination(rs.getString("destination"));
				trip.add(t);
			}
		} catch (SQLException ex) {
			throw ex;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return trip;
	}
	
}
