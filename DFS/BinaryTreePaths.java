package DepthFirstSearch;

import java.util.*;

public class BinaryTreePaths {
    public List<String> BinaryTreePaths(TreeNode root){

        List<String> res = new ArrayList<String>();

        dfs(res, "", root);

        return res;
    }

    public void dfs(List<String> res, String temp, TreeNode root){

        temp = temp == "" ? Integer.toString(root.val) : temp + "->" + Integer.toString(root.val); 
        if(root.left == null && root.right == null){
            res.add(temp);
            return;
        }

        if(root.right != null) dfs(res, temp, root.right);

        if(root.left != null) dfs(res, temp, root.left);
    }
}
