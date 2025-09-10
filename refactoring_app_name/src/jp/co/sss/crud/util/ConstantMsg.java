package jp.co.sss.crud.util;

public class ConstantMsg {
	
	//インスタンス化を禁止
	private ConstantMsg() {
	}
	
	public static final String MSG_MENU = "メニュー番号を入力してください：";
	public static final String MSG_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";
	
	public static final String MSG_UPDATE_DEPT_ID = "更新する社員の社員IDを入力してください：";
	public static final String MSG_DELETE_DEPT_ID = "削除する社員の社員IDを入力してください：";
	
	public static final String MSG_NOT_FIND = "該当者はいませんでした";
	public static final String MSG_EMPLOYEE_UPDATE = "社員情報を更新しました";
	public static final String MSG_EMPLOYEE_INSERT = "社員情報を登録しました";
	public static final String MSG_EMPLOYEE_DELETE = "社員情報を削除しました";
	
	public static final String MSG_CLOSE = "システムを終了します。";
	
	public static final String MSG_SYSTEM_ERRO = "システムエラーが発生しました";
	public static final String MSG_SYSTEM_ERROR = "システムエラーが発生しました";
}
