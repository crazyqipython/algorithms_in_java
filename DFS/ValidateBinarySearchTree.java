package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ValidateBinarySearchTree {
    public boolean isValidateBinarySearchTree(TreeNode root){
        ArrayList<Integer> l = new ArrayList<Integer>();
        help(root, l);

        for (int i = 0; i < l.size() - 1; i++) {
            if (l.get(i) >= l.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void help(TreeNode root, ArrayList<Integer> l) {
        if (root == null)
            return;
        help(root.left, l);
        l.add(root.val);
        help(root.right, l);
    }
}
