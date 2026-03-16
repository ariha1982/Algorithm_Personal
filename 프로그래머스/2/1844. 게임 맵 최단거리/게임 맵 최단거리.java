import java.util.ArrayDeque;

class Solution {
    
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    
    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] maps) {
        // 맵 크기
        int N = maps.length;
        int M = maps[0].length;
        
        // 루트 저장 배열
        int[][] dist = new int[N][M];
        
        // BFS용 큐
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        // 큐 초기화
        queue.addLast(new Node(0,0));
        dist[0][0] = 1;
        
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            
            for(int i = 0; i < 4; i++) { // 상하좌우 확인
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];
                
                // 예외1: 맵 밖으로 나가는 경우
                if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;
                
                // 예외2: 벽으로 가는 경우
                if(maps[nr][nc] == 0)
                    continue;
                
                if(dist[nr][nc] == 0) { // 미방문 노드일 경우
                    queue.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        
        return dist[N-1][M-1] == 0 ? -1 : dist[N-1][M-1];
    }
}