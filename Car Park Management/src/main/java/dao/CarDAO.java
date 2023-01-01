package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Car;

public interface CarDAO {
	Car getCarByLisencePlate(String plate) throws SQLException;
	boolean addCar(Car car) throws SQLException;
	boolean deleteCar(String plate) throws SQLException;
	List<Car> getAllCar() throws SQLException;
	boolean updateCar(Car car) throws SQLException;
	int getNumberOfCars() throws SQLException;
	List<Car> getCarByIndexPage(int index, int pageSize) throws SQLException;
	List<Car> searchCar(String filter, String txt, int index, int pageSize) throws SQLException;
	int countSearch(String filter, String txt) throws SQLException;
	boolean checkCarContainParkinglot(int parkinglotId) throws SQLException;
	
}
