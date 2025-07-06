import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        // [genre: [id : playTime]]
        LinkedHashMap<String, LinkedHashMap<Integer, Integer>> genreMap = new LinkedHashMap<>();
        for (int i = 0; i < genres.length; i++) {
            
            // 새로운 장르이면 빈 해시맵을 가져오도록 처리
            LinkedHashMap<Integer, Integer> musicMap 
                = genreMap.getOrDefault(genres[i], new LinkedHashMap<>());
            
            musicMap.put(i, plays[i]);
            genreMap.put(genres[i], musicMap);
        }
        
        // 총 playTime순 정렬
        // map1.values().stream().mapToInt(Integer::intValue).sum()
        genreMap = genreMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue((map1, map2) -> Integer.compare(
                map2.values().stream().mapToInt(Integer::intValue).sum(),
                map1.values().stream().mapToInt(Integer::intValue).sum()
            )))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
        
        // 장르별 횟수순 정렬
        genreMap.replaceAll((key, value) -> 
            value.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new
                ))
        );
        
        // 각 장르별 상위 2개의 고유 번호 저장
        ArrayList<Integer> answer = new ArrayList<>();
        genreMap.forEach((genre, music) -> {
            music.entrySet().stream()
                .limit(2)
                .forEach((entry) -> {
                    answer.add(entry.getKey());
                });
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 장르별로 가장 많이 재생된 노래 두개씩
// 속한 노래가 많이 재생된 장르 > 장르 내 많이 재생된 노래(횟수가 같으면 고유번호가 낮은걸 먼저)
// 고유 번호 = 각 배열의 인덱스