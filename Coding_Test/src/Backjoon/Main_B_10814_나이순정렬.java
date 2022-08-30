package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_10814_나이순정렬 {
	
	
	public static void main(String[] args) throws Exception  {
//		System.setIn(new FileInputStream("input/1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		
		String arr [][] = new String [num][2];
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		
		Arrays.sort(arr, new Comparator<String []>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
			
		for (String [] data_arr : arr) {
			for (String data : data_arr) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
		
	
	}


}
