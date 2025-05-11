package org.example;

import javax.lang.model.element.VariableElement;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution3341 {
    public int minTimeToReach(int[][] moveTime) {
        int inf = 0x3f3f3f3f;
        int m = moveTime.length;
        int n = moveTime[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], inf);
        }
        dis[0][0] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((s1, s2) -> Integer.compare(s1.dis, s2.dis));
        pq.add(new State(0, 0, 0));
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            State state = pq.poll();
            if (vis[state.x][state.y]) {
                continue;
            }
            vis[state.x][state.y] = true;
            for (int[] dir : dirs) {
                int newX = state.x + dir[0];
                int newY = state.y + dir[1];
                if (newX < 0 || newX > m || newY < 0 || newY > n) {
                    continue;
                }
                int newDis = Math.max(dis[state.x][state.y], moveTime[newX][newY]) + 1;
                if (newDis < dis[newX][newY]) {
                    dis[newX][newY] = newDis;
                    pq.add(new State(newX, newY, newDis));
                }
            }
        }
        return dis[m - 1][n - 1];
    }

    static class State {
        int x;
        int y;
        int dis;
        public State(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
