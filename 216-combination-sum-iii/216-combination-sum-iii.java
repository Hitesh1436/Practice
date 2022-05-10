class Solution {
   public List<List<Integer>> combinationSum3(int k, int n) {
  if (k == 0 || n == 0) {
    return new ArrayList<>();
  }
  List<List<Integer>> result = new ArrayList<>();
  backtracking(1, k, n, new ArrayList<>(), result);
  return result;
}

private void backtracking(int num, int k, int n, List<Integer> sol, List<List<Integer>> result) {
  // reject & accept
  if (sol.size() == k) {
    if (n == 0) {
      result.add(new ArrayList<>(sol));
    }
    return;
  }
  
  for (int i = num; i <= 9; ++i) { // for number 1 ~ 9
    int nextTarget = n - i;
    if (nextTarget < 0) { // consider this line (can we put it into the base case?)
      break;
    }
    sol.add(i);
    backtracking(i + 1, k, nextTarget, sol, result);
    sol.remove(sol.size() - 1); // restore
  }
 }
}
