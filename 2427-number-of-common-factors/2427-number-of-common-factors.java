class Solution {
    public int gcd(int a, int b){
        while(b>0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
    public int commonFactors(int a, int b) {
        int cnt = 0;
        for(int i=1; i<=gcd(a,b); i++){
            if(a%i==0 && b%i==0)
                cnt++;
        }
        return cnt;
    }
}