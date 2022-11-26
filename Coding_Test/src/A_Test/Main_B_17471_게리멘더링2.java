package A_Test;

import java.util.*;
import java.io.*;

public class Main_B_17471_게리멘더링2 {
	
	static int n;
	static int [] num;
	static int [][] graph;
	static boolean [] v;
	

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/17471.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		num = new int [n];
		graph = new int [n+1][n+1];
		v = new boolean [n+1];
 		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int range = Integer.parseInt(st.nextToken());
			for (int j = 0; j < range; j++) {
				graph[i][Integer.parseInt(st.nextToken())] = 1;
			}
		}
		
		print(graph);
		
	}


	private static void print(int[][] graph) {
		for (int [] data_arr : graph) {
			for (int data : data_arr) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
	}


}
