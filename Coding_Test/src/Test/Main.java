package Test;


import java.util.*;

import java.io.*;

public class Main {
	
	static int num;
	static int [][] map;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/17070.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		num = Integer.parseInt(br.readLine());
		map = new int [num+1][num+1];
		
		for (int i = 1; i <= num; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= num; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map[1][1] = 7;
		map[1][2] = 7;
		print(map);
		
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

