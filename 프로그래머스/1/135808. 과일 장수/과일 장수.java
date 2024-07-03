import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int[] boxMaxArr = new int[score[score.length-1] + 1];
        
        for(int i=score.length-m; i>=0; i-=m){
            boxMaxArr[score[i]]++;
        }
        
        for(int i=1; i<boxMaxArr.length; i++) {
            if(boxMaxArr[i] != 0){
                answer += i * m * boxMaxArr[i];
            }
        }
        
        return answer;
    }
}