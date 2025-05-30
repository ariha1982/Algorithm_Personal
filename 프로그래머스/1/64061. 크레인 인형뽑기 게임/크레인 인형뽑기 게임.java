import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 책 힌트: board를 열 기준 스택으로 이루어진 배열로 변경
        Stack<Integer>[] dolls = new Stack[board.length];
        for(int i = 0; i < dolls.length; i++) {
            dolls[i] = new Stack<>();
        }
        
        // 열 기준으로 dolls 채우기
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] != 0) {
                    dolls[j].push(board[i][j]);
                }
            }
        }
        
        int count = 0;
        Stack<Integer> picked = new Stack<>(); // 뽑은 인형을 담는 바구니
        for (int i = 0; i < moves.length; i++) {
            int dollIdx = moves[i] - 1; // moves 값은 1부터 시작하므로 -1 처리
            
            // dolls의 특정 인덱스가 비어있다 == 인형이 없다 -> 아무 일도 안 생기고 다음으로
            if (dolls[dollIdx].isEmpty()) {
                continue;
            } else {
                int doll = dolls[dollIdx].pop();
                
                // 바구니가 비어있지 않고 가장 최근에 뽑은 인형과 지금 뽑은 인형이 같음
                if (!picked.isEmpty() && picked.peek() == doll) {
                    picked.pop();
                    count += 2;
                } else {
                    picked.push(doll);
                }
            }
        }
        
        return count;
    }
}

// 같은 모양 애니팡
// 없는 곳 집으면 아무 일도 없음
// 터트려져 사라진 인형 개수