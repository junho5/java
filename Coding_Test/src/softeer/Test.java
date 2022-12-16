package softeer;

import java.util.*;
import java.io.*;

public class Test {
	

	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input/.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
//		- -> 45
		
		String word = br.readLine();
		String ans = "";
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
				ans += word.charAt(i);
			}
		}
		
		System.out.println(ans);
	}


}
