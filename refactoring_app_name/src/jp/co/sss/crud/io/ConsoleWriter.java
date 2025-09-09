package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

public class ConsoleWriter {

	private ConsoleWriter() {
	}
	
	public static void showMenu() {
		System.out.println(ConstantValue.MENU_LABEL);
		System.out.println(ConstantValue.MENU_1_FINDALL);
		System.out.println(ConstantValue.MENU_2_FINDBYNAME);
		System.out.println(ConstantValue.MENU_3_FINDBYID);
		System.out.println(ConstantValue.MENU_4_INSERT);
		System.out.println(ConstantValue.MENU_5_UPDATE);
		System.out.println(ConstantValue.MENU_6_DELETE);
		System.out.println(ConstantValue.MENU_7_CLOSE);
		System.out.print(ConstantMsg.MSG_MENU);
		
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
	
	public static void showMsg(String msg) {
		System.out.println(msg);
	}

}
