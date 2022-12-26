package Inflearn.Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Part1_암호 {

    public static String solution(int n, String s) {

        StringBuilder sb = new StringBuilder();
        String binary = s.replace("#", "1").replace("*", "0");

        for (int i = 0; i < n; i++) {
            char c = (char) Integer.parseInt(binary.substring(i*7, i*7+7), 2);
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        System.out.println(solution(n, s));
    }
}
