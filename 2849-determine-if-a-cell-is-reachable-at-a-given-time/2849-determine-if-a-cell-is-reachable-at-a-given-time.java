public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int vertDist = Math.abs(sy - fy);
        int horDist = Math.abs(sx - fx);

        if (vertDist == 0 && horDist == 0 && t == 1) {
            return false;
        }

        return t >= Math.max(vertDist, horDist);
    }
}