package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순열_조합 {

	static int N,M;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 숫자 범위
		M = Integer.parseInt(st.nextToken()); // 숫자 범위
		
		numbers = new int[M];
		isSelected = new boolean[N+1]; 
		num(0);
		System.out.println(sb.toString());
		
	}
	
		private static void num(int cnt) {
			if (cnt == M) {
				for (int data : numbers) {
					sb.append(data);
					sb.append(" ");
				}
				sb.append("\n");
				return;
			}
			
			for (int i = 1; i<=N; i++) {
				if(isSelected[i]) continue;
				numbers[cnt] = i;
				isSelected[i] = true;
				num(cnt+1);
				isSelected[i] = false;
			}
		}
		
	

}
