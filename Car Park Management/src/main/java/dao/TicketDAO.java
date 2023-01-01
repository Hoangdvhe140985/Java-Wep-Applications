package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import entities.Employee;
import entities.Ticket;

public interface TicketDAO {
	Ticket getTicketById(int id) throws SQLException;
	
	boolean addTicket(Ticket ticket) throws SQLException;
	
	boolean deleleTicket(int id) throws SQLException;
	
	List<Ticket> getAllTicket() throws SQLException;
	
	boolean updateTicket(Ticket ticket) throws SQLException;
	
	int getNumberOfTickets() throws SQLException;
	
	List<Ticket> getTicketByIndexPage(int index, int pageSize) throws SQLException;
	
	int getNumberOfTikcetSearch(String filter, String searchStr, Date date) throws SQLException;
	
	List<Ticket> getTicketSearchByIndexPage(String filter, String searchStr, Date date, int index, int pageSize) throws SQLException;
	
	boolean countTicketsContainTrip(int tripId) throws SQLException;
	
	boolean checkTicketContainCar(String plate) throws SQLException;
}
