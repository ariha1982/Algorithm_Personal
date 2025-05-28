import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        Stack<Integer[]> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            Integer[] val = {i, prices[i]};
            
            // 스택이 비었거나 상승장일 때
            if (stack.isEmpty() || stack.peek()[1] <= prices[i]) {
                stack.push(val);
                
            } else {
                // 스택이 비어있지 않고 하락장일 때 기간 추가
                while(!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                    Integer[] tmp = stack.pop();
                    answer[tmp[0]] = i - tmp[0];
                }
                stack.push(val);
            }
        }
        
        // 스택에 남아있는 값들 기간 추가
        while(!stack.isEmpty()) {
            Integer[] tmp = stack.pop();
            answer[tmp[0]] = (prices.length - 1) - tmp[0];
        }
        
        return answer;
    }
}