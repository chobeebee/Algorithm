class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        
        String str = Integer.toString(num);
        String[] arr = str.split("");
        
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals(Integer.toString(k))){
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
}