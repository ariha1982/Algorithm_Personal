import java.util.*;

class Solution {
    private static char[][] maze;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int N, M;
    
    private static class Node {
        int r, c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        Node start = null, lever = null, end = null;
        // 배열 정리(S,L,E 파악을 위해 한 글자씩 확인)
        maze = new char[N][M];
        for(int i = 0; i < N; i++) {
            maze[i] = maps[i].toCharArray();
            for(int j = 0; j < M; j++) {
                if(maze[i][j] == 'O' || maze[i][j] == 'X') {
                    continue;
                }
                
                if (maze[i][j] == 'S') {
                    start = new Node(i, j);
                } else if (maze[i][j] == 'L') {
                    lever = new Node(i, j);
                } else if (maze[i][j] == 'E') {
                    end = new Node(i, j);
                }
            }
        }
        
       if(start == null || lever == null || end == null)
           return -1;
        
        int startToLever = bfs(start, lever);
        if(startToLever == -1)
            return -1;
        
        int LeverToEnd = bfs(lever, end);
        if(LeverToEnd == -1)
            return -1;
        
        return startToLever + LeverToEnd;
    }
    
    private int bfs(Node start, Node goal){
        int[][] dist = new int[N][M];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        // 초기화
        queue.addLast(start);
        dist[start.r][start.c] = 1;
        
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            
            for(int i = 0; i < 4; i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];
                
                // 예외1: 미로 밖을 벗어났을 때
                if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;
                
                // 예외2: 벽
                if(maze[nr][nc] == 'X')
                    continue;
                
                // 미방문 노드
                if(dist[nr][nc] == 0) {
                    queue.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        return dist[goal.r][goal.c] == 0 ? -1 : dist[goal.r][goal.c] - 1;
    }
}