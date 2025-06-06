import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> queue1 = new ArrayDeque<>();
        for (int i = 0; i < cards1.length; i++) {
            queue1.addLast(cards1[i]);
        }
        
        ArrayDeque<String> queue2 = new ArrayDeque<>();
        for (int i = 0; i < cards2.length; i++) {
            queue2.addLast(cards2[i]);
        }
        
        ArrayDeque<String> goals = new ArrayDeque<>();
        for (int i = 0; i < goal.length; i++) {
            goals.addLast(goal[i]);
        }
        
        ArrayList<String> answer = new ArrayList<>();
        while(!goals.isEmpty()) {
            String word = goals.pollFirst();
            
            if(word.equals(queue1.peek())) { // 같으면 poll
                queue1.pollFirst();
                
            } else if(word.equals(queue2.peek())) {
                queue2.pollFirst();
                
            } else {
                return "No"; // 같은게 없으면 문장을 만들 수 없으므로 No return
            }
        }

        return "Yes";
    }
}