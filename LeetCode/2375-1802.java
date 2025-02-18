import java.util.*;

class Solution {
    public String smallestNumber(String pattern) {
        List<String> result = new ArrayList<>();
        boolean[] vis = new boolean[10];
        backtrack(pattern, 0, "", vis, result);
        return result.get(0);
    }

    private void backtrack(String pattern, int index, String psf, boolean[] vis, List<String> result) {
        if (psf.length() == pattern.length() + 1) {
            result.add(psf);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!vis[i]) {
                if (index == 0 ||
                    (pattern.charAt(index - 1) == 'I' && (psf.charAt(psf.length() - 1) - '0' < i))
                    || (pattern.charAt(index - 1) == 'D' && (psf.charAt(psf.length() - 1) - '0' > i))) {
                    vis[i] = true;
                    backtrack(pattern, index + 1, psf + i, vis, result);
                    vis[i] = false;
                }
            }
        }
    }

}
