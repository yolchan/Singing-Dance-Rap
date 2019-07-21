package BinarySearchTree;
//树节点
/**
 * 每个节点中有三个值
 * 	左节点，右节点，自身数据
 * 左节点的值(value)一定比右节点的值小
 * @author Administrator
 *
 */
public class TreeNode {
	// 节点值
		int value;
		// 左节点
		TreeNode left;
		// 右节点
		TreeNode right;

		public TreeNode(int value) {
			this.value = value;
			left = null;
			right = null;
		}
}
