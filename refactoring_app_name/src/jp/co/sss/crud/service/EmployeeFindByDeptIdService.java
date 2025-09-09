package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDao;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

public class EmployeeFindByDeptIdService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		// TODO 自動生成されたメソッド・スタブ
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();
		int deptId = employeeDeptIdReader.DeptIdReader();
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> searchedEmployees = employeeDao.findByDeptId(deptId);//deptIdは入力された部署ID 
		ConsoleWriter.showEmployees(searchedEmployees);//コンソール出力
	}
}
