package Test;

import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String word = br.readLine().toLowerCase();
		String ans = "YES";
		
		// 97 ~ 122
		List<Character> list_1 = new ArrayList<Character>();
		List<Character> list_2 = new ArrayList<Character>();
		
		for (int i = 0; i < word.length(); i++) {
			if(word.charAt(i)-0 >= 97 && word.charAt(i)-0 <= 122) {
				list_1.add(word.charAt(i));
			}
		}
		
//		System.out.println(list_1);
		
		for (int i = 0; i < list_1.size()/2; i++) {
			if(list_1.get(i) != list_1.get(list_1.size()-i-1)) {
				ans = "NO";
				break;
			}
		}
		
		System.out.println(ans);
		
 	}


}
