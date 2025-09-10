package jp.co.sss.crud.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDao;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeRegisterService implements IEmployeeService {
	
	public Employee insertReader() throws SystemErrorException, IllegalInputException, ParseException{
		Employee employee = new Employee();
		List<String> employees = new ArrayList<String>();
		employees.add(String.valueOf(new EmployeeNameReader()));
		employees.add(String.valueOf(new EmployeeGenderReader()));
		employees.add(String.valueOf(new EmployeeBirthdayReader()));
		employees.add(String.valueOf(new EmployeeDeptIdReader()));
		employee.setEmpName(employees.get(0));
		employee.setGender(Integer.valueOf(employees.get(1)));
		SimpleDateFormat sdf = new SimpleDateFormat();
		employee.setBirthday(sdf.parse(employees.get(2)));
		employee.getDepartment().setDeptId(Integer.valueOf(employees.get(3)));
		
		return employee;
	}

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		// TODO 自動生成されたメソッド・スタブ
		Employee employee = new Employee();
		try {
			employee = insertReader();
			EmployeeDao employeeDao = new EmployeeDao();
			employeeDao.insert(employee);
			ConsoleWriter.showMsg(ConstantMsg.MSG_EMPLOYEE_INSERT);//コンソール出力
		} catch (SystemErrorException | IllegalInputException | ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
