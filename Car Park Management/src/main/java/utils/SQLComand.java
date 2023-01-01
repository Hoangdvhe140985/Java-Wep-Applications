package utils;

public class SQLComand {

	// Employee
	public static final String GET_EMPLOYEE_BY_ID = "SELECT * FROM Employee WHERE employeeId = ?";
	public static final String ADD_EMPLOYEE = "INSERT INTO Employee" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_LOGIN_EMPLOYEE = "SELECT * FROM Employee WHERE account = ? and password = ?";
	public static final String GET_NUMBERS_STAFF = "SELECT COUNT(*) FROM (SELECT * FROM Employee WHERE role != 1) AS T";
	public static final String GET_EMPLOYEE_BY_INDEX = "SELECT * FROM (SELECT * FROM Employee WHERE role != 1) AS T\n"
			+ " ORDER BY employeeId\n" + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";
	public static final String UPDATE_EMPLOYEE = "UPDATE Employee SET account = ?, department = ?,"
			+ " employeeAddress = ?, employeeBirthdate = ?, employeeEmail = ?,"
			+ " employeeName = ?, employeePhone = ?, [password] = ?," + " sex = ?, [role] = ? WHERE employeeId LIKE ?";
	public static final String DELETE_EMPLOYEE = "DELETE FROM Employee WHERE employeeId LIKE ?";
	public static final String CHECK_ACCOUNT_EXIST = "SELECT COUNT(*) FROM Employee WHERE account LIKE ?";

	// Car
	public static final String UPDATE_CAR = "UPDATE Car SET carColor = ?, carType = ?, company = ?, parkId = ? WHERE licensePlate LIKE ?";
	public static final String GET_CAR_BY_PLATE = "SELECT * FROM Car WHERE licensePlate LIKE ?";
	public static final String GET_ALL_CAR = "SELECT * FROM Car";

	public static final String GET_NUMBERS_CAR = "SELECT COUNT(*) FROM Car";
	public static final String GET_CAR_BY_INDEX = "SELECT c.licensePlate,c.carType,c.carColor,c.company,c.parkId, p.parkName "
			+ " FROM Car c LEFT JOIN ParkingLot p ON c.parkId=p.parkId " + " ORDER BY licensePlate"
			+ " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

	public static final String DELETE_CAR = "DELETE FROM Ticket WHERE licensePlate LIKE ?; DELETE FROM Car WHERE licensePlate LIKE ?";

	public static final String ADD_CAR = "INSERT INTO Car (licensePlate, carType, carColor, company, parkId) "
			+ " VALUES (?,?,?,?,?)";
	public static final String GET_NUMBERS_SEARCH_CAR = "SELECT count(*) FROM Car c LEFT JOIN ParkingLot p ON c.parkId=p.parkId WHERE filterSearch  LIKE ? ";

	public static final String SEARCH_CAR = "SELECT c.licensePlate,c.carType,c.carColor,c.company,c.parkId, p.parkName "
			+ " FROM Car c LEFT JOIN ParkingLot p ON c.parkId=p.parkId " + " WHERE filterSearch LIKE ? "
			+ " ORDER BY licensePlate OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
	public static final String COUNT_CAR_CONTAIN_PARKINGLOT = "SELECT COUNT(*) FROM Car WHERE parkId = ?";

	// Ticket
	public static final String GET_NUMBERS_TICKET = "SELECT COUNT(*) FROM Ticket";
	public static final String GET_TICKET_BY_INDEX = "SELECT t.ticketId, t.bookingTime, t.customerName, t.licensePlate, t.tripId, tr.destination"
			+ " FROM Ticket t LEFT JOIN Trip tr ON t.tripId = tr.tripId" + " ORDER BY ticketId"
			+ " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
	public static final String GET_TICKET_BY_ID = "SELECT * FROM Ticket WHERE ticketId LIKE ?";
	public static final String UPDATE_TICKET = "UPDATE Ticket SET bookingTime = ?, customerName = ?, licensePlate = ?, tripId = ? WHERE ticketId LIKE ?";
	public static final String ADD_TICKET = "INSERT INTO Ticket (bookingTime, customerName, licensePlate, tripId)"
			+ " VALUES(?, ?, ?, ?)";
	public static final String DELETE_TICKET = "DELETE FROM Ticket WHERE ticketId = ?";
	public static final String GET_NUMBER_TICKETS_SEARCH = "SELECT COUNT(*) FROM Ticket t LEFT JOIN Trip tr"
			+ " ON t.tripId = tr.tripId " + " WHERE filterSearch LIKE ? AND tr.departureDate = ?";
	public static final String GET_TICKET_SEARCH_BY_INDEX = "SELECT t.ticketId, t.bookingTime, t.customerName, t.licensePlate, t.tripId, tr.destination"
			+ " FROM Ticket t LEFT JOIN Trip tr" + " ON t.tripId = tr.tripId"
			+ " WHERE filterSearch LIKE ? AND tr.departureDate = ?" + " ORDER BY ticketId"
			+ " OFFSET ? ROWS FETCH NEXT ? ROW ONLY";
	public static final String COUNT_TICKETS_CONTAIN_TRIP = "SELECT COUNT(*) FROM Ticket WHERE tripId = ?";
	public static final String COUNT_TICKETS_CONTAIN_CAR = "SELECT COUNT(*) FROM Ticket WHERE licensePlate LIKE ?";

	// Trip
	public static final String GET_TRIP_BY_ID = "SELECT * FROM Trip WHERE tripId = ?";
	public static final String GET_ALL_TRIPS = "SELECT * FROM Trip";
	public static final String UPDATE_TRIP = "UPDATE Trip\r\n"
			+ "SET bookedTicketNumber = ?, carType = ?, departureDate = ?,\r\n"
			+ "departureTime = ?, destination = ?, driver = ?, maximumOnlineTicketNumber = ?\r\n" + "WHERE tripId = ?;";
	public static final String DELETE_TRIP = "DELETE FROM Trip WHERE tripId = ?";
	public static final String ADD_TRIP = "INSERT INTO Trip VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_NUMBERS_TRIP = "SELECT COUNT(*) FROM Trip";
	public static final String GET_TRIP_BY_INDEX = "SELECT * FROM Trip\r\n" + "ORDER BY tripId\r\n"
			+ "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";
	public static final String GET_TRIP_BY_DAY_MONTH_YEAR = "SELECT * FROM Trip WHERE DAY(departureDate) = ? AND MONTH(departureDate) = ? AND YEAR(departureDate) = ?";
	public static final String GET_NUMBER_TRIPS_BY_DAY_MONTH_YEAR = "SELECT COUNT(*) FROM Trip WHERE DAY(departureDate) = ? AND MONTH(departureDate) = ? AND YEAR(departureDate) = ?";
	public static final String GET_NUMBER_TRIPS_BY_DAY_MONTH_YEAR_AND_BY_INDEX = "SELECT * FROM Trip WHERE DAY(departureDate) = ? AND MONTH(departureDate) = ? AND YEAR(departureDate) = ?\r\n"
			+ "	ORDER BY tripId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";

	// Parkinglot
	public static final String GET_PARKINGLOT_BY_ID = "SELECT * FROM ParkingLot WHERE parkId = ?";
	public static final String ADD_PARKINGLOT = "INSERT INTO ParkingLot" + " VALUES (?, ?, ?, ?, ?)";
	public static final String GET_PARKINGLOT_STAFF = "  SELECT COUNT(*) FROM ParkingLot";
	public static final String GET_PARKINGLOT_BY_INDEX = "  SELECT * FROM ParkingLot ORDER BY parkId"
			+ "  OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
	public static final String UPDATE_PARKINGLOT = "UPDATE ParkingLot SET parkArea = ?,"
			+ " parkName = ?, parkPlace = ?, parkPrice = ?," + " parkStatus = ? WHERE parkId LIKE ?";
	public static final String DELETE_PARKINGLOT = "DELETE FROM ParkingLot WHERE parkId LIKE ?";
	public static final String COUNT_ALL_PARKINGLOT = "SELECT COUNT(*) FROM ParkingLot";
	public static final String COUNT_PARKINGLOT_BY_SEARCH = "SELECT COUNT(*) FROM ParkingLot WHERE";
	public static final String SEARCH_PARKINGLOT = "with x as(select ROW_NUMBER() over (order by parkId ASC) as rn, \r\n"
			+ "* from ParkingLot where";
	public static final String GET_ALL_PARKINGLOT = "SELECT * FROM ParkingLot";

	// booking office
	public static final String GET_BOOKING_BY_ID = "SELECT officeId,endContractDeadline,officeName,"
			+ "officePhone,officePlace,officePrice,startContractDeadline,o.tripId,destination \n"
			+ "FROM BookingOffice o INNER JOIN Trip t ON o.tripId = t.tripId \n" + "WHERE  officeId = ?";
	public static final String ADD_BOOKING = "INSERT INTO BookingOffice VALUES (?,?,?,?,?,?,?)";
	public static final String UPDATE_BOOKING = "UPDATE BookingOffice SET endContractDeadline = ?,"
			+ "officeName = ?, officePhone = ?, officePlace = ?,officePrice = ?,"
			+ "startContractDeadline = ?,tripId = ? WHERE officeId = ?";
	public static final String GET_ALL_BOOKING_BY_PAGE = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY officeId ASC) AS rn,"
			+ " officeId,officeName,officePlace,officePrice,o.tripId,destination\n"
			+ "FROM BookingOffice o INNER JOIN Trip t ON o.tripId = t.tripId) AS x WHERE rn BETWEEN ?*?-? AND ?*?";
	public static final String COUNT_ALL_BOOKING = "SELECT COUNT(*) FROM BookingOffice ";
	public static final String COUNT_BOOKING_BY_SEARCH = "SELECT COUNT(*) FROM BookingOffice o "
			+ "INNER JOIN Trip t ON o.tripId = t.tripId WHERE";
	public static final String SEARCH_BOOKING = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY officeId ASC) \n"
			+ "AS rn, officeId,officeName,officePlace,officePrice,t.tripId,destination\n"
			+ "FROM BookingOffice o INNER JOIN Trip t ON o.tripId = t.tripId WHERE";
	public static final String GET_ALL_Place_BOOKING = "SELECT DISTINCT officePlace FROM BookingOffice";
	public static final String DELETE_BOOKING = "DELETE FROM BookingOffice WHERE officeId LIKE ?";
	public static final String GET_TRIP_BOOKING = "SELECT tripId,destination FROM Trip";
	public static final String COUNT_BOOKING_OFFICES_CONTAIN_TRIP = "SELECT COUNT(*) FROM BookingOffice WHERE tripId = ?";
}
