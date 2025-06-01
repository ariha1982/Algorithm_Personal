import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n + 2];
        int[] after = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            prev[i] = i - 1; //[-1, 0, 1, 2, 3, 4, 5, 6, 7, 8]
            after[i] = i + 1; //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        }
        
        int current = k + 1;
        
        Stack<Integer> deleted = new Stack<>();
        for(String c : cmd) {
            if (c.equals("C")) {
                deleted.push(current);
                prev[after[current]] = prev[current];
                after[prev[current]] = after[current];
                
                current = n < after[current] ? prev[current] : after[current];
                
            } else if (c.equals("Z")) {
                int restore = deleted.pop();
                prev[after[restore]] = restore;
                after[prev[restore]] = restore;
                
            } else {
                String[] split = c.split(" ");
                int movement = Integer.parseInt(split[1]);
                
                for(int i = 0; i < movement; i++) {
                    current = split[0].equals("U") ? prev[current] : after[current];
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for (int i : deleted) {
            answer[i - 1] = 'X';
        }
        
        return new String(answer);
    }
}

// 명령어 기반으로 표의 행을 선택, 삭제, 복구
// 처음 표 기준 삭제 여부 return(삭제 안됨: O, 삭제됨: X)

// U X - X는 숫자, 현재 선택 행에서 X칸 위의 행 선택
// D X - X는 숫자, 현재 선택 행에서 X칸 아래의 행 선택
// C - 1. 현재 선택 행 삭제 2. 아래 행 선택(맨 마지막이면 위)
// Z - 가장 최근에 삭제된 행 복구(현재 선택된 행은 바뀌지 않음)