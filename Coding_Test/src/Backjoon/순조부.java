package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 순조부 {
	
	static int N,M;
	static int[] numbers;
	static int[] input;
	static boolean[] selected;
	static boolean[] selected_subset;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); 
		
		numbers = new int[M];
		input = new int [] {1,2,3};
		selected = new boolean[input.length];
		selected_subset = new boolean[M];
		
		perm1(0);
//		perm2(0);
//		perm3(0,0);
//		perm4(0,0);
//		subset(0);
	}
	
	private static void perm1(int cnt) {
		if (cnt == M) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < input.length; i++) {
			numbers[cnt] = input[i];
			perm1(cnt+1);
		}
	}
	
	private static void perm2(int cnt) {
		if (cnt == M) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < input.length; i++) {
			if (selected[i] == true) continue;
			numbers[cnt] = input[i];
			selected[i] = true;
			perm2(cnt+1);
			selected[i] = false;
		}
		
	}
	
	private static void perm3(int cnt,int start) {
		if (cnt == M) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i < input.length; i++) {
			numbers[cnt] = input[i];
			perm3(cnt+1,i);
		}
	}
	
	private static void perm4(int cnt,int start) {
		if (cnt == M) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i < input.length; i++) {
			numbers[cnt] = input[i];
			perm3(cnt+1,i+1);
		}
	}
	
	private static void subset(int index) {
		if (index == M) {
			for (int i = 0; i < M; i++) {
				if (selected_subset[i] == true) {
					System.out.printf("%d ",input[i]);
				}else {
					System.out.print("x ");
				}
			}
			System.out.println();
			return;
		}
		
		selected_subset[index] = true;
		subset(index+1);
		selected_subset[index] = false;
		subset(index+1);
		
	}

}
