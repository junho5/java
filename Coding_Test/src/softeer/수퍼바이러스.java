package softeer;

import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class 수퍼바이러스 {

    static int up,time;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        BigInteger n = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
        up = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        int mod = 1000000007;
        time *= 10;
        System.out.println(n);
//        for(int i = 0; i<time; i++){
//            n *= up;
//
//        }
//        System.out.println(n%mod);
    }
}