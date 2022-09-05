package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_7568_덩치 {


	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/7568.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int [][] arr = new int[n][2];
		int [] answer = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			int x = arr[i][0];
			int y = arr[i][1];
			int check = 0;
			for (int j = 0; j < arr.length; j++) {
				if (i==j) continue;
				if (x<arr[j][0] && y < arr[j][1]) {
					check++;
				}
			}
			answer[i] = check+1;
		}
		
		for (int data : answer) {
			System.out.print(data + " ");
		}
		

	}
}



