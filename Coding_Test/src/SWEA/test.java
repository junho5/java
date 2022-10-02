package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class test {
	
	static int N,M,cnt;
	static int[] numbers;
	static int[] input;
	static boolean[] selected_subset;

	public static void main(String[] args) {
		selected_subset = new boolean[8];
		cnt = 0;
		subset(0);
		System.out.println(cnt);
	}
	
	
	private static void subset(int index) {
		if (index == 8) {
			for (int i = 0; i < selected_subset.length-1; i++) {
				if (selected_subset[i] == false && selected_subset[i+1] == false) {
					System.out.println(Arrays.toString(selected_subset));
					System.out.println("불가능");
					continue;
				}else {
					cnt += 1;
				}
			}
			for (int i = 0; i < 8; i++) {
				if (selected_subset[i] == true) {
					System.out.printf("1 ");
				}else {
					System.out.print("2 ");
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
