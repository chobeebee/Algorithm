class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] strArr = my_string.replaceAll("[a-zA-Z]", " ").split(" ");
        
        for(String str : strArr){
            if(!str.isEmpty()){
                answer += Integer.parseInt(str);
            }            
        }
        
        return answer;
    }
}