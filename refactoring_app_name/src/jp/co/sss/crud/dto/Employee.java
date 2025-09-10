package jp.co.sss.crud.dto;

import java.util.Date;

import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理用クラス
 */
public class Employee {

	private Integer empId;
	private String empName;
	private int gender;
	private Date birthday;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
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
			gender_ja = ConstantValue.NODATE;
		} else if (this.gender == 1) {
			gender_ja = ConstantValue.MALE;
		} else if (this.gender == 2) {
			gender_ja = ConstantValue.FEMALE;
		} else if (gender == 9) {
			gender_ja = ConstantValue.OTHER;
		}

		return empId + "\t" + empName + "\t" + gender_ja + "\t" + birthday + "\t" + department.getDeptName();
	}
	
}
