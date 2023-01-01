package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ParkinglotDAO;
import entities.Parkinglot;
import utils.DBConnection;
import utils.SQLComand;

public class ParkinglotDAOImpl implements ParkinglotDAO {
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	@Override
	public Parkinglot getParkinglotById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Parkinglot parkinglot = new Parkinglot();
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_PARKINGLOT_BY_ID);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while (rs.next()) {
				parkinglot = new Parkinglot(rs.getInt("parkId"), rs.getInt("parkArea"), rs.getString("parkName"),
						rs.getString("parkPlace"), rs.getInt("parkPrice"), rs.getString("parkStatus"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return parkinglot;
	}

	@Override
	public boolean addParkinglot(Parkinglot parkinglot) throws SQLException {
		// TODO Auto-generated method stub
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.ADD_PARKINGLOT);
			pre.setInt(1, parkinglot.getParkArea());
			pre.setString(2, parkinglot.getParkName());
			pre.setString(3, parkinglot.getParkPlace());
			pre.setInt(4, parkinglot.getParkPrice());
			pre.setString(5, parkinglot.getParkStatus());
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
	public boolean deleleParkinglot(int id) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.DELETE_PARKINGLOT);
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
	public boolean updateParkinglot(Parkinglot parkinglot) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.UPDATE_PARKINGLOT);
			pre.setInt(1, parkinglot.getParkArea());
			pre.setString(2, parkinglot.getParkName());
			pre.setString(3, parkinglot.getParkPlace());
			pre.setInt(4, parkinglot.getParkPrice());
			pre.setString(5, parkinglot.getParkStatus());
			pre.setInt(6, parkinglot.getParkId());
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
	public int getTotalParkinglot() throws SQLException {
		int number = 0;
		con = DBConnection.getIntansce().getConnection();
		PreparedStatement pre = con.prepareStatement(SQLComand.GET_PARKINGLOT_STAFF);
		ResultSet rs = pre.executeQuery();
		if (rs.next()) {
			number = rs.getInt(1);
		}
		return number;
	}

	@Override
	public List<Parkinglot> getParkinglotByIndexPage(int index, int pageSize) throws SQLException {
		List<Parkinglot> list = new ArrayList();
		con = DBConnection.getIntansce().getConnection();
		pre = con.prepareStatement(SQLComand.GET_PARKINGLOT_BY_INDEX);
		pre.setInt(1, (index - 1) * pageSize);
		pre.setInt(2, pageSize);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			Parkinglot parkinglot = new Parkinglot(rs.getInt("parkId"), rs.getInt("parkArea"), rs.getString("parkName"),
					rs.getString("parkPlace"), rs.getInt("parkPrice"), rs.getString("parkStatus"));
			list.add(parkinglot);
		}
		return list;
	}

	@Override
	public List<Parkinglot> getAllParkinglot() throws SQLException {
		List<Parkinglot> listParkinglot = new ArrayList<>();
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_ALL_PARKINGLOT);
			rs = pre.executeQuery();
			while(rs.next()) {
				listParkinglot.add(new Parkinglot(rs.getInt("parkId"),
						rs.getInt("ParkArea"),
						rs.getString("parkName"),
						rs.getString("parkPlace"),
						rs.getInt("parkPrice"),
						rs.getString("parkStatus")));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return listParkinglot;
	}

	@Override
	public List<Parkinglot> search(String option, String txt, int index, int pageSize) throws SQLException {
		List<Parkinglot> list = new ArrayList<>();
		String sql = SQLComand.SEARCH_PARKINGLOT;
		if (option.equals("parkName")) {
			sql += " parkName LIKE ? )";
		}
		if (option.equals("parkPlace")) {
			sql += " parkPlace LIKE ? )";
		}
		if (option.equals("parkArea")) {
			sql += " parkArea LIKE ? )";
		}
		if (option.equals("parkPrice")) {
			sql += " parkPrice LIKE ? )";
		}
		sql += " select*from x WHERE rn BETWEEN ?*?-? AND ?*?";
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
				Parkinglot pa = new Parkinglot();
				pa.setParkId(rs.getInt("parkId"));
				pa.setParkArea(rs.getInt("parkArea"));
				pa.setParkName(rs.getString("parkName"));
				pa.setParkPlace(rs.getString("parkPlace"));
				pa.setParkPrice(rs.getInt("parkPrice"));
				pa.setParkStatus(rs.getString("parkStatus"));
				list.add(pa);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return list;
	}

	@Override
	public int countSearch(String option, String txt) throws SQLException {
		int count = 0;
		String sql = SQLComand.COUNT_PARKINGLOT_BY_SEARCH;
		if (option.equals("parkName")) {
			sql += " parkName LIKE ?";
		}
		if (option.equals("parkPlace")) {
			sql += " parkPlace LIKE ?";
		}
		if (option.equals("parkArea")) {
			sql += " parkArea LIKE ?";
		}
		if (option.equals("parkPrice")) {
			sql += " parkPrice LIKE ?";
		}
		try {
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
	public int countAll() throws SQLException {
		int count = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.COUNT_ALL_PARKINGLOT);
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
}