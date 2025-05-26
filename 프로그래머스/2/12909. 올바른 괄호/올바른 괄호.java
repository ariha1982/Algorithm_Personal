import java.util.Stack;

class Solution {
    boolean solution(String s) {
        
        // 스택 생성
        Stack<Integer> stack = new Stack<>();
        
        // 문자 기준으로 반복문 진행
        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') { // '('이면 push
                stack.push(1);
            
            // ')'이면서 기존 스택이 비어있지 않으면 pop
            } else if((s.charAt(i) == ')') && (!stack.isEmpty())) {
                stack.pop();
                
            // ')'인데 기존 스택이 비었을 경우 false
            } else if ((s.charAt(i) == ')') && (stack.isEmpty())) {
                return false;
            }
        }
        
        // 문자열을 다 돌았는데 stack이 비어있지 않으면 false
        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}