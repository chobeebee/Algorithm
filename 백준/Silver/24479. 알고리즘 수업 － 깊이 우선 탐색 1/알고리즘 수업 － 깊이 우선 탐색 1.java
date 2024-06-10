import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int vertexSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int [vertexSize+1];

        for (int i = 0; i <= vertexSize; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i=1; i<=vertexSize; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(graph, visited, start);

        for(int i=1; i<=vertexSize; i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(List<List<Integer>> graph, int[] visited, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        int count = 1;
        int vertex = start;

        while (!stack.isEmpty()) {
            vertex = stack.pop();
            if(visited[vertex] != 0) {
                continue;
            }

            visited[vertex] = count++;
            for(int i = 0; i < graph.get(vertex).size(); i++) {
                if(visited[graph.get(vertex).get(i)] == 0) {
                    stack.push(graph.get(vertex).get(i));
                }
            }
        }
    }
}