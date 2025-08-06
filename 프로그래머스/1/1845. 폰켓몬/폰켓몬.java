import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 뽑아야 할 폰켓몬 수
        int num = nums.length / 2;
        
        // 중복 제거
        int[] unique = Arrays.stream(nums).distinct().toArray();

        return num >= unique.length ? unique.length : num;
    }
}