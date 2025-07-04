import java.util.*;

class Solution {
    // [코스 수 : [코스 : 주문 횟수]]
    private Map<Integer, HashMap<String, Integer>> courseMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        // 코스 수 세팅
        for (int courseNum : course) {
            courseMap.put(courseNum, new HashMap<>());
        }
        
        // 문자열을 오름차순으로 정렬(AB, BA를 동일하게 취급하기 위해)
        for(int i = 0; i < orders.length; i++) {
            char[] orderArr = orders[i].toCharArray();
            Arrays.sort(orderArr);
            
            // 2. 조합 생성 -> 해시맵 기록
            combination(0, orderArr, "");
        }
        
        ArrayList<String> answer = new ArrayList<>();
        for(HashMap<String, Integer> map : courseMap.values()) {
            map.values().stream().max(Comparator.comparingInt(o -> o))
                .ifPresent(num -> 
                           map.entrySet().stream()
                           .filter(it -> it.getValue().equals(num) && num > 1)
                           .forEach(it -> answer.add(it.getKey())));
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    
    // 조합 생성 재귀 함수
    private void combination(int idx, char[] order, String result) {
        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> temp = courseMap.get(result.length());
            temp.put(result, temp.getOrDefault(result, 0) + 1);
        }
        
        for (int i = idx; i < order.length; i++) {
            combination(i+1, order, result + order[i]);
        }
    }
}