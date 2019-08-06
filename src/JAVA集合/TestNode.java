package JAVA集合;


/**
 * @ClassName TestNode
 * @Auhtor ygh
 * @DATE 2019/7/11 14:25
 **/
public class TestNode {
    public static void main(String[] args) {
        TreeNode<Integer> node = new TreeNode<>(1,null).insert(5).insert(4).insert(8)
                .insert(9).insert(22).insert(11);
        TreeNode node1;
        //
            node1=node.root();
        node1.inOrderTraverse();
    }
}
