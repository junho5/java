package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_14889_스타트와링크 {
	
	static int num,answer;
	static int [][] map;
	static int [] member;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/14889.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		num = Integer.parseInt(br.readLine());
		map = new int [num][num];
		member = new int [num/2];
		answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < num; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		print(map);
		perm(0,0);
		System.out.println(answer);
		
		
		
	}

	private static void perm(int cnt, int start) {
		if (cnt == num/2) {
			int temp = 0;
			int temp_x = 0;
			int sum = 0;
			List<Integer> list = new ArrayList<Integer>();
			List<Integer> list_x = new ArrayList<Integer>();
			for (int i = 0; i < member.length; i++) {
				list.add(member[i]);
			}
			
			for (int i = 0; i < num; i++) {
				if(!list.contains(i)) {
					list_x.add(i);
				}
			}
			
			Object[] member_x = list_x.toArray();
			
			for (int i = 0; i < num/2; i++) {
				for (int j = 0; j < num/2; j++) {
					if (i==j) continue;
					temp += map[member[i]][member[j]];
					temp_x += map[(int) member_x[i]][(int) member_x[j]];
				}
			}
//			System.out.println(Arrays.toString(member));
//			System.out.println(Arrays.toString(member_x));
			sum = Math.abs(temp-temp_x);
//			System.out.println(temp);
//			System.out.println(temp_x);
			
			if (answer > sum) {
				answer = sum;
			}
			return;
		}
		
		for (int i = start; i < num; i++) {
			member[cnt] = i;
			perm(cnt+1,i+1);
		}
		
	}

	private static void print(int[][] map) {
		for (int [] data_arr : map) {
			for (int data : data_arr) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
	}
	
}