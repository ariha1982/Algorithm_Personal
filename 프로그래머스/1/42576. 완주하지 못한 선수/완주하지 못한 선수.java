import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> isComplete = new HashMap<>();
        
        for (String person : participant) {
            // 있으면 +1, 없으면 그냥 추가
            if (isComplete.containsKey(person)) {
                Integer personNum = isComplete.get(person);
                isComplete.put(person, personNum + 1);
                
            } else {
                isComplete.put(person, 1);
            }
        }
        
        for (String person : completion) {
            Integer personNum = isComplete.get(person);
            
            if (personNum == 1) {
                isComplete.remove(person);
                
            } else {
                isComplete.put(person, personNum - 1);
            }
        }
        
        // System.out.println(new String(isComplete.keySet().stream().iterator().next()));
        
        String answer = new String(isComplete.keySet().stream().iterator().next());
        return answer;
    }
}