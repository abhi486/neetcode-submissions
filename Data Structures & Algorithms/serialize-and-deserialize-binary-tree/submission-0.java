/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    void serializeHelper(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("N").append(",");
            return;
        }

        str.append(root.val).append(",");
        serializeHelper(root.left, str);
        serializeHelper(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return deserializeHelper(nodes, new int[] {0});
    }

    TreeNode deserializeHelper(String[] nodes, int[] idx) {
        if (idx[0] == nodes.length - 1) return null;

        if (nodes[idx[0]].equals("N")) {
            idx[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx[0]]));
        idx[0]++;

        root.left = deserializeHelper(nodes, idx);
        root.right = deserializeHelper(nodes, idx);

        return root;
    }
}
