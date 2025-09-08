package jp.co.sss.crud.util;

public class ConstantValue {
	
	//インスタンス化を禁止
	private ConstantValue() {
	}
	
	public static final String MENU_LABEL = "=== 社員管理システム ===";
	public static final String MENU_1_FINDALL = "1.全件表示";
	public static final String MENU_2_FINDBYNAME = "2.社員名検索";
	public static final String MENU_3_FINDBYID = "3.部署ID検索";
	public static final String MENU_4_INSERT = "4.新規登録";
	public static final String MENU_5_UPDATE = "5.更新";
	public static final String MENU_6_DELETE = "6.削除";
	public static final String MENU_7_CLOSE = "7.終了";
	
	public static final String EMP_COLUMN_NAME = "社員ID\t社員名\t性別\t生年月日\t部署名";
	
	public static final String EMP_NAME = "社員名：";
	public static final String GENDER = "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";
	public static final String BIRTHDAY = "生年月日(西暦年/月/日):";
	public static final String DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部):";
	
	public static final String NODATE = "回答なし";
	public static final String MALE = "男性";
	public static final String FEMALE = "女性";
	public static final String OTHER = "その他";
	
	public static final String SALES = "営業部";
	public static final String ACCOUNTING = "経理部";
	public static final String AFFAIRS = "総務部";	

}
