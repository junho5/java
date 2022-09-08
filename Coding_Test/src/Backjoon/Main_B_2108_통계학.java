package Backjoon;

import java.util.*;
import java.io.*;
 
public class Main_B_2108_통계학 {
	
	static int check;
	
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
		System.out.println(Math.round((double)sum/arr.length));
		Arrays.sort(arr);
		HashSet<Integer> set = new HashSet<>();
		for (int data : arr) {
			set.add(data);
		}
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> index_list = new ArrayList<Integer>();
		int [] answer = new int[set.size()];
		for (int data : set) {
			check = 0;
			System.out.println(data);
			for (int i = 0; i < arr.length; i++) {
				if (data == arr[i]) {
					check++;
				}
			}
			list.add(check);
		}
		System.out.println(list);
		int max = Collections.max(list);
		int index = 0;
		for (int data : list) {
			if (max == data) {
				index_list.add(index);
			}
			index++;
		}
		System.out.println(index_list);
		
		int mode = 0;
		if(index_list.size() == 1) {
			mode = index_list.get(0);
		}else {
			mode = index_list.get(1);
		}
		
		System.out.println(arr[arr.length/2]);
		System.out.println(list);
		System.out.println(arr[mode]);
		System.out.println(arr[arr.length-1] - arr[0]);
	}
 
}