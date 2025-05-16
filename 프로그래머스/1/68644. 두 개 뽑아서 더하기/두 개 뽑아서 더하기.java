import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> newArr = new ArrayList<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                newArr.add(numbers[i] + numbers[j]);
            }
        }
        
        return newArr.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
    }
}