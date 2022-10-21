class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        return isHappyHelper(n, set);
    }

    private boolean isHappyHelper(int n, Set<Integer> set) {
        if (n == 1) {
            return true;
        }
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        if (set.contains(sum)) {
            return false;
        }
        set.add(sum);
        return isHappyHelper(sum, set);
    }
}