package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n, q;
    public static int[] cars;
    public static int[] m;
    public static int middle;
    public static StringTokenizer st;
    public static StringBuilder sb;
    public static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        cars = new int[n];
        m = new int[q];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cars[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cars);

        for(int i=0;i<q;i++){
            m[i] = Integer.parseInt(br.readLine());
        }

        check=false;
        for(int i=0;i<q;i++){
            for(int j=0;j<n;j++){
                if (cars[j]==m[i]) {
                    middle = j;
                    check = true;
                }
            }
            if(!check){
                if(i==q-1){
                    sb.append(0);
                }else{
                    sb.append(0).append("\n");
                }
                continue;
            }

            if(i==q-1){
                sb.append((middle) * (n-middle-1));
            }else{
                sb.append((middle) * (n-middle-1)).append("\n");
            }

            check = false;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}