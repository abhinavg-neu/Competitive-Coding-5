
class Solution {
    //Time Complexity: O(n)
   //Space Complexity: O(1)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

       if (root == null)
       return new ArrayList<>();

List<List<Integer>> res = new ArrayList<>();
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
        int dir = 0;
       while (!q.isEmpty()){
        List<Integer> list = new ArrayList<>();
        int len = q.size();

            for (int i = 0; i < len;i++){
                TreeNode node = q.poll();
                if (node != null){
                    if (dir == 0) list.add (node.val); else list.add (0,node.val) ;
                    q.add(node.left);
                    q.add(node.right);
                }
            }
                if (!list.isEmpty()){
                    res.add (list);
                }
                dir = (dir == 0) ? 1 : 0;
       } 
       return res;
    }
}
