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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
		
		//if the depth is one then we need to place the new node at the root of the tree
        if(depth==1){ 
            TreeNode newRoot = new TreeNode(val,root,null);
            return newRoot;
        }
		
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int tDepth = 1;
        while(!q.isEmpty()){
			//the current members during each iteration of the inner while-loop (while row>0)
			//represents the TreeNodes in each row
            int row = q.size();
            while(row>0){
				//if you find yourself in the row just before the required depth then
				//simply add the new TreeNodes beneath this row
                if(tDepth==depth-1){
                    while(!q.isEmpty()){
                        TreeNode tDepthNode = q.poll();
                        TreeNode tleft = tDepthNode.left;
                        TreeNode tright = tDepthNode.right;
                        tDepthNode.left = new TreeNode(val);
                        tDepthNode.right = new TreeNode(val);
						//attach the subtrees below the newly added row
                        tDepthNode.left.left = tleft;
                        tDepthNode.right.right = tright;
                    }
                    return root;
                }
                
                TreeNode temp = q.poll();
                if(temp.left!=null)
                    q.add(temp.left);
                
                if(temp.right!=null)
                    q.add(temp.right);
                
                row--;
            }
            tDepth++;
        }
        return null;
    }
}