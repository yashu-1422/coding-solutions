class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256], m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            // Return false if mapping is inconsistent
            if (m1[s.charAt(i)] != m2[t.charAt(i)])
                return false;

            // Update last seen index for both characters
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }

        // Return true if all character mappings are consistent
        return true;
    }
}
