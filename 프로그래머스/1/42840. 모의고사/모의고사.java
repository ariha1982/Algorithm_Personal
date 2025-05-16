import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        // Pattern
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // Check Answer
        int[] score = {0, 0, 0};
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == pattern1[i % pattern1.length])
                score[0] += 1;
            if(answers[i] == pattern2[i % pattern2.length])
                score[1] += 1;
            if(answers[i] == pattern3[i % pattern3.length])
                score[2] += 1;
        }
        
        // Get Max Score
        int maxScore = Arrays.stream(score).max().getAsInt();
        
        // Person Who Get Answer
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(score[i] == maxScore)
                answerList.add(i+1);
        }
        
        // ArrayList -> Array
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}