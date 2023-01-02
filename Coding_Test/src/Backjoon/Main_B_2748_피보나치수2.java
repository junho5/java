package Backjoon;

import java.util.*;
import java.io.*;

// 90 까지이므로 long타입으로 해줘야 한다.
public class Main_B_2748_피보나치수2 {
	
	static int n;
	static long [] arr;
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new long [91];
		arr[0] = 0;
		arr[1] = 1;
		
		System.out.println(fivo(n));
		
	}

	private static long fivo(int n) {
		if (n <= 1) {
			return n;
		}else if (arr[n] != 0) {
			return arr[n];
		}else {
			arr[n] = fivo(n-1) + fivo(n-2);
			return arr[n];
		}
	}
	
 
}



