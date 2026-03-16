class Solution {
    private static boolean[] visit;
    private static int[][] computer;
    
    private static void dfs(int now) {
        visit[now] = true;
        for(int i = 0; i < computer[now].length; i++) {
            if(computer[now][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visit = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            System.out.println(answer);
            if(!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
}