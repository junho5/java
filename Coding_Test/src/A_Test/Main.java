package A_Test;

import java.util.*;
import java.io.*;

public class Main {
	
	static int N,K;
	static int start,end;
	static int [] belt;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/20055.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 벨트 길이
		K = Integer.parseInt(st.nextToken()); // 제한 수 
		
		belt = new int [2 * N];
		start = 0;
		end = N - 1;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < belt.length; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(Arrays.toString(belt));
		move(belt);
		System.out.println(Arrays.toString(belt));
		
	}

	private static void move(int[] belt) {
		int temp = belt[1];
		for (int i = 1; i < belt.length-1; i++) {
			belt[i] = temp;
//			System.out.println(Arrays.toString(belt));
			temp = belt[i+1];
		}
	}


}
