package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuNoReader {
	
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

}
