package Backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B_15655_N과M10 {
	
	static int N,M,check;
	static int [] numbers;
	static int [] input;
	static boolean [] selected;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/15663.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		input = new int [N];
		numbers = new int [M];
		selected = new boolean[N];
		
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		perm1(0,0);
		System.out.println(sb.toString());
		
	}
	
	private static void perm1(int cnt,int start) {
		if (cnt == M) {
			String word = "";
			for (int data : numbers) {
				word += data;
				word += " ";
			}
			if (!set.contains(word)) {
				set.add(word);
				sb.append(word);
				sb.append("\n");
			}
			return;
		}
		
		for (int i = start; i < input.length; i++) {
			numbers[cnt] = input[i];
			perm1(cnt+1,i+1);
		}
		
	}
	
}
