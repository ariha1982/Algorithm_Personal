import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        double solverCount = stages.length;
        
        int[] stageCount = new int[N+1];
        for(int i = 0; i < stages.length; i++) {
            stageCount[stages[i] - 1] += 1;
        }
        
        double[][] failRate = new double[N][2];
        for(int i = 0; i < N; i++) {
            if(stageCount[i] == 0) {
                failRate[i][0] = i;
                failRate[i][1] = 0;
            } else {
                failRate[i][0] = i;
                failRate[i][1] = stageCount[i] / solverCount;
                solverCount -= stageCount[i];
            }
        }
        
        Arrays.sort(failRate, (o1, o2) -> {
            return Double.compare(o2[1], o1[1]);
        });
        
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = (int)failRate[i][0] + 1;
        }
        return answer;
    }
}