package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDao;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeFindByEmpNameService implements IEmployeeService{

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		// TODO 自動生成されたメソッド・スタブ
		// 社員名検索
		System.out.print(ConstantValue.EMP_NAME);
		EmployeeNameReader employeeNameReader = new EmployeeNameReader();
		String searchName = employeeNameReader.NameReader();
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> searchedEmployees = employeeDao.findByEmployeeName(searchName);
		ConsoleWriter.showEmployees(searchedEmployees);
	}
}
