package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CarDAO;
import entities.Car;
import utils.DBConnection;
import utils.SQLComand;

public class CarDAOImpl implements CarDAO {
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	@Override
	public boolean updateCar(Car car) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.UPDATE_CAR);
			pre.setString(1, car.getCarColor());
			pre.setString(2, car.getCarType());
			pre.setString(3, car.getCompany());
			pre.setInt(4, car.getParkId());
			pre.setString(5, car.getLicensePlate());
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
	public Car getCarByLisencePlate(String plate) throws SQLException {
		Car car = null;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_CAR_BY_PLATE);
			pre.setString(1, plate);
			rs = pre.executeQuery();
			while (rs.next()) {
				car = new Car(rs.getString("licensePlate"), rs.getString("carColor"), rs.getString("carType"),
						rs.getString("company"), rs.getInt("parkId"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return car;
	}

	@Override
	public boolean addCar(Car car) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.ADD_CAR);
			pre.setString(1, car.getLicensePlate());
			pre.setString(2, car.getCarType());
			pre.setString(3, car.getCarColor());
			pre.setString(4, car.getCompany());
			pre.setInt(5, car.getParkId());
			row = pre.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return row > 0;
	}

	@Override
	public boolean deleteCar(String plate) throws SQLException {
		int row = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.DELETE_CAR);
			pre.setString(1, plate);
			pre.setString(2, plate);
			row = pre.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return row > 0;
	}

	@Override
	public List<Car> getAllCar() throws SQLException {
		List<Car> listCar = new ArrayList<>();
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_ALL_CAR);
			rs = pre.executeQuery();
			while (rs.next()) {
				listCar.add(new Car(rs.getString("licensePlate"), rs.getString("carColor"), rs.getString("carType"),
						rs.getString("company"), rs.getInt("parkId")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return listCar;
	}

	@Override
	public int getNumberOfCars() throws SQLException {
		int number = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			PreparedStatement pre = con.prepareStatement(SQLComand.GET_NUMBERS_CAR);
			ResultSet rs = pre.executeQuery();
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
	public List<Car> getCarByIndexPage(int index, int pageSize) throws SQLException {
		List<Car> list = new ArrayList<>();
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.GET_CAR_BY_INDEX);
			pre.setInt(1, (index - 1) * pageSize);
			pre.setInt(2, pageSize);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				list.add(new Car(rs.getString("licensePlate"), rs.getString("carType"), rs.getString("carColor"),
						rs.getString("company"), rs.getInt("parkId"), rs.getString("parkName")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return list;
	}

	@Override
	public List<Car> searchCar(String filter, String txt, int index, int pageSize) throws SQLException {
		List<Car> listSearch = new ArrayList<>();
		try {
			con = DBConnection.getIntansce().getConnection();
			String sql = SQLComand.SEARCH_CAR.replace("filterSearch", filter);
			pre = con.prepareStatement(sql);
			pre.setString(1, "%" + txt + "%");
			pre.setInt(2, (index - 1) * pageSize);
			pre.setInt(3, pageSize);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				listSearch.add(new Car(rs.getString("licensePlate"), rs.getString("carType"), rs.getString("carColor"),
						rs.getString("company"), rs.getInt("parkId"), rs.getString("parkName")));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return listSearch;
	}

	@Override
	public int countSearch(String filter, String txt) throws SQLException {
		int number = 0;

		try {
			con = DBConnection.getIntansce().getConnection();
			String sql = SQLComand.GET_NUMBERS_SEARCH_CAR.replace("filterSearch", filter);
			pre = con.prepareStatement(sql);

			pre.setString(1, "%" + txt + "%");
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				number = rs.getInt(1);
			}
		} catch (Exception e) {
//			e.printStackTrace();
			throw e;
		} finally {
			DBConnection.closeConnection(rs, pre, con);
		}
		return number;
	}

	@Override
	public boolean checkCarContainParkinglot(int parkinglotId) throws SQLException {
		int count = 0;
		try {
			con = DBConnection.getIntansce().getConnection();
			pre = con.prepareStatement(SQLComand.COUNT_CAR_CONTAIN_PARKINGLOT);
			pre.setInt(1, parkinglotId);
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
