class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        ArrayList<Character> lis = new ArrayList<>();
        lis.add('1');
        lis.add('0');
        lis.add('2');
        lis.add('3');
        lis.add('4');
        lis.add('5');
        lis.add('6');
        lis.add('7');
        lis.add('8');
        lis.add('9');
        for (int i = 0; i < s.length(); i++) {
            if (lis.contains(s.charAt(i))) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        // cb3hs5
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();

    }
}