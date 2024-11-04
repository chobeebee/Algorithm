class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int[] arr = new int[1001];
        
        for(int i=0; i<array.length; i++){
            arr[array[i]]++;
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                answer = i;
            }else if(arr[i] == max){
                answer = -1;
            }
        }
        
        return answer;
    }
}