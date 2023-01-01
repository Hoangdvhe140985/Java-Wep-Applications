package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookingOfficeDAO;
import entities.BookingOffice;
import entities.Trip;
import utils.DBConnection;
import utils.SQLComand;

public class BookingOfficeDAOImpl implements BookingOfficeDAO{
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;
	@Override
	public BookingOffice getBookingOfficeById(int id) throws SQLException {
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_BOOKING_BY_ID);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while (rs.next()) {
				BookingOffice booking = new BookingOffice();
				booking.setOfficeId(rs.getInt("officeId"));
				booking.setEndContractDeadline(rs.getDate("endContractDeadline"));
				booking.setOfficeName(rs.getString("officeName"));
				booking.setOfficePhone(rs.getString("officePhone"));
				booking.setOfficePlace(rs.getString("officePlace"));
				booking.setOfficePrice(rs.getInt("officePrice"));
				booking.setStartContractDealine(rs.getDate("startContractDeadline"));
				Trip trip = new Trip();
				trip.setTripId(rs.getInt("tripId"));
				trip.setDestination(rs.getString("destination"));
				booking.setTrip(trip);
				return booking;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return null;
	}

	@Override
	public boolean addBookingOffice(BookingOffice bookingOffice) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.ADD_BOOKING);
			pre.setDate(1, bookingOffice.getEndContractDeadline());
			pre.setString(2, bookingOffice.getOfficeName());
			pre.setString(3, bookingOffice.getOfficePhone());
			pre.setString(4, bookingOffice.getOfficePlace());
			pre.setInt(5, bookingOffice.getOfficePrice());
			pre.setDate(6, bookingOffice.getStartContractDealine());
			pre.setInt(7, bookingOffice.getTrip().getTripId());
			row = pre.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return row > 0;
	}

	@Override
	public boolean updateBookingOffice(BookingOffice bookingOffice) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.UPDATE_BOOKING);
			pre.setDate(1, bookingOffice.getEndContractDeadline());
			pre.setString(2, bookingOffice.getOfficeName());
			pre.setString(3, bookingOffice.getOfficePhone());
			pre.setString(4, bookingOffice.getOfficePlace());
			pre.setInt(5, bookingOffice.getOfficePrice());
			pre.setDate(6, bookingOffice.getStartContractDealine());
			pre.setInt(7, bookingOffice.getTrip().getTripId());
			pre.setInt(8, bookingOffice.getOfficeId());
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
	public boolean deleleBookingOffice(int id) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.DELETE_BOOKING);
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
	public List<BookingOffice> getAllBookingOffice(int index, int pageSizeSS) throws SQLException {
		List<BookingOffice> booking = new ArrayList<>();
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_ALL_BOOKING_BY_PAGE);
			pre.setInt(1, index);
			pre.setInt(2, pageSizeSS);
			pre.setInt(3, pageSizeSS - 1);
			pre.setInt(4, index);
			pre.setInt(5, pageSizeSS);
			rs = pre.executeQuery();
			while (rs.next()) {
				BookingOffice bo = new BookingOffice();
				bo.setOfficeId(rs.getInt("officeId"));
				bo.setOfficeName(rs.getString("officeName"));
				Trip trip = new Trip();
				trip.setTripId(rs.getInt("tripId"));
				trip.setDestination(rs.getString("destination"));
				bo.setTrip(trip);
				bo.setOfficePlace(rs.getString("officePlace"));
				bo.setOfficePrice(rs.getInt("officePrice"));
				booking.add(bo);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return booking;
	}

	@Override
	public int countAll() throws SQLException {
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.COUNT_ALL_BOOKING);
			rs = pre.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
		}
		return 0;
	}

	@Override
	public int countSearch(String option, String txt) throws SQLException {
		List<BookingOffice> booking = new ArrayList<>();
		String sql = SQLComand.COUNT_BOOKING_BY_SEARCH;
		if (option.equals("officeName")) {
			sql += " o.officeName LIKE ?";
		}
		if (option.equals("officePlace")) {
			sql += " o.officePlace LIKE ?";
		}
		if (option.equals("destination")) {
			sql += " t.destination LIKE ?";
		}
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, "%" + txt + "%");
			rs = pre.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
		}
		return 0;
	}

	@Override
	public List<BookingOffice> Search(String option, String txt, int index, int pageSize) throws SQLException {
		List<BookingOffice> booking = new ArrayList<>();
		String sql = SQLComand.SEARCH_BOOKING;
		if (option.equals("officeName")) {
			sql += " o.officeName LIKE ? )";
		}
		if (option.equals("officePlace")) {
			sql += " o.officePlace LIKE ? )";
		}
		if (option.equals("destination")) {
			sql += " t.destination LIKE ? )";
		}
		sql += "AS x WHERE rn BETWEEN ?*?-? AND ?*?";
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, "%" + txt + "%");
			pre.setInt(2, index);
			pre.setInt(3, pageSize);
			pre.setInt(4, pageSize - 1);
			pre.setInt(5, index);
			pre.setInt(6, pageSize);
			rs = pre.executeQuery();
			while (rs.next()) {
				BookingOffice bo = new BookingOffice();
				bo.setOfficeId(rs.getInt("officeId"));
				bo.setOfficeName(rs.getString("officeName"));
				bo.setOfficePlace(rs.getString("officePlace"));
				bo.setOfficePrice(rs.getInt("officePrice"));
				Trip trip = new Trip();
				trip.setTripId(rs.getInt("tripId"));
				trip.setDestination(rs.getString("destination"));
				bo.setTrip(trip);
				booking.add(bo);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return booking;
	}

	@Override
	public List<BookingOffice> getListPlace() throws SQLException {
		List<BookingOffice> booking = new ArrayList<>();
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_ALL_Place_BOOKING);
			rs = pre.executeQuery();
			while (rs.next()) {
				BookingOffice bo = new BookingOffice();
				bo.setOfficePlace(rs.getString("officePlace"));
				booking.add(bo);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return booking;
	}

	@Override
	public boolean countBookingOfficesContainTrip(int tripId) throws SQLException {
		int count = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.COUNT_BOOKING_OFFICES_CONTAIN_TRIP);
			pre.setInt(1, tripId);
			rs = pre.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return count > 0;
	}

	

}
