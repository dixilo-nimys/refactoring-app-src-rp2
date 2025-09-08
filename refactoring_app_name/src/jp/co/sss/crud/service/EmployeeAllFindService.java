package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDao;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeAllFindService implements IEmployeeService {

	private EmployeeAllFindService() {

	}

	/**
	 * 全権検索出力用メソッド
	 * 
	 * @param employee 社員情報Dto
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void showFindAll(List<Employee> employees) {
		System.out.println(ConstantValue.EMP_COLUMN_NAME);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	@Override
	public void execute() throws ClassNotFoundException, SQLException {
		EmployeeDao.findAll();
	}

}
