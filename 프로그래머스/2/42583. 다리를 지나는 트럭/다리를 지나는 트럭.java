import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> wait = new ArrayDeque<>();
        for (int i = 0; i < truck_weights.length; i++) {
            wait.addLast(truck_weights[i]);
        }
        
        // 다리(size가 bridge_length를 넘을 수 없음)
        ArrayDeque<int[]> bridge = new ArrayDeque<>();
        
        int time = 0;
        while (wait.size() != 0 || bridge.size() != 0) {
            // 다리에서 내릴 수 있으면 내리기
            if(!bridge.isEmpty() && bridge.peek()[1] == 1) {
                bridge.pollFirst();
            }
            
            // 다리 위의 차 한 칸씩 이동
            for (int[] truck : bridge) {
                truck[1]--;
            }
            
            // 대기열이 비어있지 않고 다리에 빈 자리가 있으며 남은 무게보다 적게 나가는 경우 다리에 올리기
            int currentWeight = bridge.stream().mapToInt(arr -> arr[0]).sum();
            if(!wait.isEmpty() && bridge.size() < bridge_length && wait.peek() <= weight - currentWeight) {
                bridge.addLast(new int[] {wait.pollFirst(), bridge_length});
            }
            
            time++;
        }

        return time;
    }
}

// 큐 문제들은 순서가 있는듯
// 모든 트럭이 다리를 건너는 최소 시간
// 다리에 완전히 오르지 않은 트럭 무게는 무시
// 1초에 1칸 이동