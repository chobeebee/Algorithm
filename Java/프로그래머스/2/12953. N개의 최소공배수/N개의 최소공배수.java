class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        
        for(int i=0; i<arr.length; i++){
            int a = lcm;
            int b = arr[i];
            
            // 최대 공약수
            while(b != 0){
                int tmp = b;
                b = a % b;
                a = tmp;
            }
            
            int gcd = a;
            lcm = (lcm * arr[i])/gcd; // 최소공배수
            
        }
        
        return lcm;
    }
}