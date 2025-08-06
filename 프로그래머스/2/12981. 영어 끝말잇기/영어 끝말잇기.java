import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        // 마지막 문자
        char last = 0;
        // 이미 나온 단어
        ArrayList<String> cameOutWords = new ArrayList<>();
        // 걸린 사람 idx
        int breakIdx = -1;
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            // 1. 중복 확인
            // 중복 발생
            if (!cameOutWords.isEmpty() && cameOutWords.contains(word)) {
                breakIdx = i;
                break;
            }
            // 중복 X
            cameOutWords.add(word);
            
            // 2. 끝말 확인
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length() - 1);
            // 전 단어 끝 문자 != 현 단어 첫 문자
            if (last != 0 && last != firstChar) {
                breakIdx = i;
                break;
            }
            // 전 단어 끝 문자 == 현 단어 첫 문자
            last = lastChar;
        }
        
        int[] answer = {0, 0};
        if (breakIdx != -1) {
            answer[0] = (breakIdx % n) + 1;
            answer[1] = (breakIdx / n) + 1;
            
        }
        return answer;
    }
}

// 중복, 끝말잇기 틀림 -> 탈락
// 가장 먼저 탈락하는 사람의 번호와 탈락 순서
// 아무도 탈락하지 않으면 [0, 0]
// n: 사람 수