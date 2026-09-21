class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] a, int target) {
        solve(a, target, 0, new ArrayList<>());
        return ans;
    }

    void solve(int[] a, int target, int i, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (i == a.length || target < 0) return;

        list.add(a[i]);
        solve(a, target - a[i], i, list);
        list.remove(list.size() - 1);
        solve(a, target, i + 1, list);
    }
}