package frame;

import java.util.*;
import java.io.*;

public class Test2 {
	
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
			int cho = Integer.parseInt(st.nextToken());
			boolean [] temp = new boolean [40001];
			for (int j = 0; j < 40001; j++) {
				if(canCheck[j]) {
					temp[j] = true;
					temp[Math.abs(cho-j)] = true;
					temp[cho+j] = true;
				}
			}
			temp[cho] = true;
			canCheck = temp;
        	
		}
        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
			
        	sb.append(canCheck[Integer.parseInt(st.nextToken())] ? "y" : "n");
		}
System.out.println(sb.toString());        
    }
    
}