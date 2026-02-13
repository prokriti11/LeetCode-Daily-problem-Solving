class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
            int start = i++;
            while (i < n && s.charAt(i) == s.charAt(i - 1)) i++;
            ans = Math.max(ans, i - start);
        }

        ans = Math.max(ans, twoChars(s, n, 'a', 'b'));
        ans = Math.max(ans, twoChars(s, n, 'a', 'c'));
        ans = Math.max(ans, twoChars(s, n, 'b', 'c'));

        HashMap<Long, Integer> pos = new HashMap<>(n * 2 + 1);
        pos.put(key(0, 0), -1);

        int ca = 0, cb = 0, cc = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') ca++;
            else if (ch == 'b') cb++;
            else if (ch == 'c') cc++;

            int d1 = ca - cb;
            int d2 = cb - cc;
            long k = key(d1, d2);

            Integer prev = pos.get(k);
            if (prev != null) ans = Math.max(ans, i - prev);
            else pos.put(k, i);
        }

        return ans;
    }

    private static long key(int d1, int d2) {
        return (((long) d1) << 32) ^ (d2 & 0xffffffffL);
    }

    private static int twoChars(String s, int n, char x, char y) {
        int best = 0;

        int[] first = new int[2 * n + 1];
        Arrays.fill(first, Integer.MAX_VALUE);

        int[] touched = new int[2 * n + 1];
        int touchedSz = 0;

        int i = 0;
        while (i < n) {
            int segStart = i;

            first[n] = segStart - 1;
            touched[touchedSz++] = n;

            int d = 0;
            while (i < n) {
                char ch = s.charAt(i);
                if (ch != x && ch != y) break;

                d += (ch == x) ? 1 : -1;
                int idx = d + n;

                if (first[idx] != Integer.MAX_VALUE) {
                    best = Math.max(best, i - first[idx]);
                } else {
                    first[idx] = i;
                    touched[touchedSz++] = idx;
                }
                i++;
            }

            for (int k = 0; k < touchedSz; k++) first[touched[k]] = Integer.MAX_VALUE;
            touchedSz = 0;

            i++; 
        }

        return best;
    }
};