import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        char[] arr = my_string.toCharArray();
        
        for(char a : arr){
            if('0'<=a && a<='9'){
                list.add(a - '0');
            }
        }
        
        Collections.sort(list);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}