class FindSum {
    fun hasPathSum(root: Node?, targetSum: Int): Boolean {
        return root?.let {
            val remaining = targetSum - root.data
            val found = root.left == null && root.right == null && remaining == 0
            if(found)
                true

            found || hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining)

        } ?:  false
    }

}
