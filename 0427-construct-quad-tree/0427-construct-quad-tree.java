/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return (grid.length == 0)? null : helper(grid, 0, 0, grid.length);
    }

    public Node helper(int[][] grid, int x, int y, int len){
        Node newNode = new Node(grid[x][y] != 0, true, null, null, null, null);
        int half = len / 2;

        if(len == 1) return newNode;

        Node topLeft = helper(grid, x, y, half);    
        Node topRight = helper(grid, x, y + half, half);
        Node bottomLeft = helper(grid, x + half, y, half);                            
        Node bottomRight = helper(grid, x + half, y + half, half);

        if(!topLeft.isLeaf || !topRight.isLeaf || !bottomLeft.isLeaf || !bottomRight.isLeaf
           || topLeft.val != topRight.val || topRight.val != bottomLeft.val 
                || bottomLeft.val != bottomRight.val){
            newNode.topLeft = topLeft;
            newNode.topRight = topRight;
            newNode.bottomLeft = bottomLeft;
            newNode.bottomRight = bottomRight;
            newNode.isLeaf = false;
        }
        return newNode;
    }
}