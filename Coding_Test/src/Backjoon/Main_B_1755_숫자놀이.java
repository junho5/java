package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1755_숫자놀이 {
	
	static int start,end;
	static List<num> list = new ArrayList<>();
	
	static class num{
		String num;
		int or_num;
		
		public num(String num, int or_num) {
			super();
			this.num = num;
			this.or_num = or_num;
		}

		@Override
		public String toString() {
			return "num [num=" + num + ", or_num=" + or_num + "]";
		}

		public int getOr_num() {
			return or_num;
		}

	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/1755.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		for (int i = start; i <= end; i++) {
			String temp = Change(i);
			list.add(new num(temp, i));
		}
		
		Collections.sort(list, new Comparator<num>() {

			@Override
			public int compare(num o1, num o2) {
				return o1.num.compareTo(o2.num);
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			if(i!=0 && i % 10 == 0) System.out.println();
			System.out.print(list.get(i).getOr_num() + " ");
		}
	}

	private static String Change(int num) {
		String change = "";
		String temp = Integer.toString(num);
		for (int i = 0; i < temp.length(); i++) {
			switch (temp.charAt(i)) {
			case '0':
				change += "zero";
				break;
			case '1':
				change += "one";
				break;
			case '2':
				change += "two";
				break;
			case '3':
				change += "three";
				break;
			case '4':
				change += "four";
				break;
			case '5':
				change += "five";
				break;
			case '6':
				change += "six";
				break;
			case '7':
				change += "seven";
				break;
			case '8':
				change += "eight";
				break;
			case '9':
				change += "nine";
				break;
			}
		}
		return change;
	}

}
