class Solution {
    public int maxNumberOfBalloons(String s) {
        Map<Character,Integer>map=new HashMap<>();
        String ba="balon";
        int min=Integer.MAX_VALUE;
        for(char c:s.toCharArray()){
            if(ba.indexOf(c)!=-1){
                map.put(c,map.getOrDefault(c,0)+1);
                int val=map.get(c);
            }
        }
        if(map.size()<ba.length())return 0;
        int count=0;
        for(char c:ba.toCharArray()){
            if(c=='b'||c=='a'||c=='n'){
                min=Math.min(min,map.get(c));
            }
            else{
                min=Math.min(min,map.get(c)/2);
            }
        }
        return min;
    }
}