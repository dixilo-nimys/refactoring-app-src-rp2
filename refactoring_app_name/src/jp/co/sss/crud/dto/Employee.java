package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.Constant;

public class Employee {

	private Integer empId;
	private String empName;
	private int gender;
	private String birthday;
	private String deptName;
	private Department department;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	@Override
	public String toString() {
		String gender_ja = "";
		if (gender == 0) {
			gender_ja = Constant.NODATE;
		} else if (this.gender == 1) {
			gender_ja = Constant.MALE;
		} else if (this.gender == 2) {
			gender_ja = Constant.FEMALE;
		} else if (gender == 9) {
			gender_ja = Constant.OTHER;
		}

		return empId + "\t" + empName + "\t" + gender_ja + "\t" + birthday + "\t" + department.getDeptName();
	}
	
}
