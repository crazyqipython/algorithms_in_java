package BreadthFirstSearch;
import java.util.*;

import javax.swing.tree.TreeNode;
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        if(root==null) return new ArrayList<List<Integer>>();

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Queue<TreeNode> pq = new LinkedList<TreeNode>();
        pq.add(root);
        while(!pq.isEmpty()){
            List<Integer> temp_list = new ArrayList<Integer>();
            int q_size = pq.size();
            for(int i=0; i<q_size; i++){
                TreeNode node = pq.remove();
                temp_list.add(node.val);

                if(node.left != null) pq.add(node.left);
                if(node.right != null) pq.add(node.right);
            }
            res.add(temp_list);
        }
        Collections.reverse(res);
        return res;
    }
}
