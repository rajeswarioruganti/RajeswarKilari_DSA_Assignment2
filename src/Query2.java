// Class of the node
class Node
{
	int val;
	Node left, right;
	Node(int item)
	{
		val = item;
		left = right = null;
	}
};
class Query2
{
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	// Function 
	static void flattenBTToSkewed(Node root,int order){
		// Base Case
		if(root == null) {
			return;
		}
	
		// Condition to check the order
		
		if(order > 0)
		{
			flattenBTToSkewed(root.right, order);
		}
		else
		{
			flattenBTToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;
	
		// Condition to check if the root Node
		// of the skewed tree is not defined
		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
	
		// Similarly recurse for the left / right
		// subtree on the basis of the order required
		if (order > 0)
		{
			flattenBTToSkewed(leftNode, order);
		}
		else
		{
			flattenBTToSkewed(rightNode, order);
		}
	}

	// Function to traverse the right
	// skewed tree using recursion
	static void traverseRightSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);	
	}

	// Driver Code
	public static void main (String[] args)
	{
		node = new Node(50);
		node.left = new Node(30);
		node.right = new Node(60);
		node.left.left = new Node(10);
		node.right.left = new Node(55);
		
		// For Increasing order - 0
		// For Decreasing order - 1
		int order = 0;
		flattenBTToSkewed(node, order);
		traverseRightSkewed(headNode);
	}
}

