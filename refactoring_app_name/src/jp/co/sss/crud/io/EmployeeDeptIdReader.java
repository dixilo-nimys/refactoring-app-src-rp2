package jp.co.sss.crud.io;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeDeptIdReader implements IConsoleReader {
	
	public int DeptIdReader() throws SystemErrorException, IllegalInputException {
		int deptId = (Integer)input();
		return deptId;
	}

	@Override
	public String getErrorMsg() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean isValid(String inputString) {
		// TODO 自動生成されたメソッド・スタブ
		return inputString.matches("^[1-3１-３]{1}$");
	}

	@Override
	public boolean isParseInt() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
