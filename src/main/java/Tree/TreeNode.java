package Tree;

public class TreeNode {

    protected TreeNode left;
    protected TreeNode right;
    protected int data;

    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode getLeft(){
        return left;
    }

    public TreeNode getRight(){
        return right;
    }

    public int getData(){
        return data;
    }

    public void setLeft(TreeNode left){
        this.left = left;
    }

    public void setRight(TreeNode right){
        this.right = right;
    }

    public void prettyPrint(int level){
        for (int i = 0; i < level; i++){
            System.out.print("\t");
        }
        System.out.println(data);
        if (left != null){
            left.prettyPrint(level + 1);
        }
        if (right != null){
            right.prettyPrint(level + 1);
        }
    }

    public int leafCount(){
        int count = 0;

        if (left == null && right == null){
            count++;
        }

        if (left != null){
            count += left.leafCount();
        }

        if (right != null){
            count += right.leafCount();
        }

        return count;
    }

    public int numberOfFullNodes(){
        int count = 0;

        if (left != null && right != null){
            count++;
        }

        if (left != null){
            count += left.numberOfFullNodes();
        }
        if (right != null){
            count += right.numberOfFullNodes();
        }
        return count;
    }

    public int numberOfSingletonNodes() {
        int count = 0;

        // Check if the current node is a singleton:
        // That means it has exactly one child (either left or right, but not both)
        if ((left != null && right == null) || (left == null && right != null)) {
            count++;
        }

        // Recurse into the left subtree (if it exists)
        if (left != null) {
            count += left.numberOfSingletonNodes();
        }

        // Recurse into the right subtree (if it exists)
        if (right != null) {
            count += right.numberOfSingletonNodes();
        }

        // Return the total number of singleton nodes in this subtree
        return count;
    }

    public int lessThanX(int x){
        int count = 0;
        if (data < x){
            count++;
        }

        if (left != null){
            count += left.lessThanX(x);
        }
        if (right != null){
            count += right.lessThanX(x);
        }
        return count;
    }

    public void deleteLeafNodes(){
        if (left != null && left.left == null && left.right == null){
            left = null;
        } else if (left != null){
            left.deleteLeafNodes();
        }

        if (right != null && right.left == null && right.right == null){
            right = null;
        } else if (right != null){
            right.deleteLeafNodes();
        }
    }

    public int sumOfTree(){
        int sum = data;

        if (left != null){
            sum += left.sumOfTree();
        }

        if (right != null){
            sum += right.sumOfTree();
        }

        return sum;
    }

    public void swapChildren(){
        // Step 1: Swap left and right children of the current node
        TreeNode tmp = left;
        left = right;
        right = tmp;

        // Step 2: Recursively apply the same logic to left and right children
        if (left != null){
            left.swapChildren();
        }
        if (right != null){
            right.swapChildren();
        }
    }

    public int height(){
        if (left == null && right == null){
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if (left != null){
            leftHeight = left.height();
        }
        if (right != null){
            rightHeight = right.height();
        }
        if (leftHeight > rightHeight){
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    public boolean isMirror(TreeNode left, TreeNode right){
       if (left == null && right == null){
           return true;
       }
       if (left == null || right == null){
            return false;
       }
       if (left.data != right.data){
           return false;
       }
       
       return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
