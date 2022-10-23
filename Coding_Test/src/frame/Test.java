package frame;

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Test {
	
	static int N;
	static boolean[] canCheck = new boolean[40001];

    public static void main(String[] args) throws IOException{
    	System.setIn(new FileInputStream("input/2629.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            int choo = Integer.parseInt(st.nextToken());
            boolean[] tempCanCheck = new boolean[40001];
            for (int j = 0; j < 40001; j++) {
                if (canCheck[j]) {
                    tempCanCheck[j] = true;
                    tempCanCheck[Math.abs(choo-j)] = true;
                    tempCanCheck[choo+j] = true; // 범위 안 벗어남: 500 * 30 < 40000
                }
            }
            tempCanCheck[choo] = true;

            canCheck = tempCanCheck;
        }

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {

            sb.append(canCheck[Integer.parseInt(st.nextToken())]? "Y ": "N ");
        }
        System.out.println(sb);
    }

}