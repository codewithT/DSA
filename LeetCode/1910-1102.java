class Solution {
    public String removeOccurrences(String s, String part) {
        if(s.length() == 0){
            return "";
        }
        boolean ch = false;
        for(int i =0;i<s.length()-part.length()+1;i++){
            String check = s.substring(i, i+ part.length());
            if(check.equals(part)){
                String left = s.substring(0, i);
                String right =s.substring(i+part.length());
                return removeOccurrences(left + right, part);
            }
        }
        return s;
         
    }
}