class Solution {

    // Check leaf node
    public static boolean isleaf(Node root) {
        return root.left == null && root.right == null;
    }

    // Add left boundary (excluding leaf)
    public static void addleft(Node root, ArrayList<Integer> ans) {
        Node curr = root.left;
        while (curr != null) {
            if (!isleaf(curr)) ans.add(curr.data);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    // Add all leaf nodes
    public static void addleaf(Node root, ArrayList<Integer> ans) {
        if (root == null) return;

        if (isleaf(root)) {
            ans.add(root.data);
            return;
        }

        addleaf(root.left, ans);
        addleaf(root.right, ans);
    }

    // Add right boundary (excluding leaf, bottom-up)
    public static void addright(Node root, ArrayList<Integer> ans) {
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isleaf(curr)) temp.add(curr.data);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        // reverse and add
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }

    ArrayList<Integer> boundaryTraversal(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        // Add root (if not leaf)
        if (!isleaf(root)) ans.add(root.data);

        addleft(root, ans);
        addleaf(root, ans);
        addright(root, ans);

        return ans;
    }
}
