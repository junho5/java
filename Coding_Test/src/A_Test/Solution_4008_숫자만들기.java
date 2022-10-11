package A_Test;

import java.util.*;
import java.io.*;

public class Solution_4008_숫자만들기 {
	
	static int tc,N,max,min;
	static List<Integer> list;
	static int [] num;
	static int [] op;
	static int [] op_num;
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
    		op = new int [4]; // + - * / 개수 들어갈 배열
    		op_num = new int [N-1]; // 연산자 개수 넘길때 사용
    		V = new boolean [N-1];
    		set = new HashSet<>();
    		max = Integer.MIN_VALUE;
    		min = Integer.MAX_VALUE;
    		
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < 4; i++) {
    			op[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < N; i++) {
    			num[i] = Integer.parseInt(st.nextToken());
    		}
    	
    		System.out.println(Arrays.toString(op));
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
			System.out.println(Arrays.toString(op_num));
			cal(op_num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(op[i] == 0) continue;
			op[i]--;
			op_num[cnt] = i;
			perm(cnt+1);
			op[i]++;
		}
	}

	private static void cal(int[] op) {
		int temp = num[0];
		int index = 1;
		
		for (int i = 0; i < N-1; i++) {
			switch (op_num[i]) {
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


