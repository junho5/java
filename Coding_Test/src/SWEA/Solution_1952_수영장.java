package SWEA;

import java.util.*;
import java.io.*;

public class Solution_1952_수영장 {

    static int day_p,month_p,month_three_p,year_p,answer;
    static int [] plan;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("input/1952.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            // 1~12 + 3
            plan = new int[15];

            st = new StringTokenizer(br.readLine());

            day_p = Integer.parseInt(st.nextToken());
            month_p = Integer.parseInt(st.nextToken());
            month_three_p = Integer.parseInt(st.nextToken());
            year_p = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 12; j++) {
                plan[j] = Integer.parseInt(st.nextToken());
            }

            answer = year_p;
            dfs(0,0);
            sb.append("#");
            sb.append(i);
            sb.append(" ");
            sb.append(answer);
            sb.append("\n");

        }
        System.out.println(sb.toString());

    }
    private static void dfs(int month, int price) {
        if (month > 11) {
//        	System.out.println(price);
        	answer = Math.min(answer, price);
            return;
        }
        
        // 0이면 플러스 X
        if (plan[month] == 0) {
        	dfs(month+1,price);
        }else {
        	// 1일씩
        	dfs(month+1,price+plan[month]*day_p);
        	// 1달씩 
        	dfs(month+1,price+month_p);
        	// 3달씩
        	dfs(month+3,price+month_three_p);
        }
        
        
        
        
    }
}