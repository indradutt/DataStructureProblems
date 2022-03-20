/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSymmetric(root, root)
    }
    
    private fun isSymmetric(node1: TreeNode?, node2: TreeNode?): Boolean {
        if(node1 == null && node2 == null) return true
        
        if(node1 != null && node2 != null && node1.`val` == node2.`val`) {
            return isSymmetric(node1.left, node2.right) && 
                    isSymmetric(node1.right, node2.left)
        }
        return false
    }
}
