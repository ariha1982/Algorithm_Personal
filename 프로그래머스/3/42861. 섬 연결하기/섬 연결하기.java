import java.util.*;

class Solution {
    private static int[] parents;
    
    // 루트 노드 찾기
    private static int find(int x) {
        if ( parents[x] == x ) {
            return x;
        }
        
        return parents[x] = find(parents[x]);
    }
    
    // 합치기
    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        
        parents[root1] = root2;
    }
    
    public int solution(int n, int[][] costs) {
        // 가중치 기준 오름차순으로 정렬
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        // 집합 초기화
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        int answer = 0;
        int edges = 0;
        
        for(int[] edge : costs) {
            if (edges == n - 1) {
                break;
            }
            
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }
        
        return answer;
    }
}