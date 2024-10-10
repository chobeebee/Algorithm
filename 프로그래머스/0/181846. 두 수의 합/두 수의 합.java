import java.math.*;

class Solution {
    public String solution(String a, String b) {        
        BigInteger tmp = new BigInteger(a);
        BigInteger tmp2 = new BigInteger(b);
        BigInteger sum = tmp.add(tmp2);
        
        return sum.toString();
    }
}