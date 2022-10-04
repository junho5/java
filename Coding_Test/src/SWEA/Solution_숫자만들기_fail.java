package SWEA;


import java.util.*;
import java.io.*;

//1
//5
//2 1 0 1
//3 5 3 7 9

public class Solution_숫자만들기_fail {
	
	static int tc,N,max,min;
	static List<Integer> list;
	static int [] num;
	static int [] op;
	static boolean [] V;
	static Set<String> set;
	
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("input/4008.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
        
    	tc = Integer.parseInt(br.readLine());
    	for (int test_case = 1; test_case <= tc; test_case++) {
    		N = Integer.parseInt(br.readLine());
    		num = new int [N];
    		list = new ArrayList<>();
    		op = new int [N-1];
    		V = new boolean [N-1];
    		set = new HashSet<>();
    		max = Integer.MIN_VALUE;
    		min = Integer.MAX_VALUE;
    		
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < 4; i++) {
    			int range = Integer.parseInt(st.nextToken());
    			for (int j = 0; j < range; j++) {
    				list.add(i);
    			}
    		}
    		
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < N; i++) {
    			num[i] = Integer.parseInt(st.nextToken());
    		}
    		
//        System.out.println(list);
//        System.out.println(Arrays.toString(num));
    		
    		perm(0);
    		sb.append("#");
    		sb.append(test_case);
    		sb.append(" ");
    		sb.append(max-min);
    		sb.append("\n");
    		
    	}
    	System.out.println(sb.toString());
			
	}

	private static void perm(int cnt) {
		if (cnt == N-1) {
//			System.out.println(Arrays.toString(op));
//			cal(op);
			StringBuilder check = new StringBuilder();
			for (int data : op) {
				check.append(data);
			}
//			System.out.println(check.toString());
			String a = check.toString();
			if (!set.contains(a)) {
				set.add(a);
				cal(op);
			}
//			System.out.println(set);
			return;
		}
		
		for (int i = 0; i < list.size(); i++) {
			if(V[i] == true) continue;
			op[cnt] = list.get(i);
			V[i] = true;
			perm(cnt+1);
			V[i] = false;
		}
	}

	private static void cal(int[] op) {
		int temp = num[0];
		int index = 1;
		
		for (int i = 0; i < N-1; i++) {
			switch (op[i]) {
			case 0:
				temp += num[index];
				index ++;
				break;
			case 1:
				temp -= num[index];
				index ++;
				break;
			case 2:
				temp *= num[index];
				index ++;
				break;
			case 3:
				temp /= num[index];
				index ++;
				break;
			}
//			System.out.println(temp);
		}
//		System.out.println(temp);
		
		if (max < temp) max = temp;
		if (min > temp) min = temp;
	}
}





