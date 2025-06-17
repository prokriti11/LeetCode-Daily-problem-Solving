class Solution {
    int mod = 1000000007;
        static long[] revs = new long[10001];
        static int[] f= new int[10001];

        public int countGoodArrays(int n, int m, int k){
            if(f[0] == 0)
            f[0] = 1;

            long res = m*pow(m-1, n-k-1)%mod*C(n-1, n-1-k)%mod;
            return (int) res;
        }
        public long pow(int a, int b){
            long res= 1;
            long base = a;
            while(b>0){
                res = res*base%mod;
            base = base *base%mod;
            b /= 2;
            }
            return res;
        }
        public long C(int a, int b){
            return (long) getF(a) * rev(getF(a-b)) % mod * rev(getF(b))%mod;
        }
        public long getF(int a){
            if(f[a] != 0)
                return f[a];
            return f[a] = (int)(getF(a-1)* a % mod);
        
        }
        public long rev(long a){
            if(a == 1)
            return a;
            return mod - mod/a*rev(mod%a)%mod;
        }
    }
