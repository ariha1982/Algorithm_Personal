class Solution {
    public long solution(long k, long d) {
        long answer = 0;
        for(long i=0; i<=d; i+=k){ //x
            long y = (long) Math.sqrt((d+i)*(d-i));
            answer+=y/k +1;
        }
    
        
        return answer;
    }
}