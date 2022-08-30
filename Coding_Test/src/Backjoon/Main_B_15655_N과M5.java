package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_15655_N과M5 {
	
	static int N,M;
	static int [] numbers;
	static int [] input;
	static boolean [] selected;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		
		st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		numbers = new int [M];
		selected = new boolean [N];
		input = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		perm1(0);
		System.out.println(sb.toString());
		
	}

	private static void perm1(int cnt) {
		if (cnt == M) {
			for (int data : numbers) {
				sb.append(data);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < input.length; i++) {
			if (selected[i]) continue;
			
			numbers[cnt] = input[i];
			selected[i] = true;
			perm1(cnt+1);
			selected[i] = false;
		}
		
	}
}
