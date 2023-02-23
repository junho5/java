package frame;

import java.util.*;
import java.io.*;

public class test {
	
	static int [][] table;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		table = new int[24][60];
		
		for (int [] data_arr : table) {
			System.out.println(Arrays.toString(data_arr));
		}
		
		
	}


}
