package Level_1;

import java.util.Arrays;
import java.util.Scanner;

public class Scale {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int [8];
		String result = "mixed";
		for (int i = 0; i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i<arr.length-1;i++) {
			if (arr[0] == 1) {
				if (arr[i]<arr[i+1]) {
					result = "ascending";
				}else {
					result = "mixed";
					break;
				}
			}
			else if (arr[0] == 8) {
				if (arr[i]>arr[i+1]) {
					result = "descending";
				}else {
					result = "mixed";
					break;
				}
			}
			else {
				break;
			}

		}
		System.out.println(result);
		
	}

}
