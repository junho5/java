package softeer;

import java.util.*;
import java.io.*;

public class 징검다리{

    static int n, ans;
    static int [] arr,dp;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int [n];
        dp = new int [n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        
        ans = 1;

        for (int i = 0; i< arr.length; i++){

            for (int j = 0; j<=i; j++){
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        
        
        for (int i = 0; i< arr.length; i++){
            ans = Math.max(ans,dp[i]);
        }

        System.out.println(ans);

    }

}

