package Inflearn.Part1;

import java.util.*;
import java.io.*;

public class Part1_문자거리 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		String inputString = sc.next();
		char inputSearchString = sc.next().charAt(0);

		char[] chars = inputString.toCharArray();
		int[] result = new int[chars.length];
		int tmp = 1000;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == inputSearchString) {
				tmp = 0;
			} else {
				tmp++;
			}
			result[i] = tmp;
		}

		tmp = 1000;
		for (int j = chars.length - 1; j >= 0; j--) {
			if (chars[j] == inputSearchString) {
				tmp = 0;
			} else {
				tmp++;
				result[j] = Math.min(result[j], tmp);
			}

		}

		for (int k = 0; k < chars.length; k++) {
			System.out.print(result[k] + " ");
		}
	}

}
