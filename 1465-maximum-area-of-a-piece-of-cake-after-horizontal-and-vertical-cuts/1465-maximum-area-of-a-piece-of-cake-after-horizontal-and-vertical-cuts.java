class Solution {
    public int maxArea(int h, int w, int[] ho, int[] ve) {
        Arrays.sort(ho);
        Arrays.sort(ve);
        int hmax=Math.max(ho[0],h-ho[ho.length-1]);
        int vmax=Math.max(ve[0],w-ve[ve.length-1]);
        for(int i=1;i<ho.length;i++){
            hmax=Math.max(hmax,ho[i]-ho[i-1]);
        }
        for(int i=1;i<ve.length;i++){
            vmax=Math.max(vmax,ve[i]-ve[i-1]);
        }
        return (int) ((long) hmax * vmax % 1000000007);
         
    }
}