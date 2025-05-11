package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution3342 {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int inf = 0x3f3f3f3f;
        int[][] d = new int[m][n];
        for (int i=0; i<m; i++){
            Arrays.fill(d[i], inf);
        }
        int[][] step = new int[m][n];
        for (int i=0; i<m; i++){
            Arrays.fill(step[i], inf);
        }
        boolean[][] vis = new boolean[m][n];
        d[0][0] = 0;
        step[0][0] = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<State> pq = new PriorityQueue<>((s1, s2) -> Integer.compare(s1.dis, s2.dis));
        pq.add(new State(0, 0, 0, 0));
        while (!pq.isEmpty()) {
            State u = pq.poll();
            if (vis[u.x][u.y]) {
                continue;
            }
            vis[u.x][u.y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = u.x + dirs[i][0];
                int newY = u.y + dirs[i][1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }
                int temp = 0;
                if (u.step == 0) {
                    temp = 1;
                } else if (u.step == 1) {
                    temp = 2;
                } else if (u.step == 2) {
                    temp = 1;
                }
                int newDis = Math.max(d[u.x][u.y], moveTime[newX][newY]) + temp;
                if (newDis < d[newX][newY]) {
                    d[newX][newY] =newDis;
                    pq.add(new State(newX, newY, newDis, temp));
                }
            }

        }
        return d[m - 1][n - 1];

    }

    public static class State {
        int x;
        int y;
        int dis;
        int step;
        public State(int x, int y, int dis, int step)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.step = step;
        }
    }

}
