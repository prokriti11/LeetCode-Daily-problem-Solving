class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Map<Integer, Integer> map = new HashMap<>();
        int startTime[] = new int[n];
        for(int i=0; i<n; ++i) {
            startTime[i] = intervals[i][0];
            map.put(intervals[i][0], i);
        }
        Arrays.sort(startTime);

        int res[] = new int[n];
        for(int i=0; i<n; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int si = 0, ei = n - 1;
            int index = -1;
            while(si <= ei) {
                int mid = si + (ei - si) / 2;
                if(startTime[mid] >= end) {
                    index = mid;
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }

            res[i] = index == -1 ? -1 : map.get(startTime[index]);
        }

        return res;
    }
}