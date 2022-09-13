package Inflearn.Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Part1_중복문자제거 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char [] arr = br.readLine().toCharArray();
		List<Character> list = new ArrayList<Character>();
		
		for (int i = 0 ;i<arr.length;i++) {
			if (!list.contains(arr[i])) {
				list.add(arr[i]);
				sb.append(arr[i]);
			}
		}
		System.out.println(sb.toString());
	}

}
