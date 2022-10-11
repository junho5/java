package A_Test;

import java.util.*;
import java.io.*;

public class Solution {
	
	static int tc;
	static int N,X;
	static int [][] map;
	static int [][] map2;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int [N][N];
			map2 = new int [N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map2[j][i] = map[i][j];
				}
			}
			
			print(map);
			System.out.println("=========================");
			print(map2);
			
			
//			sb.append("#");
//			sb.append(test_case);
//			sb.append(" ");
		}
//		System.out.println(sb.toString());
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
