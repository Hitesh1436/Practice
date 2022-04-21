class Solution {
    public int orangesRotting(int[][] grid) {

        if(grid == null || grid.length == 0)
            return 0;

        int numOfMinutes = 0;
        int countFreshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    countFreshOranges++;
                else if (grid[i][j] == 2)
                    queue.offer(new int [] {i,j});
            }
        }

        if(countFreshOranges == 0)
            return 0;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()) {
            int size = queue.size();

            if(countFreshOranges == 0)
                return numOfMinutes;

            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();

                for(int dir[] : dirs) {
                    int newX = point[0] + dir[0];
                    int newY = point[1] + dir[1];

                    if(newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] != 1)
                        continue;

                    grid[newX][newY] = 2;
                    queue.offer(new int[]{newX , newY});
                    countFreshOranges--;
                }
            }
            numOfMinutes++;
        }
        return -1;
    }
}