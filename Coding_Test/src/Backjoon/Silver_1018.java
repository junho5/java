package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Silver_1018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		int row_plus = row - 8;
		int col_plus = col - 8;
		int result = 0;
		int result2 = 0;
		int w_result = Integer.MAX_VALUE;
		int b_result = Integer.MAX_VALUE;
		int cnt = 0;
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
		for (int plus_row = 0; plus_row<=row_plus; plus_row++) {
			for (int plus_col = 0; plus_col<=col_plus; plus_col++) {
				result = 0;
				for (int i = 0+plus_row; i<plus_row+8; i++) {
					for (int j = 0+plus_col; j<plus_col+8; j++) {
						if (i % 2 ==0) {
							if (j % 2 ==0 && arr[i][j]!='W') {
								result += 1;
							}else if ( j % 2 !=0 && arr[i][j]!='B') {
								result += 1;
							}
						}
						else {
							if (j % 2 ==0 && arr[i][j]!='B') {
								result += 1;
							}else if ( j % 2 !=0 && arr[i][j]!='W') {
								result += 1;
							}
						}
					}
				}
				if (result<w_result) {
					w_result = result;
				}
				
			}
		}
			
		// B인 경우
		for (int plus_row = 0; plus_row<=row_plus; plus_row++) {
			for (int plus_col = 0; plus_col<=col_plus; plus_col++) {
				result2 = 0;
				for (int i = 0+plus_row; i<plus_row+8; i++) {
					for (int j = 0+plus_col; j<plus_col+8; j++) {
						if (i % 2 ==0) {
							if (j % 2 ==0 && arr[i][j]!='B') {
								result2 += 1;
							}else if ( j % 2 !=0 && arr[i][j]!='W') {
								result2 += 1;
							}
						}
						else {
							if (j % 2 ==0 && arr[i][j]!='W') {
								result2 += 1;
							}else if ( j % 2 !=0 && arr[i][j]!='B') {
								result2 += 1;
							}
						}
					}
				}
				if (result2<b_result) {
					b_result = result2;
				}
			}
		}
		if (w_result < b_result) {
			System.out.println(w_result);
		}else {
			System.out.println(b_result);
		}
	}
}
