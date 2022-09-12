package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1676_팩토리얼0의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int num = Integer.parseInt(br.readLine());
		int count = 0;
 
		while (num >= 5) {
			count += num / 5;
			num /= 5;
		}
		System.out.println(count);
	}


}
