package dao;

import java.sql.SQLException;
import java.util.List;

import entities.BookingOffice;

public interface BookingOfficeDAO {
	BookingOffice getBookingOfficeById(int id) throws SQLException;
	boolean addBookingOffice(BookingOffice bookingOffice) throws SQLException;
	boolean updateBookingOffice(BookingOffice bookingOffice) throws SQLException;
	boolean deleleBookingOffice(int id) throws SQLException;
	List<BookingOffice> getAllBookingOffice(int index, int pageSizeSS) throws SQLException;
	int countAll() throws SQLException;
	int countSearch(String option, String txt) throws SQLException;
	List<BookingOffice> Search(String option, String txt, int index, int pageSize) throws SQLException;
	List<BookingOffice> getListPlace() throws SQLException;
	boolean countBookingOfficesContainTrip(int tripId) throws SQLException;
}
