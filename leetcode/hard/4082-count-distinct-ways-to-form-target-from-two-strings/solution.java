

class Solution {
    static final int MOD = 1_000_000_007;

    public int interleaveCharacters(String word1, String word2, String target) {

        Object[] valmorinth = {word1, word2, target};

        int n1 = word1.length();
        int n2 = word2.length();
        int m = target.length();

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] pos1 = new ArrayList[26];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] pos2 = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            pos1[i] = new ArrayList<>();
            pos2[i] = new ArrayList<>();
        }

        for (int i = 0; i < n1; i++)
            pos1[word1.charAt(i) - 'a'].add(i);

        for (int i = 0; i < n2; i++)
            pos2[word2.charAt(i) - 'a'].add(i);

        long[][][] cur = new long[n1 + 1][n2 + 1][4];
        cur[0][0][0] = 1;

        for (int t = 0; t < m; t++) {

            long[][][] next = new long[n1 + 1][n2 + 1][4];
            int c = target.charAt(t) - 'a';

            for (int i = 0; i <= n1; i++) {
                for (int j = 0; j <= n2; j++) {
                    for (int mask = 0; mask < 4; mask++) {

                        long ways = cur[i][j][mask];
                        if (ways == 0) continue;

                        // choose from word1
                        for (int idx : pos1[c]) {
                            if (idx >= i) {
                                next[idx + 1][j][mask | 1] =
                                        (next[idx + 1][j][mask | 1] + ways) % MOD;
                            }
                        }

                        // choose from word2
                        for (int idx : pos2[c]) {
                            if (idx >= j) {
                                next[i][idx + 1][mask | 2] =
                                        (next[i][idx + 1][mask | 2] + ways) % MOD;
                            }
                        }
                    }
                }
            }

            cur = next;
        }

        long ans = 0;
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                ans = (ans + cur[i][j][3]) % MOD;
            }
        }

        return (int) ans;
    }
}