package softeer;

import java.util.*;
import java.io.*;


public class 성적평균{

    static int n,k;
    static int [] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int [n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int total = 0;
            float cnt = 0;
            for (int j = x-1; j<y; j++ ){
                total += arr[j];
                cnt++;
            }
            float ans = total / cnt;

            System.out.printf("%.2f\n", ans);

        }
        

    }
}