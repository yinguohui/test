package JAVA集合;

/**
 * @ClassName TreeNode
 * @Auhtor ygh
 * @DATE 2019/7/11 14:29
 **/
/**
 * 树节点，假设不存在重复元素
 * @param <T>
 */
public  class TreeNode<T extends Comparable<T>> {
    T value;
    TreeNode<T> parent;
    TreeNode<T> left, right;

    public TreeNode(T value, TreeNode<T> parent) {
        this.value = value;
        this.parent = parent;
    }

    /**
     * 获取根节点
     */
    TreeNode<T> root() {
        TreeNode<T> cur = this;
        while (cur.parent != null) {
            cur = cur.parent;
        }
        return cur;
    }

    /**
     * 中序遍历
     */
    void inOrderTraverse() {
        System.out.println(this.value);
        if(this.left != null) this.left.inOrderTraverse();
        if(this.right != null) this.right.inOrderTraverse();
    }

    /**
     * 经典的二叉树插入元素的方法
     */
    TreeNode<T> insert(T value) {
        // 先找根元素
        TreeNode<T> cur = root();

        TreeNode<T> p;
        int dir;

        // 寻找元素应该插入的位置
        do {
            p = cur;
            if ((dir=value.compareTo(p.value)) < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        } while (cur != null);

        // 把元素放到找到的位置
        if (dir < 0) {
            p.left = new TreeNode<>(value, p);
            return p.left;
        } else {
            p.right = new TreeNode<>(value, p);
            return p.right;
        }
    }
}