class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        char[] arr = s.toCharArray();
        
        for(char a : arr){
            if(a == ' '){
                sb.append(a);
            }else{
                char alpha = Character.isLowerCase(a) ? 'a' : 'A';
                sb.append((char) ((a - alpha + n) % 26 + alpha));
            }
        }
        
        return sb.toString();
    }
}