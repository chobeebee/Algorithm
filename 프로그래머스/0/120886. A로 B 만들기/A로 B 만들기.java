import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        char[] beforeArr = before.toCharArray();
        char[] afterArr = after.toCharArray();
        
        Arrays.sort(beforeArr);
        Arrays.sort(afterArr);
        
        return Arrays.equals(beforeArr, afterArr) ? 1 : 0;
    }
}