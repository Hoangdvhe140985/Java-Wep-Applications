package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Employee;

public interface EmployeeDAO {
	Employee getEmployeeById(int id) throws SQLException;

	boolean addEmployee(Employee employee) throws SQLException;

	Employee getLoginEmployee(String account, String password) throws SQLException;

	boolean updateEmployee(Employee employee) throws SQLException;

	boolean deleleEmployee(int id) throws SQLException;

	List<Employee> getAllEmployee() throws SQLException;

	public int getNumberOfStaffs() throws SQLException;

	public List<Employee> getEmployeesByIndexPage(int index, int pageSize) throws SQLException;
	
	List<Employee> Search(String o, String txt, int index, int pageSize) throws SQLException;
	
	int count(String option, String txt) throws SQLException;

	boolean checkAccountExist(String account) throws SQLException;
}
