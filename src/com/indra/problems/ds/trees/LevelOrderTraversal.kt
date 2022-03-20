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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val rootList = mutableListOf<MutableList<Int>>()
    
        visit(root, rootList, 0)
        
        return rootList
    }
    
    private fun visit(node: TreeNode?, rootList: MutableList<MutableList<Int>>, level: Int) {
        node?.let {
            if(rootList.size <= level) {
               rootList.add(mutableListOf(node.`val`) )
            } else {
                rootList[level].add(node.`val`)
            }
            visit(node.left, rootList, level + 1)
            visit(node.right, rootList, level + 1)
        }
    }
}
