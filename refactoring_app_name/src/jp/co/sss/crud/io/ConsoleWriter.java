package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {

	private ConsoleWriter() {
	}

	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			System.out.println(ConstantMsg.MSG_NOT_FIND);//対象者がいませんでした と表示 
		} else {
			System.out.println(ConstantMsg.MSG_MENU);
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}
	}

}
