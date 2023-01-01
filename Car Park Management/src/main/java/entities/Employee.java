package entities;

import java.sql.Date;

public class Employee {
	private int employeeId;
	private String account;
	private String department;
	private String employeeAddress;
	private Date employeeBirthDate;
	private String employeeEmail;
	private String employeeName;
	private String employeePhone;
	private String password;
	private int sex;
	private int role;
	
	public Employee() {
		
	}
	
	

	public Employee(int employeeId, String account, String department, String employeeAddress, Date employeeBirthDate,
			String employeeEmail, String employeeName, String employeePhone, String password, int sex, int role) {
		this.employeeId = employeeId;
		this.account = account;
		this.department = department;
		this.employeeAddress = employeeAddress;
		this.employeeBirthDate = employeeBirthDate;
		this.employeeEmail = employeeEmail;
		this.employeeName = employeeName;
		this.employeePhone = employeePhone;
		this.password = password;
		this.sex = sex;
		this.role = role;
	}



	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public Date getEmployeeBirthDate() {
		return employeeBirthDate;
	}

	public void setEmployeeBirthDate(Date employeeBirthDate) {
		this.employeeBirthDate = employeeBirthDate;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", account=" + account + ", department=" + department
				+ ", employeeAddress=" + employeeAddress + ", employeeBirthDate=" + employeeBirthDate
				+ ", employeeEmail=" + employeeEmail + ", employeeName=" + employeeName + ", employeePhone="
				+ employeePhone + ", password=" + password + ", sex=" + sex + ", role=" + role + "]";
	}
	
	
	
	
	
}
