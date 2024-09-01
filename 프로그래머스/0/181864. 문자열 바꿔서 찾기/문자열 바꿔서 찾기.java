class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String[] arr = myString.split("");
        String str = "";
        
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("A")){
                arr[i] = "B";
            }else{
                arr[i] = "A";
            }
            
            str+=arr[i];
        }
        
        if(str.contains(pat)){
            answer = 1;
        }
        
        return answer;
    }
}