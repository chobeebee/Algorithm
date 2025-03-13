class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ", -1);
        
        for (int i = 0; i < arr.length; i++) {
            
            String a = arr[i];
            
            for(int j = 0; j < a.length(); j++){
                
                if(j % 2 == 0){
                    answer += Character.toUpperCase(a.charAt(j));
                }else{
                    answer += Character.toLowerCase(a.charAt(j));
                }
            }
            
            if (i < arr.length- 1) {
                answer += " ";
            }
        }
        
        return answer;
    }
}