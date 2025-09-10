package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDao;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		// TODO 自動生成されたメソッド・スタブ
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();
		Integer deptId = employeeDeptIdReader.DeptIdReader();
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.delete(deptId);
		
		ConsoleWriter.showMsg(ConstantMsg.MSG_EMPLOYEE_DELETE);//コンソール出力
	}

}
