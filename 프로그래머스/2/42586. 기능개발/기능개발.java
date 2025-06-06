import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 순서와 남은 진도를 덱에 add
        ArrayDeque<int[]> remains = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) {
            int[] remain = {i, 100 - progresses[i]};
            remains.addLast(remain);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        while (!remains.isEmpty()) {
            // 일단 한 바퀴 돌리기
            for (int i = 0; i < remains.size(); i++) {
                int[] remain = remains.pollFirst();
                remain[1] -= speeds[remain[0]];
                remains.addLast(remain);
            }
            
            int count = 0; // 배포되는 기능의 개수
            int repeat = remains.size(); // 현재 남은 기능 개수 (for문 안의 poll에 영향받지 않도록)
            int current1st = remains.peek()[0]; // 지금 1순위로 배포되어야하는 기능의 idx
            boolean flag = false; // answer 추가 flag
            
            for (int i = 0; i < repeat; i++) {
                int[] remain = remains.pollFirst();
                // 현재 배포되어야 하는 순서이며 0보다 작음
                if(remain[0] == current1st && remain[1] <= 0) {
                    count++;
                    current1st++;
                    flag = true;
                    
                } else {
                    remains.addLast(remain); // 해당 없으면 그대로 뒤에 추가
                }
            }
            
            if(flag)
                answer.add(count);
        }
        
        // ArrayList<Integer> -> Array<int>
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 진도가 100% 일때 서비스에 반영 가능
// 기능의 개발속도는 서로 다르지만 배포는 앞에 기능이 배포될때 같이 됨
// 각 배포마다 몇 개의 기능이 배포되는가?

// 배포는 하루 1번만 가능