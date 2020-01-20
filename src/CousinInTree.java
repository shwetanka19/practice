public class CousinInTree {
    public boolean isCousins(TreeNode root, int x, int y) {

        FoundNode f1 = findNodeParent(root, x, 0);
        FoundNode f2 = findNodeParent(root, y, 0);

        System.out.println(f1);
        System.out.println(f2);

        if (f1 == null || f2 == null || f1.p == null || f2.p == null) {
            return false;
        }

        if (f1.p.val != f2.p.val && f1.d == f2.d){
            return true;
        }
        return false;
    }

    public FoundNode findNodeParent(TreeNode node, int val, int depth){
        if (node.left != null && node.left.val == val){
            return new FoundNode(depth+1, node);
        }
        if (node.right != null && node.right.val == val){
            return new FoundNode(depth+1, node);
        }
        FoundNode fn = null;
        if (node.left != null){
            fn = findNodeParent(node.left, val, depth+1);
        }
        if (node.right != null && fn == null){
            fn = findNodeParent(node.right, val, depth+1);
        }
        return fn;
    }


    public static void main(String [] args){
        CousinInTree cousinInTree = new CousinInTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(4);
        root.right.left = null;
        root.right.right = new TreeNode(5);

        System.out.println(cousinInTree.isCousins(root, 5, 4));
    }
}

class FoundNode {
    int d;
    TreeNode p;

    FoundNode(int d, TreeNode p){
        this.d = d;
        this.p = p;
    }

    @Override
    public String toString() {
        return "FoundNode{" +
                "d=" + d +
                ", p=" + p +
                '}';
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
}
