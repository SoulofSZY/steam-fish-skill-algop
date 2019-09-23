package com.szy.skill.geek.wz.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈无向图〉
 *
 * @author sunzhengyu
 * @create 2019/9/23
 * @since 1.0.0
 */
public class GraphDemo {
    /* 顶点个数 */
    private int v;
    /* 邻接表 */
    private LinkedList<Integer>[] adj;

    public GraphDemo(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索算法 最短路径
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // 记录已经被访问的顶点，用来避免顶点被重复访问
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // 用来存储已经被访问、但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // 记录搜索路径 路径是反向存储
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }

        }
    }

    /**
     * 深度优先搜索  回溯思想
     *
     * @param s
     * @param t
     */
    boolean found = false;

    public void dfs(int s, int t) {
        found = false;
        // 记录已经被访问的顶点，用来避免顶点被重复访问
        boolean[] visited = new boolean[v];
        // 记录搜索路径 路径是反向存储
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    // 递归
    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }

        for (int i = 0; i < adj[w].size(); i++) {
            if (found) {
                return;
            }
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }


    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && s != t) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }

    public static void main(String[] args) {
        GraphDemo graph = new GraphDemo(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

      //  graph.bfs(0, 5);
        graph.dfs(0, 7);
    }
}