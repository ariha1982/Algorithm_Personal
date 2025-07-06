import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {        
        // 이름 순서를 지키기 위해 LinkedHashMap 이용
        Map<String, Integer> answerMap = new LinkedHashMap<>();
        for (String id : id_list) {
            answerMap.put(id, 0);
        }
        
        // HashMap을 사용해서 [신고 당한 사람: Set(신고자)] 형태로 저장
        HashMap<String, Set<String>> map = new HashMap<>();
        Set<String> reporters;
        for(String _report : report) {
            String[] reportArr = _report.split(" ");
            String reporter = reportArr[0];
            String reported = reportArr[1];
            
            if (!map.containsKey(reported)) { // 맵에 없으면 새로운 Set 생성
                reporters = new HashSet<>();
                
            } else { // 있으면 가져오기
                reporters = map.get(reported);
                
            }
            reporters.add(reporter);
            map.put(reported, reporters);
        }
        
        // 신고 메일 횟수 정리
        map.forEach((key, val) -> {
            if (val.size() >= k) { // 신고 횟수가 k보다 클 때
                val.forEach(id -> {
                    answerMap.put(id, answerMap.getOrDefault(id, 0) + 1);
                });
            }
        });
        
        // Map에서 횟수만 가져오기
        ArrayList<Integer> answer = new ArrayList<>();
        answerMap.forEach((key, val) -> {
           answer.add((int) val); 
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 한 번에 한 명 신고(동일 유저 신고는 1회로 처리)
// k번 이상 신고 -> 게시판 이용 정지 -> 신고한 사람들한테 알림
// 결과는 각 사용자가 받은 알림 수 