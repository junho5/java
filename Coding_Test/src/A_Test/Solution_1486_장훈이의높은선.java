package A_Test;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;
 
public class Solution_1486_장훈이의높은선 {
     
    static int tc;
    static int num,height,sum,ans;
    static Integer [] arr;
    static boolean [] v;
 
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("input/1486.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        tc = Integer.parseInt(br.readLine()); // 테스트 케이스 수
         
        for (int test_case = 1; test_case <= tc; test_case++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken()); // 점원 수
            height = Integer.parseInt(st.nextToken()); // 높이
            v = new boolean[num];
            ans = Integer.MAX_VALUE;
             
            arr = new Integer[num];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
             
            Arrays.sort(arr, Collections.reverseOrder());
//          System.out.println(Arrays.toString(arr));
             
            subset(0);
            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            sb.append(ans);
            sb.append("\n");
        }
        System.out.println(sb.toString());
         
         
    }
 
    private static void subset(int index) {
        if (index == num) {
            sum = 0;
            for (int i = 0; i < num; i++) {
                if (v[i] == true) {
                    sum += arr[i];
//                  System.out.printf("%d ",arr[i]);
                }else {
//                  System.out.printf("x ");
                }
            }
//          System.out.println();
            if (sum >= height) {
                ans = Math.min(ans, Math.abs(height-sum));
            }
//          System.out.println(ans);
            return;
        }
         
        v[index] = true;
        subset(index + 1);
        v[index] = false;
        subset(index + 1);
    }
 
 
 
}
