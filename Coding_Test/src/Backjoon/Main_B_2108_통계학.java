package Backjoon;

import java.util.*;
import java.io.*;
 
public class Main_B_2108_통계학 {
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/2108.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		int [] arr = new int[tc];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		sb.append(Math.round((double)sum/arr.length));
		sb.append("\n");
		Arrays.sort(arr);
		sb.append(arr[arr.length/2]);
		sb.append("\n");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for (int data : arr) {
			map.put(data, 0);
		}
		for (int data : arr) {
			map.put(data, map.get(data)+1);
		}
		int max = 0;
		for (int data : map.keySet()) {
			if (max <= map.get(data)) max = map.get(data);
		}
		for (int data : map.keySet()) {
			if (max == map.get(data)) {
				list.add(data);
			}
		}
		
		Collections.sort(list);
		if (list.size() == 1) {
			sb.append(list.get(0));
			sb.append("\n");
		}else {
			sb.append(list.get(1));
			sb.append("\n");
			
		}
		
		sb.append(arr[arr.length-1] - arr[0]);
		sb.append("\n");
		
		System.out.println(sb.toString());
	}
 
}