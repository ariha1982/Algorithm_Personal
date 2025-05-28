import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        
        // 괄호 짝 지어놓기
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        int answer = 0;
        char[] a = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            
            // 올바르지 않은 괄호 문자열 발생 플래그
            boolean flag = true;
            
            for(int j = 0; j < s.length(); j++) {
                if(flag) {
                    // out of bound 예외가 발생하지 않도록 mod 연산으로 가져오기
                    char c = s.charAt((i+j) % s.length());
                    
                    // 여는 괄호이면 push
                    if(c == '(' || c == '{' || c == '[') {
                        stack.push(c);

                    } else {
                        // 닫는 괄호 차례일 때 스택이 비었거나, 짝이 안 맞으면
                        if (stack.isEmpty() || stack.pop() != map.get(c)) {
                            
                            // 플래그를 false로 전환
                            flag = false;
                            continue;
                        }
                    }
                }
            }
            
            // 한 바퀴 돌았을 때 플래그 확인 후 answer 값 갱신
            if(flag && stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}