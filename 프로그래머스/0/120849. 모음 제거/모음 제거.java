class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] mo = {'a','e','i','o','u'};
        boolean flag = false;
        
        for(int i=0; i<my_string.length(); i++){
            for(int m : mo){
                if(m == my_string.charAt(i)){
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                answer+=my_string.charAt(i);
            }else{
                flag = false;
            }
        }
        
        return answer;
    }
}