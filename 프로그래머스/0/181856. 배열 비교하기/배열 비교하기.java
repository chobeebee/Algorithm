class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        int arr1Size = arr1.length;
        int arr2Size = arr2.length;
        
        if(arr1Size < arr2Size){
            answer = -1;
        }else if(arr1Size > arr2Size){
            answer = 1;
        }else{
            int arr1Sum=0;
            int arr2Sum=0;
            
            for(int i =0; i<arr1.length; i++){
                arr1Sum+=arr1[i];
                arr2Sum+=arr2[i];
            }
            if(arr1Sum < arr2Sum){
                answer = -1;
            }else if(arr1Sum > arr2Sum){
                answer = 1;
            }else{
                answer = 0;
            }
        }
        
        return answer;
    }
}