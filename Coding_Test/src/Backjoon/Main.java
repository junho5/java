package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		int result = 0;
		int result2 = 0;
		char [][] arr = new char[row][col];
		
		// 배열 생성
		for (int i = 0; i<row; i++) {
			String temp = sc.next();
			for (int j = 0; j<col; j++) {
				char data = temp.charAt(j);
				arr[i][j] = data;
			}
		}
		
		// W인 경우
		for (int i = 0; i<row; i++) {
			for (int j = 0; j<col; j++) {
				if (i % 2 ==0) {
					if (j % 2 ==0 && arr[i][j]!='W') {
						result += 1;
					}
				}
				else {
					if (j % 2 !=0 && arr[i][j]!='W') {
						result += 1;
					}
				}
			}
		}
		System.out.println(result);		
//8 8
//WBWBWBWB
//BWBWBWBW
//WBWBWBWB
//BWBBBWBW
//WBWBWBWB
//BWBWBWBW
//WBWBWBWB
//BWBWBWBW		
		
		
		// B인경우
		for (int i = 0; i<row; i++) {
			for (int j = 0; j<col; j++) {
				if (i % 2 ==0) {
					if (j % 2 ==0 && arr[i][j]!='B') {
						result2 += 1;
					}
				}
				else {
					if (j % 2 !=0 && arr[i][j]!='B') {
						result2 += 1;
					}
				}
			}
		}
		System.out.println(result2);	
		
	}
}
