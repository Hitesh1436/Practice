// 1. Recursion
// Time complexity: O(2^N)
// Space complexity: O(N)

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         // start from the top of the triangle
//         return recurse(triangle, 0, 0);
//     }
    
//     private int recurse(List<List<Integer>> triangle, int row, int col) {
//         // base case
//         if (row == triangle.size())
//             return 0;
        
//         // either go to [row + 1, col] or [row + 1, col + 1]
//         int remain = Math.min(recurse(triangle, row + 1, col),
//                               recurse(triangle, row + 1, col + 1));
        
//         // combine answer with current value
//         return triangle.get(row).get(col) + remain;
//     }
// }

// 2. Memoization
// Time complexity: O(N^2)
// Space complexity: O(N^2)

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         // create dp table
//         int[][] memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
//         for (int[] row: memo)
//             Arrays.fill(row, Integer.MAX_VALUE);
        
//         // start from the top of the triangle
//         return recurse(triangle, 0, 0, memo);
//     }
    
//     private int recurse(List<List<Integer>> triangle, int row, int col, int[][] memo) {
//         // base case
//         if (row == triangle.size())
//             return 0;
        
//         // check dp table
//         if (memo[row][col] != Integer.MAX_VALUE)
//             return memo[row][col];
        
//         // either go to [row + 1, col] or [row + 1, col + 1]
//         int remain = Math.min(recurse(triangle, row + 1, col, memo),
//                               recurse(triangle, row + 1, col + 1, memo));
        
//         // combine answer with current value
//         memo[row][col] = triangle.get(row).get(col) + remain;
//         return memo[row][col];
//     }
// }


// 3. Tabulation
// Time complexity: O(N^2)
// Space complexity: O(N^2)

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         // create dp table by copying the input triangle
//         List<List<Integer>> table = new ArrayList<>();
//         for (List<Integer> row: triangle) 
//             table.add(new ArrayList<>(row));
        
//         // iterate over the entire triangle from bottom to top
//         for (int row = triangle.size() - 2; row >= 0; row--) {
//             for (int col = 0; col < triangle.get(row).size(); col++) {
//                 // either go to [row + 1, col] or [row + 1, col + 1]
//                 int remain = Math.min(table.get(row + 1).get(col),
//                                       table.get(row + 1).get(col + 1));
                
//                 // combine answer with current value
//                 table.get(row).set(col, triangle.get(row).get(col) + remain);
//             }
//         }
        
//         // return answer for the top of the triangle
//         return table.get(0).get(0);
//     }
// }

// 4. Tabulation With Optimized Space
// Time complexity: O(N^2)
// Space complexity: O(N)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // create dp table with size of the largest column (which is number of rows)
        int[] table = new int[triangle.size() + 1];
        Arrays.fill(table, 0);
                
        // iterate over the entire triangle from bottom to top
        for (int row = triangle.size() - 1; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // either go to [row + 1, col] or [row + 1, col + 1]
                int remain = Math.min(table[col],
                                      table[col + 1]);
                
                // combine answer with current value
                table[col] = triangle.get(row).get(col) + remain;
            }
        }
        
        return table[0];
    }
}

