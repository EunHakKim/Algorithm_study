package org.example;


import java.io.*;
import java.util.*;

public class Main {

    static int [][] map;
    static int [][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] start = new int[2];
        int seq = 2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            if(i==0){
                start[0] = y;
                start[1] = x;
                visited[y][x] = 1;
            }
            else map[y][x] = seq++;
        }

        backTracking(start[0], start[1], 2);
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int curY, int curX, int next) {

        if (next == m+1) {
            answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = curX + dx[i];
            int ny = curY + dy[i];
            if(ny<0||ny>=n||nx<0||nx>=n)continue;
            if(visited[ny][nx]==1||map[ny][nx]==1) continue;
            if(map[ny][nx]>1&&map[ny][nx]!=next)continue;
            visited[ny][nx] = 1;
            if(map[ny][nx]==next) backTracking(ny, nx, next + 1);
            else backTracking(ny, nx, next);
            visited[ny][nx] = 0;
        }
    }
}