class Solution
{
    public long solution(long n, long a, long b)
    {
        long index = (long)(Math.log(n) / Math.log(2));
        long answer = index;
        
        //절반을 기준으로 같은 곳에 있으면 큰지 작은지 판단해서 절반의 절반을 더하거나 뺀다.
        long boundary = (long) Math.pow(2, index);
        for(long i=0; i<=index; i++){
            boolean ACB = a > boundary;
            boolean BCB = b > boundary;
            
            if(ACB != BCB){
                answer = index-i+1;
                break;
            } else {
                if(ACB == true){
                    boundary += (long) Math.pow(2, index-(i+1));
                } else {
                    boundary -= (long) Math.pow(2, index-(i+1));
                }
            }
        }
        
        //System.out.println(answer);

        return answer;
    }
}