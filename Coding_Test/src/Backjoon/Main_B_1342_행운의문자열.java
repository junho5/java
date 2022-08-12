package Backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_B_1342_행운의문자열 {

	static String N;
	static char[] arr;
	static char[] numbers;
	static int[] alpha;
	static boolean[] isSelected;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1342.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<Integer>();
		N = br.readLine();
		arr = N.toCharArray();
//		System.out.println(Arrays.toString(arr));
		
		alpha = new int [26];
		for (int i = 0; i<arr.length;i++) {
			int index = arr[i] - 'a';
			alpha[index] += 1;
		}
		for (int i = 0; i<alpha.length;i++) {
			if(alpha[i] > 1) {
				list.add(alpha[i]);
			}
		}
		int div = 1;
		for (int i = 0; i < list.size(); i++) {
			div *= fact(list.get(i));
		}
		
		numbers = new char[N.length()];
		isSelected = new boolean[N.length()]; 
		
		num(0);
		System.out.println(answer/div);
		
	}
	
		private static void num(int cnt) {
			if (cnt == N.length()) {
				int check = 0;
				for (int i = 0; i < arr.length-1; i++) {
					if (numbers[i] == numbers[i+1]) {
						check = 1;
					}
				}
				if (check != 1) {
					answer += 1;
//					System.out.println(Arrays.toString(numbers));
				}
				return;
			}
			
			for (int i = 0; i<arr.length; i++) {
				if(isSelected[i]) continue;
				numbers[cnt] = arr[i];
				isSelected[i] = true;
				num(cnt+1);
				isSelected[i] = false;
			}
		}
		
		private static int fact(int number) {
			if (number == 1) {
				return 1;
			}
			return number * fact(number-1);
		}
		
	

}

