import java.util.*;

// order doesn't matter give all possible sequences of string 
class Solution {
    public List<String> generateAllSequences(String tiles) {
        List<String> result = new ArrayList<>();
        int[] freq = new int[26]; // Frequency array for characters A-Z
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++; // Count occurrences of each letter
        }
        dfs(freq, "", result); // Start DFS with an empty path
        return result;
    }

    private void dfs(int[] freq, String path, List<String> result) {
        if (!path.isEmpty()) { // Only add non-empty sequences
            result.add(path);
        }

        // Explore each available character
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) { // If the character is available
                freq[i]--; // Choose the character
                dfs(freq, path + (char) ('A' + i), result); // Continue building sequence
                freq[i]++; // Backtrack (restore the character count)
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String tiles = "AAB";
        List<String> sequences = sol.generateAllSequences(tiles);
        System.out.println(sequences); // Output all generated sequences
    }
}
