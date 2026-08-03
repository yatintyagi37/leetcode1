class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int pushes = 0;
        int cost = 1;

        // Process frequencies from highest to lowest
        for (int i = 25, used = 0; i >= 0; i--) {
            if (freq[i] == 0) break;

            pushes += freq[i] * cost;
            used++;

            if (used % 8 == 0) {
                cost++;
            }
        }

        return pushes;
    }
}