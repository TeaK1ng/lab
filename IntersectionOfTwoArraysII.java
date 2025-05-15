public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int ind1=0, ind2=0;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while((ind1 < nums1.length) && (ind2 < nums2.length)){
            if(nums1[ind1] < nums2[ind2]){
                ind1++;
            }
            else if(nums1[ind1] > nums2[ind2]){
                ind2++;
            }
            else if(nums1[ind1] == nums2[ind2]){
                list.add(nums1[ind1]);
                ind1++;
                ind2++;
            }
        }
        int[] res= new int[list.size()];
        for(int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}