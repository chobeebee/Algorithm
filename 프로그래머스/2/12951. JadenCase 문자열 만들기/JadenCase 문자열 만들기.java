class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ", -1);
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isEmpty()) {
                sb.append("");
            } else {
                String word = arr[i].toLowerCase();
                String first = word.substring(0, 1).toUpperCase();
                String rest = word.length() > 1 ? word.substring(1) : "";
                sb.append(first).append(rest);
            }
            
            if (i != arr.length - 1) sb.append(" ");
        }
        
        return sb.toString();
    }
}