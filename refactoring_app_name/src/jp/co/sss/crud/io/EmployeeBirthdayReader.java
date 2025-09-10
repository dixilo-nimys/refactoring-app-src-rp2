package jp.co.sss.crud.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeBirthdayReader implements IConsoleReader {
	public Date BirthdayReader() throws SystemErrorException, IllegalInputException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date searchBirthday = sdf.parse((String) input());
		return searchBirthday;
	}

	@Override
	public String getErrorMsg() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean isValid(String inputString) {
		// TODO 自動生成されたメソッド・スタブ
		return inputString.matches("yyyy/MM/dd");
	}

	@Override
	public boolean isParseInt() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
