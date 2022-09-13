package Inflearn.Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part1_단어뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
//		for (int i = 0; i<tc;i++) {
//			StringBuilder sb = new StringBuilder();
//			String word = br.readLine();
//			sb.append(word);
//			sb.reverse();
//			System.out.println(sb.toString());
//		}
		
		for (int i = 0;i<tc;i++) {
			String word = br.readLine();
			char [] arr = new char[word.length()];
			int cnt = 0;
			for (int j = word.length()-1; j >= 0; j--) {
				arr[cnt] = word.charAt(j);
				cnt ++;
			}
			String answer = new String(arr);
			System.out.println(answer);
		}
	}

}
