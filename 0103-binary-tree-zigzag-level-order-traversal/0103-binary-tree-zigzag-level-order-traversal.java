class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();

        if (root == null) return ans;

        queue.offer(root);
        int level = 0;   // FIX: track level

        while (!queue.isEmpty()) {   // FIX 1
            int size = queue.size();
            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // FIX 2: zigzag based on level (not i)
                if (level % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }

                // FIX 3: children always added normally
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            ans.add(list);
            level++;   // FIX 4: move to next level
        }

        return ans;
    }
}
