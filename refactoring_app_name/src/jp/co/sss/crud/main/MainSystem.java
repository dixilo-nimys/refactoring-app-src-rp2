package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 * 
 * 初回コミット確認
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		

		do {
			// メニューの表示
			System.out.println(ConstantValue.MENU_LABEL);
			System.out.println(ConstantValue.MENU_1_FINDALL);
			System.out.println(ConstantValue.MENU_2_FINDBYNAME);
			System.out.println(ConstantValue.MENU_3_FINDBYID);
			System.out.println(ConstantValue.MENU_4_INSERT);
			System.out.println(ConstantValue.MENU_5_UPDATE);
			System.out.println(ConstantValue.MENU_6_DELETE);
			System.out.println(ConstantValue.MENU_7_CLOSE);
			System.out.print(ConstantMsg.MSG_MENU);

			int menuNo = MenuNoReader.InputMenuNo();

			// 機能の呼出
			switch (menuNo) {
			case 1:
				EmployeeAllFindService.showFindAll();
				break;

			case 2:
				// 社員名検索
				System.out.print(ConstantValue.EMP_NAME);

				// 検索機能の呼出
				DBController.findByName();
				break;

			case 3:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.MSG_DEPT_ID);
				String deptId = br.readLine();

				// 検索機能の呼出
				DBController.findById(deptId);
				break;

			case 4:
				// 登録する値を入力
				System.out.print(ConstantValue.EMP_NAME);
				String empName = br.readLine();
				System.out.print(ConstantValue.GENDER);
				String Seibetsu = br.readLine();
				System.out.print(ConstantValue.BIRTHDAY);
				String birthday = br.readLine();
				System.out.print(ConstantValue.DEPT_ID);
				deptId = br.readLine();

				// 登録機能の呼出
				DBController.insert(empName, Seibetsu, birthday, deptId);
				break;

			case 5:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.MSG_UPDATE_DEPT_ID);

				// 更新する値を入力する
				String empId = br.readLine();
				Integer.parseInt(empId);

				// 更新機能の呼出
				DBController.update(empId);
				System.out.println(ConstantMsg.MSG_EMPLOYEE_UPDATE);

				break;

			case 6:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.MSG_DELETE_DEPT_ID);

				// 削除機能の呼出
				DBController.delete();
				break;

			}
		} while (menuNo != 7);
		System.out.println(ConstantMsg.MSG_CLOSE);
	}
}
