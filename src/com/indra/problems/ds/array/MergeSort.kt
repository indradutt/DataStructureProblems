class Solution {
    fun mergeSort(nums: IntArray): IntArray {
        if(nums.size < 2) return nums
        val mid = nums.size/2
        
        val left = IntArray(mid)
        val right = IntArray(nums.size - mid)
        for(i in 0..mid - 1) {
            left[i] = nums[i] 
        }
        for(i in mid..nums.size - 1) {
            right[i - mid] = nums[i]        
        }
       	mergeSort(left)
        mergeSort(right)
            
        return merge(nums, left, right) 
    }
    
    
    private fun merge(nums: IntArray, left: IntArray, right: IntArray): IntArray {
        var lIndex = 0
        var rIndex = 0
        var index = 0
        while(lIndex < left.size && rIndex < right.size ) {
            nums[index++] = if(left[lIndex] < right[rIndex]) left[lIndex++] else right[rIndex++]
        }
        
        while(lIndex < left.size) {
            nums[index++] = left[lIndex++]
            
        }
        
        while(rIndex < right.size) {
            nums[index++] = right[rIndex++]
        }
        
        return nums
    }
}
