class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int n = s.length();
        int i = 0;
        int ans = 0;

        HashMap<Character, Integer> charMap = new HashMap<>();
        HashMap<String, Integer> subMap = new HashMap<>();

        for (int right = 0; right < n; right++) {

            // add right character
            char ch = s.charAt(right);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);

            // keep window size = minSize
            if (right - i + 1 > minSize) {
                char left = s.charAt(i);
                charMap.put(left, charMap.get(left) - 1);
                if (charMap.get(left) == 0) {
                    charMap.remove(left);
                }
                i++;
            }

            // valid window
            if (right - i + 1 == minSize && charMap.size() <= maxLetters) {
                String sub = s.substring(i, right + 1);
                subMap.put(sub, subMap.getOrDefault(sub, 0) + 1);
                ans = Math.max(ans, subMap.get(sub));
            }
        }
        return ans;
    }
}
