/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// class Solution {
    
//     int camera = 0;
//     public int minCameraCover(TreeNode root) {
//         if(getCamera(root)==-1)  //if camera is required at root
//             camera++;
//         return camera;
//     }
    
    
//     // return value of -1 means i need a camera.
//     // return value of 1 means i am a camera.
//     // return value of 0 means i am been looked by a camera.
//     public int getCamera(TreeNode root)  
//     {
//         if(root == null)
//             return 0;
//         int left = getCamera(root.left);
//         int right = getCamera(root.right);
//         if(left==0 && right == 0) 
//             return -1;
//         if(left == -1 || right == -1)
//         {
//             camera++;
//             return 1;
//         }
//         return 0;
//     }
// }
class Solution {
     int count=0;
    // return value of -1 means i need a camera.
    // return value of 0 means i am a camera.
    // return value of 1 means i am been looked by a camera.
    
    public int countOfCameras(TreeNode root){
        if(root == null){
            return 1;
        }
        // PostOrder mn krenge
        int left = countOfCameras(root.left);
        int right = countOfCameras(root.right);
        
        if(left==-1 || right==-1){
            count++;
            return 0;
        }
        if(left == 0 || right == 0){
            return 1;
        }
        return -1;
    }
    
    public int minCameraCover(TreeNode root) {
        if(countOfCameras(root)==-1){
            count++;
        }
        return count;
    }
}