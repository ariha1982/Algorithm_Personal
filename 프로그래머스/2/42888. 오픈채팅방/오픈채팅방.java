import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Solution {
    public ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        Map<String, String> nicknames = new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] temp = record[i].split(" ");
            if(!temp[0].equals("Leave")) {
                nicknames.put(temp[1], temp[2]);
            }
        }
        
        for(int i=0; i<record.length; i++){
            String[] temp = record[i].split(" ");
            String nickname = nicknames.get(temp[1]);
            
            if(temp[0].equals("Enter")) {
                answer.add(String.format("%s님이 들어왔습니다.", nickname));
            } else if (temp[0].equals("Leave")) {
                answer.add(String.format("%s님이 나갔습니다.", nickname));
            }
        }
        
        return answer;
    }
}