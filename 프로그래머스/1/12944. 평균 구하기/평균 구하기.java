class Solution {
    public double solution(int[] arr) {

        int sum = 0;
        
        for(int a : arr){
            sum += a;
        }
        
        return (double)sum/arr.length;
    }
}