package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.util.ConstantMsg;

public class MenuNoReader implements IConsoleReader {
	
	private MenuNoReader() {
	}
	
	public static int InputMenuNo() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int menuNo = 0;
		// メニュー番号の入力
		String menuNoStr = br.readLine();
		menuNo = Integer.parseInt(menuNoStr);
		return menuNo;
	}
	
	public static void Close() {
		System.out.println(ConstantMsg.MSG_CLOSE);
	}

	@Override
	public String getErrorMsg() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean isValid(String inputString) {
		// TODO 自動生成されたメソッド・スタブ
		return inputString.matches("^[1-7１-７]$");//1-7までの数値
	}

	@Override
	public boolean isParseInt() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
