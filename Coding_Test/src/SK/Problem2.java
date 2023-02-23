package SK;

import java.util.*;
import java.io.*;

public class Problem2 {
	
	static int [] p,b,ans;
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		p = new int [] {2,2,-1,1,5,-1,5};
//		b = new int [] {2,5};
		b = new int [] {1,5};
		ans = new int [b.length];
		
		for (int i = 0; i < b.length; i++) {
			int temp = b[i];
			int cnt = 0;
			if (p[temp] != -1) {
				ans[i] = 0;
			}else {
				cnt++;
				for (int j = 0; j<p.length; j++) {
					if (p[j] == temp) {
						cnt++;
					}
					if (p[j] >= 0 && p[p[j]] == temp) {
						cnt++;
					}
					ans[i] = cnt;
				}
			}
		}
		
		System.out.println(Arrays.toString(ans));
		
	}
}
