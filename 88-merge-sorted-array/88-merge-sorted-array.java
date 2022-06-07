class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=m+n;
        int[] nums3=new int[len];
        for(int i=0;i<n;i++){
            nums1[i+m]=nums2[i];
        }
        heapSort(nums1,len);
    }
    public void heapify(int[] a,int n,int i){
        int parent=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n && a[left]>a[parent]){
            parent=left;
        }
        if(right<n && a[right]>a[parent]){
            parent=right;
        }
        if(parent!=i){
            int temp=a[parent];
            a[parent]=a[i];
            a[i]=temp;
            heapify(a,n,parent);
        }
        
    }
    public void heapSort(int[] a,int n){
        for(int i=n/2-1;i>=0;i--){
            heapify(a,n,i);
        }
        for(int i=n-1;i>=0;i--){
            int temp=a[0];
            a[0]=a[i];
            a[i]=temp;
            heapify(a,i,0);
        }
    }
}