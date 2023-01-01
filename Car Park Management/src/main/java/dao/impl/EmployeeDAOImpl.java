package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDAO;
import entities.Employee;
import utils.DBConnection;
import utils.SQLComand;

public class EmployeeDAOImpl implements EmployeeDAO {
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	@Override
	public Employee getEmployeeById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_EMPLOYEE_BY_ID);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while (rs.next()) {
				employee = new Employee(rs.getInt("employeeId"), rs.getString("account"), rs.getString("department"),
						rs.getString("employeeAddress"), rs.getDate("employeeBirthdate"), rs.getString("employeeEmail"),
						rs.getString("employeeName"), rs.getString("employeePhone"), rs.getString("password"),
						rs.getInt("sex"), rs.getInt("role"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return employee;
	}

	@Override
	public boolean addEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.ADD_EMPLOYEE);
			pre.setString(1, employee.getAccount());
			pre.setString(2, employee.getDepartment());
			pre.setString(3, employee.getEmployeeAddress());
			pre.setDate(4, employee.getEmployeeBirthDate());
			pre.setString(5, employee.getEmployeeEmail());
			pre.setString(6, employee.getEmployeeName());
			pre.setString(7, employee.getEmployeePhone());
			pre.setString(8, employee.getPassword());
			pre.setInt(9, employee.getSex());
			pre.setInt(10, employee.getRole());
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
	public Employee getLoginEmployee(String account, String password) throws SQLException {
		// TODO Auto-generated method stub
		Employee loginEmployee = null;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_LOGIN_EMPLOYEE);
			pre.setString(1, account);
			pre.setString(2, password);
			rs = pre.executeQuery();
			while (rs.next()) {
				loginEmployee = new Employee(rs.getInt("employeeId"), rs.getString("account"),
						rs.getString("department"), rs.getString("employeeAddress"), rs.getDate("employeeBirthdate"),
						rs.getString("employeeEmail"), rs.getString("employeeName"), rs.getString("employeePhone"),
						rs.getString("password"), rs.getInt("sex"), rs.getInt("role"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return loginEmployee;
	}

	public int getNumberOfStaffs() throws SQLException {
		int number = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			PreparedStatement pre = con.prepareStatement(SQLComand.GET_NUMBERS_STAFF);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
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

	public List<Employee> getEmployeesByIndexPage(int index, int pageSize) throws SQLException {
		List<Employee> list = new ArrayList<>();
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_EMPLOYEE_BY_INDEX);
			pre.setInt(1, (index - 1) * pageSize);
			pre.setInt(2, pageSize);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt("employeeId"), rs.getString("account"),
						rs.getString("department"), rs.getString("employeeAddress"), rs.getDate("employeeBirthdate"),
						rs.getString("employeeEmail"), rs.getString("employeeName"), rs.getString("employeePhone"),
						rs.getString("password"), rs.getInt("sex"), rs.getInt("role"));
				list.add(employee);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}

		return list;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.UPDATE_EMPLOYEE);
			pre.setString(1, employee.getAccount());
			pre.setString(2, employee.getDepartment());
			pre.setString(3, employee.getEmployeeAddress());
			pre.setDate(4, employee.getEmployeeBirthDate());
			pre.setString(5, employee.getEmployeeEmail());
			pre.setString(6, employee.getEmployeeName());
			pre.setString(7, employee.getEmployeePhone());
			pre.setString(8, employee.getPassword());
			pre.setInt(9, employee.getSex());
			pre.setInt(10, employee.getRole());
			pre.setInt(11, employee.getEmployeeId());
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
	public boolean deleleEmployee(int id) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.DELETE_EMPLOYEE);
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
	public List<Employee> getAllEmployee() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> Search(String o, String txt, int index, int pageSize) throws SQLException {
		List<Employee> employee = new ArrayList<>();
		String sql = "SELECT employeeId,employeeName,employeeAddress,employeeBirthdate,employeePhone,department \r\n"
				+ "FROM( SELECT ROW_NUMBER() OVER (ORDER BY employeeId ASC) AS rn, *\r\n" + "FROM Employee WHERE ";
		if (o.equals("employeeName")) {
			sql += " employeeName LIKE ? )";
		}
		if (o.equals("department")) {
			sql += " department LIKE ? )";
		}
		if (o.equals("employeeAddress")) {
			sql += " employeeAddress LIKE ? )";
		}
		if (o.equals("employeePhone")) {
			sql += " employeePhone LIKE ? )";
		}
		if (o.equals("employeeBirthdate")) {
			sql += " employeeBirthdate LIKE ? )";
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
				Employee em = new Employee();
				em.setEmployeeId(rs.getInt("employeeId"));
				em.setEmployeeName(rs.getString("employeeName"));
				em.setEmployeeAddress(rs.getString("employeeAddress"));
				em.setEmployeeBirthDate(rs.getDate("employeeBirthdate"));
				em.setEmployeePhone(rs.getString("employeePhone"));
				em.setDepartment(rs.getString("department"));
				employee.add(em);
			}
		} catch (Exception ex) {
			// TODO: handle exception
			throw ex;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return employee;
	}

	@Override
	public int count(String option, String txt) throws SQLException {
		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM Employee WHERE ";
			if (option.equals("employeeName")) {
				sql += "employeeName LIKE ?";
			}
			if (option.equals("department")) {
				sql += "department LIKE ?";
			}
			if (option.equals("employeeAddress")) {
				sql += "employeeAddress LIKE ?";
			}
			if (option.equals("employeePhone")) {
				sql += "employeePhone LIKE ?";
			}
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, "%" + txt + "%");
			rs = pre.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return count;
	}

	@Override
	public boolean checkAccountExist(String account) throws SQLException {
		int count = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.CHECK_ACCOUNT_EXIST);
			pre.setString(1, account);
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
