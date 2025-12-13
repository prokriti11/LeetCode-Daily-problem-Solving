class Solution {
    Map<String,Integer> bus_hash=new HashMap<>();
    Set<Character>cod_hash=new HashSet<>();
    Map<Integer,String>cod_bus=new HashMap<>();
    boolean[] act;
    String[] code;
    private boolean check(String a){
        int n=a.length();
        if(n==0) return false;
        for(int i=0;i<n;i++){
            if(!cod_hash.contains(a.charAt(i))) return false;
        }
        return true;
    }
    private int func(int a,int b){
        //System.out.println(a+" "+cod_bus.get(a)+" "+b+" "+cod_bus.get(b));
        int cond=bus_hash.get(cod_bus.get(a))-bus_hash.get(cod_bus.get(b));
        if(cond==0){
            return code[a].compareTo(code[b]);
        }
        return cond;
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        act=isActive;
        this.code=code;
        bus_hash.put("electronics",1);bus_hash.put("grocery",2);
        bus_hash.put("pharmacy",3);bus_hash.put("restaurant",4);
        for(int i=0;i<26;i++){
            cod_hash.add((char)(i+'a'));
            cod_hash.add((char)(i+'A'));
            if(i<10)cod_hash.add((char)(i+'0'));
        }
        cod_hash.add('_');
        List<Integer> ans=new ArrayList<>();
        int n=code.length;
        for(int i=0;i<n;i++){
            if(!isActive[i]) continue;
            if(!check(code[i])) continue;
            if(!bus_hash.containsKey(businessLine[i])) continue;
            ans.add(i);
            cod_bus.put(i,businessLine[i]);
        }
        Collections.sort(ans,(a,b) -> func(a,b));
        //System.out.println(ans);
        List<String> ans2=new ArrayList<>();
        for(var i: ans){
            ans2.add(code[i]);
        }
        return ans2;
    }
}