package frame;

import java.util.*;


import java.io.*;

public class Test {
/*
1 5 4 0 2 3
0 2 5 0 4 5
6 0 0 4 0 0
2 2 2 4 3 0
6 0 4 0 0 0
 */
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input/.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int H = 5;
		int W = 6;
		int [][] map = new int [H][W];
		int [][] newmap = new int [H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < W; i++) {
			List<Integer> list = new ArrayList<Integer>();
			for (int j = H -1 ; j >= 0; j--) {
				if (map[j][i] != 0) {
					list.add(map[j][i]);
				}
			}
			
			for (int j = 1; j <= list.size(); j++) {
				newmap[H-j][i] = list.get(j-1);
			}
		}
		print(map);
		System.out.println("--------");
		print(newmap);
		
		
//		for (int i = 0; i < x; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < y; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
////		print(map);
//		
//		for (int i = 0; i < y; i++) {
//			List<Integer> list = new ArrayList<Integer>();
//			for (int j = x-1; j >= 0; j--) {
//				if (map[j][i] != 0) {
//					list.add(map[j][i]);
//				}
//			}
//			for (int j = 1; j <= list.size(); j++) {
//				map2[x-j][i] = list.get(j-1);
//			}
//		}
//		print(map2);
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
