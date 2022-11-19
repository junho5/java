package A_Test;

import java.util.*;
import java.io.*;

public class Solution_2112_보호필름 {
	
	static int tc;
	static int x,y,k;
	static int [][] film;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/2112.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			film = new int [x][y];
			
			print(film);
			
			
			
			
//			sb.append("#");
//			sb.append(test_case);
//			sb.append(" ");
		}
//		System.out.println(sb.toString());
	}

	private static void print(int[][] film) {
		for (int [] data_arr : film) {
			for (int data : data_arr) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
	}


}
