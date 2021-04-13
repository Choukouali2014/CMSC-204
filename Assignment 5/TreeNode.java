
/**
 * @author Frank Choukouali
 *
 * @param <T> generic data type
 */
public class TreeNode<T> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode
	 */
	public TreeNode(T dataNode) {
		this.data = dataNode;
		this.left=null;
		this.right = null;
	}
	
	/**
	 *used for making deep copies
	 * @param node
	 */
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;
	}
	
	/**
	 * @return Return the data within this TreeNode
	 */
	public T getData() {
		return data;
	}

	/**
	 * @return the left element of the TreeNode
	 */
	public TreeNode<T> getLeft() {
		return left;
	}

	/**
	 * sets the left of the Tree
	 * @param left
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	/**
	 * @return the right element of the TreeNode
	 */
	public TreeNode<T> getRight() {
		return right;
	}

	/**
	 *sets the right of the Tree
	 * @param right
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	
	
}
