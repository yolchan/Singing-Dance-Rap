package BinarySearchTree;
/*注意  搜索二叉树每个节点的值必定不同*/
public class BinarySearchTree {

	// 根节点
	public static TreeNode root;

	// 初始化为空
	public BinarySearchTree() {
		root = null;
	}

	// 查找
	public TreeNode search(int key) {
		TreeNode current = root;// 将根(空节点)付给当前树节点
		while (current != null && key != current.value) {
			if (key < current.value)
				current = current.left; // 跳往下一节点
			else
				current = current.right;
		}
		return current; // 返回查找到的节点或者null
	}

	// 插入
	public TreeNode insert(int key) {
		TreeNode newNode = new TreeNode(key);
		TreeNode current = root;
		TreeNode parent = null;

		// 如果根节点为空  就将新节点赋给根节点  并返回
		if (current == null) {
			root = newNode;
			return newNode;
		}

		while (true) {
			parent = current;
			/*当key小于当前节点的值时，就去访问下一个左节点(左节点一定比当前节点小),直到访问到的当前节点的左节点为空的时候,将新节点赋给这个左节点*/
			if (key < current.value) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
				}
			/*否则key大于(搜索二叉树不存在key等于)当前节点的值时，访问下一个右节点(右节点一定比当前节点大),直到访问到的当前节点的右节点为空的时候，将新节点赋给这个右节点*/
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return newNode;
				}
			}
		}
	}

	
	//删除
	
	public TreeNode delete(int key){
		TreeNode parent =root;
		TreeNode current=root;
		boolean isLeftChild=false;//判断是否存在左子节点
		
		while(current.value!=key){
			parent=current;
			if(current.value>key){
				isLeftChild=true;
				current=current.left;
			}else{
				isLeftChild=false;
				current=current.right;
			}
			
			//如果未查找到
			if(current==null)
				return  current;
		}
	
		/** 目前已获取需要删除的节点
		 * 	接下来就要处理当前节点的子节点了
		 * */
		
		/**若删除节点左右节点都为空**/
		if(current.left==null && current.right==null){
			//如果这个删除节点就是根节点
			if(current==root)
				root=null;
		
			//如果这个删除节点在父节点的左子节点
			if(isLeftChild==true)
				parent.left=null;
			else
				parent.right=null;
		}
		
		/**如果删除节点只有一个子节点:右节点 或者左节点**/
		else if(current.right==null){
			/*如果删除节点是根节点 便让左节点代替它 
			至于为啥是左节点代替而非右:因为要保证左节点比当前节点小，右节点比当前节点大
			*/
			if(current==root)
				root=current.left;
			
			
			//如果这个节点是左节点,则把它接到父节点的左边
			else if(isLeftChild)
				parent.left=current.left;
			else
				parent.right=current.left;
		}
		
		
		/**若删除节点左右子节点都 不为空**/
		else if(current.left!=null&&current.right!=null){
			//需要找到删除节点的后继者,让右节点的排序正确(把右节点树群中的最小值提升到右节点的位置
			TreeNode successor=getDeleteSuccessor(current);
			//如果被删节点是根节点，就将右节点替换到删除节点的位置(删除执行后
			if(current==root)
				root=successor;
			else if(isLeftChild)
				parent.left=successor;
			else
				parent.right=successor;
			
			successor.left=current.left;
		}
		
		return current;
	}
	
	
	
	/**
	 * 
	 * 获得删除节点的后继者,也就是它右节点树种最小的节点,
	 * 后继者应该是也必须是右节点树群中最小的节点
	 * 
	 * **/
	public TreeNode getDeleteSuccessor(TreeNode deleteNode){
		//后继者
		TreeNode succeeor=null;
		TreeNode successorParent=null;
		TreeNode current=deleteNode.right;  //当前节点为需要删除元素的右子节点
		
		//找到右节点中最小的节点 以及它的 父节点
		while(current!=null){
			successorParent=succeeor;
			succeeor=current;
			current=current.left;
		}
		
		/*将最小节点的右节点赋给最小节点的父节点的 左节点
		   将删除节点的右节点 赋给最小节点的父节点的 右节点
			直到最小节点为删除节点的右节点
			
		   这里有点抽象  多想想*/
		if(succeeor!=deleteNode.right){
			successorParent.left=succeeor.right;
			succeeor.right=deleteNode.right;
		}
		
		return succeeor;
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree tree=new BinarySearchTree();
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		
		tree.search(7);
		tree.delete(6);
		tree.delete(5);
		tree.delete(7);
		
	}
	
}