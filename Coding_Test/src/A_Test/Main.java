package A_Test;

import java.util.*;
import java.io.*;

public class Main {
	
<<<<<<< HEAD
	static int tc;
	static int num,height;
	static Integer [] arr;
	static boolean [] v;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/1486.txt"));
=======

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/.txt"));
>>>>>>> 20da6782c40651b758e8cf05061faad0c1d70364
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
<<<<<<< HEAD
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			v = new boolean[num];
			
			arr = new Integer[num];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, Collections.reverseOrder());
			System.out.println(Arrays.toString(arr));
			
			subset(0);
		}
=======
>>>>>>> 20da6782c40651b758e8cf05061faad0c1d70364
		
		
	}

<<<<<<< HEAD
	private static void subset(int index) {
		if (index == num) {
			for (int i = 0; i < num; i++) {
				if (v[i] == true) {
					System.out.println("true");
				}else {
					System.out.println("false");
				}
			}
			return;
		}
		
		v[index] = true;
		subset(index + 1);
		v[index] = false;
		subset(index + 1);
	}


=======
>>>>>>> 20da6782c40651b758e8cf05061faad0c1d70364

}
