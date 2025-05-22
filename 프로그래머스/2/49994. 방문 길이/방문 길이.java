import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        
        // 중복 제거를 위한 HashSet
        HashSet<List<Integer>> moves = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            int[] move = CmdToInt(dirs.charAt(i));
            
            // x: 출발 x좌표, y: 출발 y좌표 
            // to_x: 도착 x좌표, to_y: 도착 y좌표
            int to_x = x + move[0];
            int to_y = y + move[1];
            
            // 도착 좌표가 좌표평면을 벗어나는지 확인
            if ((to_x <= 5 && to_x >= -5) && (to_y <= 5 && to_y >= -5)) {
                
                // 정렬을 위해 도착 좌표가 출발 좌표보다 왼쪽 또는 하단에 있을 경우 출발좌표 <-> 도착 좌표
                if((to_x < x) || (to_x == x && to_y < y)) {
                    moves.add(Arrays.asList(new Integer[] {to_x, to_y, x, y}));
                } else {
                    moves.add(Arrays.asList(new Integer[] {x, y, to_x, to_y}));   
                }
                
                // x, y값 갱신
                x = to_x;
                y = to_y;
            }
        }
        
        return moves.size();
    }
    
    // 각 문자열을 벡터로 변환
    private int[] CmdToInt(char cmd) {
        int[] intVal = new int[2];
        
        if (cmd == 'L') {
            intVal[0] = -1;
            intVal[1] = 0;
            
        } else if (cmd == 'R') {
            intVal[0] = 1;
            intVal[1] = 0;
            
        } else if (cmd == 'U') {
            intVal[0] = 0;
            intVal[1] = 1;
            
        } else if (cmd == 'D') {
            intVal[0] = 0;
            intVal[1] = -1;
        }
        
        return intVal;
    }
    
}

// (0,0) -> (0,1)과 (0,1) -> (0,0)은 동일

// L : (-1, 0)
// R : (+1, 0)
// U : (0, +1)
// D : (0, -1)