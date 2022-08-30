package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1181_단어정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<String>();
		
		int tc = Integer.parseInt(br.readLine());
		String [] arr = new String[tc];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}else {
					return o1.length() - o2.length();
				}
			}
		});
		
		for (String data : arr) {
			if (!list.contains(data)) {
				list.add(data);
			}
		}
		
		for (String data : list) {
			System.out.println(data);
		}
		
		

	}

	
}
