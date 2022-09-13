package Inflearn.Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Part1_특정문자뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char [] arr = br.readLine().toCharArray();
		
		int cnt = 1;
		int left = 0;
		int right = arr.length-1;
		while (left<right) {
			if (!Character.isAlphabetic(arr[left])){
				left ++;
			}else if (!Character.isAlphabetic(arr[right])){
				right --;
			}else {
				char temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left ++;
				right --;
			}
		}
		String answer = new String(arr);
		System.out.println(arr);
	}
}
