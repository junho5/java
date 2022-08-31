package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_11650_좌표정렬 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/11650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<String>();
		
		int tc = Integer.parseInt(br.readLine());
		int [][] arr = new int[tc][2];
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(arr, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		for (int [] data_arr : arr) {
			for (int data : data_arr) {
				System.out.print(data + " ");
			}
			System.out.println();
		}

		
		

	}

	
}
