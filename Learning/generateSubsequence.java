import java.util.*;

// sequence matters, only single direction sequence is allowed.

class generateSubsequence {
    public List<String> generateAllSequences(String str) {
        List<String> result = new ArrayList<>();
        dfs(str, 0, "", result); // Start DFS with an empty path
        return result;
    }

    private void dfs(String str, int index, String path, List<String> result) {
        if (index == str.length()) {
            if (!path.isEmpty()) { // Only add non-empty sequences
                result.add(path);
            }
            return;
        }

        // Exclude current character
        dfs(str, index + 1, path, result);

        // Include current character
        dfs(str, index + 1, path + str.charAt(index), result);
    }

    public static void main(String[] args) {
        generateSubsequence sol = new generateSubsequence();
        String str = "ABC";
        List<String> sequences = sol.generateAllSequences(str);
        System.out.println(sequences); // Output all generated sequences
    }
}
