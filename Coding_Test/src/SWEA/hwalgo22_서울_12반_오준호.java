package SWEA;

import java.util.*;
import java.io.*;

public class hwalgo22_서울_12반_오준호 {
	
	static int N;
	static int [][] arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            arr[i][0] = Math.min(arr[i - 1][1], arr[i - 1][2]) + red;
            arr[i][1] = Math.min(arr[i - 1][0], arr[i - 1][2]) + green;
            arr[i][2] = Math.min(arr[i - 1][0], arr[i - 1][1]) + blue;
        }
        System.out.println(Math.min(arr[N][0], Math.min(arr[N][1], arr[N][2])));

    }
}
