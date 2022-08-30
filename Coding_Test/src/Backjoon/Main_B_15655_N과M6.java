package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B_15655_N과M6 {
	
	static int N,M;
	static int [] numbers;
	static int [] input;
	static int [] answer;
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
		input = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (list.contains(input[i])){
				continue;
			}else {
				list.add(input[i]);
			}
		}
		answer = new int [list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		selected = new boolean [answer.length];
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
		
		for (int i = 0; i < answer.length; i++) {
			if(selected[i]==true) continue;
			
			numbers[cnt] = answer[i];
			selected[i] = true;
			perm1(cnt+1);
			selected[i] = false;
		}
		
	}
}
