package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_16637_괄호추가하기 {
    static int answer;
    static List<Integer> num_list;
    static List<Character> op_list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = Integer.MIN_VALUE;
        num_list = new ArrayList<Integer>();
        op_list = new ArrayList<Character>();
        
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*') {
				op_list.add(arr[i]);
			}else {
				num_list.add(Character.getNumericValue(arr[i]));
			}
		}

        dfs(num_list.get(0), 0);
        System.out.println(answer);
    }

    private static void dfs(int result, int now) {
        if(now == op_list.size()) {
            answer = Math.max(answer, result);
            return;
        }

        int temp1 = cal(op_list.get(now), result, num_list.get(now+1));
        dfs(temp1, now+1);

        if(now+1 < op_list.size()) {
            int temp2 = cal(op_list.get(now+1), num_list.get(now+1), num_list.get(now+2));
            dfs(cal(op_list.get(now), result, temp2), now + 2);
        }
    }

    private static int cal(char op, int a, int b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 1;
    }
}


	
	



