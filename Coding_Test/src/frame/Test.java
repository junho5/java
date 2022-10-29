package frame;

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Test {
	

    public static void main(String[] args) throws IOException{
//    	System.setIn(new FileInputStream("input/2629.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 8; i++) {
        	if (i == 2) {
        		System.out.println(i);
        		i++;
        	}else {
        		System.out.println(i);
        	}
		}
        
    }

}