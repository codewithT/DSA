import java.util.*;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, "", result);
        return result;
    }

    private void backtrack(int n, int open_count, int close_count, String current, List<String> result) {
        // Base case: If we've added n pairs of parentheses, add the current string to the result
        if (open_count == n && close_count == n) {
            result.add(current);
            return;
        }

        // Add an opening parenthesis if we haven't yet added n opening parentheses
        if (open_count < n) {
            backtrack(n, open_count + 1, close_count, current + "(", result);
        }

        // Add a closing parenthesis if it would not exceed the number of opening parentheses
        if (close_count < open_count) {
            backtrack(n, open_count, close_count + 1, current + ")", result);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3;
        List<String> result = sol.generateParenthesis(n);
        System.out.println(result);
    }
}
