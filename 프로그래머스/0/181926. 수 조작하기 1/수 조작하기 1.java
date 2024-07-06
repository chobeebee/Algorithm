class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        String[] str = control.split("");
        
        for(int i=0; i<str.length; i++){
            if(str[i].equals("w")){
                n+=1;
            }else if(str[i].equals("s")){
                n-=1;
            }else if(str[i].equals("d")){
                n+=10;
            }else if(str[i].equals("a")){
                n-=10;
            }
        }
        
        answer = n;
        
        return answer;
    }
}