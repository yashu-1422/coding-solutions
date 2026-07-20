class Solution {
    public String reverseWords(String s) {

        List<String> list = new ArrayList<>();

        int i = 0;
        int n = s.length();

        while (i < n) {

            while (i < n && s.charAt(i) == ' '){
                i++;
            }
            if (i == n)
                break;

            int start = i;

            while (i < n && s.charAt(i) != ' '){
                i++;
            }
            list.add(s.substring(start, i));
        }

        StringBuilder ans = new StringBuilder();

        for (int j = list.size() - 1; j >= 0; j--) {

            ans.append(list.get(j));

            if (j != 0)
                ans.append(" ");
        }

        return ans.toString();
    }
}