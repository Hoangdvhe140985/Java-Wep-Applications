package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TicketDAO;
import entities.Employee;
import entities.Ticket;
import utils.DBConnection;
import utils.SQLComand;

public class TicketDAOImpl implements TicketDAO {
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	@Override
	public Ticket getTicketById(int id) throws SQLException {
		Ticket ticket = null;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_TICKET_BY_ID);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while(rs.next()) {
				ticket = new Ticket(rs.getInt("ticketId"),
						rs.getTime("bookingTime"),
						rs.getString("customerName"),
						rs.getString("licensePlate"),
						rs.getInt("tripId"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return ticket;
	}

	@Override
	public boolean addTicket(Ticket ticket) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.ADD_TICKET);
			pre.setTime(1, ticket.getBookingTime());
			pre.setString(2, ticket.getCustomerName());
			pre.setString(3, ticket.getLicensePlate());
			pre.setInt(4, ticket.getTripId());
			row = pre.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return row > 0;
	}

	@Override
	public boolean deleleTicket(int id) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.DELETE_TICKET);
			pre.setInt(1, id);
			row = pre.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return row > 0;
	}

	@Override
	public List<Ticket> getAllTicket() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTicket(Ticket ticket) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.UPDATE_TICKET);
			pre.setTime(1, ticket.getBookingTime());
			pre.setString(2, ticket.getCustomerName());
			pre.setString(3, ticket.getLicensePlate());
			pre.setInt(4, ticket.getTripId());
			pre.setInt(5, ticket.getTicketId());
			row = pre.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return row > 0;
	}

	@Override
	public int getNumberOfTickets() throws SQLException {
		int number = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_NUMBERS_TICKET);
			rs = pre.executeQuery();
			if (rs.next()) {
				number = rs.getInt(1);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return number;
	}

	@Override
	public List<Ticket> getTicketByIndexPage(int index, int pageSize) throws SQLException {
		List<Ticket> list = new ArrayList<>();
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_TICKET_BY_INDEX);
			pre.setInt(1, (index - 1) * pageSize);
			pre.setInt(2, pageSize);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				list.add(new Ticket(rs.getInt("ticketId"), rs.getTime("bookingTime"), rs.getString("customerName"),
						rs.getString("licensePlate"), rs.getInt("tripId"), rs.getString("destination")));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return list;
	}

	@Override
	public int getNumberOfTikcetSearch(String filter, String searchStr, Date date) throws SQLException {
		// TODO Auto-generated method stub
		int number = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			String sql = SQLComand.GET_NUMBER_TICKETS_SEARCH.replace("filterSearch", filter);
			pre = con.prepareStatement(sql);
			pre.setString(1, "%" + searchStr + "%");
			pre.setDate(2, date);
			rs = pre.executeQuery();
			if(rs.next()) {
				number = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return number;
	}

	@Override
	public List<Ticket> getTicketSearchByIndexPage(String filter, String searchStr, Date date, int index, int pageSize)
			throws SQLException {
		// TODO Auto-generated method stub
		List<Ticket> listTicket = new ArrayList<>();
		try {
			con = DBConnection.getIntansce().getConnection();
			String sql = SQLComand.GET_TICKET_SEARCH_BY_INDEX.replace("filterSearch", filter);
			pre = con.prepareStatement(sql);
			pre.setString(1, "%" + searchStr + "%");
			pre.setDate(2, date);
			pre.setInt(3, (index - 1) * pageSize);
			pre.setInt(4, pageSize);
			rs = pre.executeQuery();
			while(rs.next()) {
				listTicket.add(new Ticket(rs.getInt("ticketId"),
						rs.getTime("bookingTime"), 
						rs.getString("customerName"),
						rs.getString("licensePlate"),
						rs.getInt("tripId"),
						rs.getString("destination")));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return listTicket;
	}

	@Override
	public boolean countTicketsContainTrip(int tripId) throws SQLException {
		int count = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.COUNT_TICKETS_CONTAIN_TRIP);
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

	@Override
	public boolean checkTicketContainCar(String plate) throws SQLException {
		int count = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.COUNT_TICKETS_CONTAIN_CAR);
			pre.setString(1, plate);
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
