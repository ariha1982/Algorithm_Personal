import java.util.*;

class Solution {
    private static class Info {
        int sheep, wolf, node;
        HashSet<Integer> visited; 
        
        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }
    
    private static ArrayList<Integer>[] tree;
    private void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        
        for(int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        buildTree(info, edges);
        
        
        // 노드 담을 큐
        Queue<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));
        
        while(!queue.isEmpty()) {
            Info now = queue.poll();
            
            answer = Math.max(now.sheep, answer);
            now.visited.addAll(tree[now.node]);
            
            for(int next : now.visited) {
                // 값을 복사한 해시셋에서 지금 방문할 곳 지우기
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);
                
                if(info[next] == 1) { // 늑대면
                    if(now.sheep != now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                    
                } else { // 양이면
                    queue.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }
        
        return answer;
    }
}