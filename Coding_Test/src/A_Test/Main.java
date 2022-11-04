package A_Test;

import java.util.*;
import java.io.*;

public class Main {
	
	static int x,y;
	static int [][] map;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/2206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		map = new int [x][y];
		
		
		for (int i = 0; i < x; i++) {
			String row = br.readLine();
			for (int j = 0; j < y; j++) {
				map[i][j] = row.charAt(j)-'0';
			}
		}
		
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
