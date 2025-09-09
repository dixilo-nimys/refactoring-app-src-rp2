package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;
import jp.co.sss.crud.util.ConstantMsg;

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
		int menuNo;
		
		do {
			try {
			// メニューの表示
			ConsoleWriter.showMenu();
			
			
			menuNo = MenuNoReader.InputMenuNo();
			
			// 機能の呼出
			switch (menuNo) {
			case 1:
				IEmployeeService.getInstanceByMenuNo(menuNo).execute();
				break;
				
			case 2:
				// 検索機能の呼出
				IEmployeeService.getInstanceByMenuNo(menuNo).execute();
				break;
				
			case 3:
				// 検索機能の呼出
				IEmployeeService.getInstanceByMenuNo(menuNo).execute();
				break;
				
			case 4:
				// 登録機能の呼出
				IEmployeeService.getInstanceByMenuNo(menuNo).execute();
				break;
				
			case 5:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.MSG_UPDATE_DEPT_ID);
				
				// 更新する値を入力する
				String empId = br.readLine();
				Integer.parseInt(empId);
				
				// 更新機能の呼出
				IEmployeeService.getInstanceByMenuNo(menuNo).execute();
				System.out.println(ConstantMsg.MSG_EMPLOYEE_UPDATE);
				
				break;
				
			case 6:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.MSG_DELETE_DEPT_ID);
				
				// 削除機能の呼出
				IEmployeeService.getInstanceByMenuNo(menuNo).execute();
				break;
				
			}
		} catch (IllegalInputException e) {//不正な入力があった場合、ループに戻る 
			System.out.println(e.getMessage()); 
			System.out.println(); 
			continue; 
			} catch (SystemErrorException e) {//継続不能なエラーの場合、ループを抜ける 
			System.out.println(e.getMessage()); 
			e.printStackTrace(); 
			break; 
			}
		} while (menuNo != 7);
		MenuNoReader.Close();
	}
}