import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int com,line;
    static int count = 0;
    static int[][] matrix;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        com = Integer.parseInt(br.readLine()); //정점 개수(컴퓨터 수)
        line = Integer.parseInt(br.readLine()); //간선 개수(연결 수)
        
        matrix = new int[com+1][com+1];
        visited = new boolean[com+1];
        
        for(int i=0; i<line; i++){
        	st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            matrix[v1][v2] = 1;
            matrix[v2][v1] = 1;
        }

        dfs(1);
        System.out.println(count);    
    }
   
    private static void dfs(int idx){
    	visited[idx] = true;
    	
    	for(int i=1; i<com+1; i++){
		    if(!visited[i] && matrix[idx][i] == 1){
			    dfs(i);
			    count++;
		    }
	    }
    }
}