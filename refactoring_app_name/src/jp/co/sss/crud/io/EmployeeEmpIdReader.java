package jp.co.sss.crud.io;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeEmpIdReader implements IConsoleReader {
	
	public int empIdReader() throws SystemErrorException, IllegalInputException {
		int empId = (Integer)input();
		return empId;
	}
	
	@Override
	public String getErrorMsg() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean isValid(String inputString) {
		// TODO 自動生成されたメソッド・スタブ
		return inputString.matches("^[1-9１-９]{1}[0-9１-９]{0,3}$");
	}

	@Override
	public boolean isParseInt() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
