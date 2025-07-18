import java.util.*;

class Solution {
    public LinkedHashMap<String, String> map = new LinkedHashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 인접 리스트 생성(자식 : 부모)
        for(int i = 0; i < referral.length; i++) {
            map.put(enroll[i], referral[i]);
        }
        
        // 사람별로 수익 정리
        for(int i = 0; i < seller.length; i++) {
            getProfit(seller[i], amount[i] * 100);
        }
        
        // 답 정리
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            answer[i] = profitMap.getOrDefault(name, 0);
        }

        return answer;
    }
    
    // brushProfit: 칫솔 판매 수익
    public HashMap<String, Integer> profitMap = new HashMap<>();
    private void getProfit(String seller, int brushProfit) {
        int profit_1 = brushProfit * 1 / 10;
        int profit_9 = brushProfit - profit_1;
        
        if (profit_1 < 1) { // 10%가 1원 미만이면 분배X
            profitMap.put(seller, profitMap.getOrDefault(seller, 0) + brushProfit);
            
        } else {
            profitMap.put(seller, profitMap.getOrDefault(seller, 0) + profit_9);
            
            if(!map.get(seller).equals("-")) { // 부모가 따로 있을 경우
                getProfit(map.get(seller), profit_1);
            }
        }
    }
}

//나의 이익: 나의 판매 이익 + 내가 추천한 판매원의 이익의 10%
//10%의 금액이 1원 미만이면 분배하지 않고 자신이 가짐
//칫솔은 무조건 100원