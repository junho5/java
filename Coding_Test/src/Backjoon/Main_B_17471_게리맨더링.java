package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_17471_게리맨더링 {

	static int N;
	static int map [][];
	static List<Integer> people = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/17471.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				map[i][Integer.parseInt(st.nextToken())] = 1;
			}
		}
		
		for (int [] data_arr : map) {
			for (int data : data_arr) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
		
		
	}

}
