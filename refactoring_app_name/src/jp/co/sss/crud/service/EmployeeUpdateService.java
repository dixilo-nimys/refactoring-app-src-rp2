package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDao;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeUpdateService implements IEmployeeService {
	
	

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		// TODO 自動生成されたメソッド・スタブ
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.update();
		
		ConsoleWriter.showMsg(ConstantMsg.MSG_EMPLOYEE_UPDATE);//コンソール出力
	}

}
