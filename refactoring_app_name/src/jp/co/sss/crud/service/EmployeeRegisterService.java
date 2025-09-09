package jp.co.sss.crud.service;

import java.util.HashMap;
import java.util.Map;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeRegisterService implements IEmployeeService {
	
	public static Map<String,String> insert() throws SystemErrorException, IllegalInputException {
		Map<String,String> insertEmployees = new HashMap<>();
		EmployeeNameReader employeeNameReader = new EmployeeNameReader();
		insertEmployees.put("empName",String.valueOf(employeeNameReader.input()));
		EmployeeGenderReader employeeGenderReader = new EmployeeGenderReader();
		insertEmployees.put("gender",String.valueOf(employeeGenderReader.input()));
		EmployeeBirthdayReader employeeBirthdayReader = new EmployeeBirthdayReader();
		insertEmployees.put("birthday",String.valueOf(employeeBirthdayReader.input()));
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();
		insertEmployees.put("deptId",String.valueOf(employeeDeptIdReader.input()));
		
		return insertEmployees;
	}

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
