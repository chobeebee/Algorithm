import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replace("b","a");
        myStr = myStr.replace("c","a");
        
        String[] answer = myStr.split("a");
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<answer.length; i++){
            if(!answer[i].isEmpty()){
                list.add(answer[i]);
            }
        }
        
        if(list.size()==0){
            list.add("EMPTY");
        }
        
        return list.stream().toArray(String[]::new);
    }
}