class Solution {
    public int solution(int i, int j, int k) {

        String str = "";
        
        for(int start = i; start <= j; start++){
            str += String.valueOf(start);
        }
        
        String remove = str.replaceAll(String.valueOf(k),"");
        int answer = str.length() - remove.length();
        
        return answer;
    }
}