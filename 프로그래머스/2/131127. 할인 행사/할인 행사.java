import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // want와 number를 합치기
        Map<String, Integer> wishList = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wishList.put(want[i], number[i]);
        }
        
        // 슬라이딩 윈도우 방식으로 조건을 만족하면 answer +1
        int answer = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> map = new HashMap<>();
            for(int j =i + 0; j < i + 10; j++){
                String item = discount[j];
                map.put(item, map.getOrDefault(item, 0) + 1);
            }
            
            if (validation(map, wishList)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 아이템 포함 여부, 개수 일치 여부 확인
    private boolean validation (Map<String, Integer> sale, Map<String, Integer> wish) {
        for(Map.Entry<String, Integer> entry : wish.entrySet()) {
            String item = entry.getKey();
            Integer num = entry.getValue();
            
            if (!sale.containsKey(item)) {
                return false;
            }
            
            if (!num.equals(sale.get(item))) {
                return false;
            }
        }
        
        return true;
    }
}