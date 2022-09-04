package Backjoon;

import java.util.Scanner;

public class Main_B_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int result = 0;
		while(true) {
			if (num % 5 == 0) {
				result += num / 5;
				break;
			}
			else {
				num -= 3;
				result += 1;
			}
			
			if (num < 0) {
				result = -1;
				break;
			}
			
		}
		System.out.println(result);
	}

}
