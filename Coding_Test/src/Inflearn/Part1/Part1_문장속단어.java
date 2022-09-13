package Inflearn.Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Part1_문장속단어 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int max = 0;
		String answer="";
		
		
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			if (max < temp.length()) {
				max = temp.length();
				answer = temp;
			}
		}
		System.out.println(answer);
	}

}
