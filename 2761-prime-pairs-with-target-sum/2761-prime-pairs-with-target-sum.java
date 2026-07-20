class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i)
                    prime[j] = false;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
            if (prime[i] && prime[n - i])
                ans.add(Arrays.asList(i, n - i));
        }

        return ans;
    }
}