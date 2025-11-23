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
class Solution {

    int preIndex  = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,inorder.length-1);
    }

    public TreeNode build(int preorder[], int inorder[], int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = find(inorder,inStart,inEnd,rootVal);
        root.left = build(preorder,inorder,inStart,mid-1);
        root.right = build(preorder,inorder,mid+1,inEnd);
        return root;
    }

    public static int find(int inorder[], int start, int end, int value){
        for(int i=start; i<=end; i++){
            if(inorder[i] == value){
                return i;
            }
        }
        return -1;
    }

}