package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1920_수찾기 {
	
	static int N,M;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1920.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N =Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		M =Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			int min = 0;
			int max = arr.length-1;
			while(true) {
				int half = (min + max) / 2;
				if (arr[half] == temp) {
					sb.append(1);
					sb.append("\n");
					break;
				}
				
				if (min>=max) {
					sb.append(0);
					sb.append("\n");
					break;
				}
				
				
				if (arr[half] > temp) {
					max = half - 1;
				}else if (arr[half] < temp) {
					min = half + 1 ;
				}
				
			}
		}
		System.out.println(sb.toString());
		
		
		

		
	}


	
	
}
	

