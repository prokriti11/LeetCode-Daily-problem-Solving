class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxDifference(String s, int k) 
    {
        
        int len = s.length();

        for(int i=0; i<len;i++)
        {
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=i;j<len;j++)
            {
                int num = (int)(s.charAt(j)-'0');
                map.put(num,map.getOrDefault(num,0)+1);
                if(j-i>=k-1) checkMax(map);
            }
        }
        return ans;
        
    }
    private void checkMax(Map<Integer,Integer> map)
    {
        
        if (map == null || map.size() < 2) {
            return ;
        }

        Integer minEven = null;
        Integer maxOdd = null;

        for (int value : map.values()) {
            if (value % 2 == 0) {
                if (minEven == null || value < minEven) minEven = value;
            } else {
                if (maxOdd == null || value > maxOdd) maxOdd = value;
            }
        }

        if (minEven == null || maxOdd == null) {
            return ; 
        }

        
        int maxDiff = (maxOdd - minEven);
        
        // System.out.println(map);
        // System.out.println(minEven+"  "+maxOdd);
        // System.out.println(maxDiff);
        
        // if(Math.abs(ans) < Math.abs(maxDiff)) 
        if((ans) < (maxDiff) && maxDiff != 0) 
        {
            // System.out.println("MAXDIFF===" + maxDiff);
            ans = maxDiff;
        }

        return ;
    }
}