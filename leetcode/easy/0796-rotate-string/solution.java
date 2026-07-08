class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        // Try all possible rotations of s
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal)) {
                // Return true if a match is found
                return true;  
            }
        }

        return false;
    }
}
    
