package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Parkinglot;

public interface ParkinglotDAO {
	Parkinglot getParkinglotById(int id) throws SQLException;
	boolean addParkinglot(Parkinglot parkinglot) throws SQLException;
	boolean deleleParkinglot(int id) throws SQLException;
	List<Parkinglot> getAllParkinglot() throws SQLException;
	boolean updateParkinglot(Parkinglot parkinglot) throws SQLException;
	public int getTotalParkinglot() throws SQLException;
	public List<Parkinglot> getParkinglotByIndexPage(int index, int pageSize) throws SQLException;
	public List<Parkinglot> search(String option, String txt, int index, int pageSize) throws SQLException;
	public int countSearch(String option, String txt) throws SQLException;
	public int countAll() throws SQLException;
}
