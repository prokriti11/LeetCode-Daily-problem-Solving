public int bestClosingTime(String s) {
    int n = s.length(), best = Integer.MAX_VALUE, ans = 0;
    for (int j = 0; j <= n; j++) {
        int pen = 0;
        for (int i = 0; i < j; i++) if (s.charAt(i) == 'N') pen++;
        for (int i = j; i < n; i++) if (s.charAt(i) == 'Y') pen++;
        if (pen < best) { best = pen; ans = j; }
    }
    return ans;
}