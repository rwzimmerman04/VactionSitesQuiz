package VacationSites;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        BinarySearchTree.java
 * Project      Primes with ATDs
 * Description  A definition for BinarySearchTree class with multitude of 
 *              methods for operations on trees.
 * Platform     jdk 1.8.0_241; NetBeans IDE 18; Windows 10
 * Course       CS 143, Edmonds College
 * Hours        30 minutes
 * Date         9/28/2023
 * @author	<i>Robert Zimmerman</i>
 * @version 	%1% %2%
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class BinarySearchTree {
    private BinarySearchTreeNode root;
    StringBuilder printBuffer = new StringBuilder("");
    StringBuilder buffer = new StringBuilder("");
    
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor     BinarySearchTree()-- default constructor
     * Description     Construct a null Tree of ints.
     * @author         <i>Robert Zimmerman</i>
     * Date            9/28/2023
     * History Log     9/28/2023
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTree() 
    {
        root = null;
    } 
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       InsertNode()
     * Description  Insert a new node in the binary search tree. If the root 
     *              node is null, create the root node here. Otherwise, call the
     *              insert method from the from the class BinarySearchTreeNode
     * @param       player Player
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void insertNode(Player player)
    {
        if (root == null)
            root = new BinarySearchTreeNode(player);
        else
            root.insert(player);
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       containsPlayer()
     * Description  A method to check if the BinarySearchTree cotains a specifc
     *              Player object.
     * @author      <i>Robert Zimmerman</i>
     * @param       player Player
     * @return      boolean
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean containsPlayer(Player player)
    {
        if(nodeWith(player, root) == null)
        {
            return false;
        }
        else 
        {
            BinarySearchTreeNode foundPlayer = nodeWith(player, root);
            return (foundPlayer.data).equals(player);
        }
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       buildBuffer()
     * Description  A method to build a buffer with all teh BST's information.
     * @author      <i>Robert Zimmerman</i>
     * @param       node BinarySearchTreeNode
     * Date         10/4/2023
     * History Log  10/4/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void buildBuffer(BinarySearchTreeNode node)
    {
        if(node != null)
        {
            buffer.append(node.data.toString() + '\n');
            buildBuffer(node.left);
            buildBuffer(node.right);
        }
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       remove()
     * Description  A method to remove a node with given name only. Calls
     *              overloaded remove method with player and the root of the
     *              BinarySearchTree
     * @author      <i>Robert Zimmerman</i>
     * @param       player Student to be removed
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void remove(Player player)
    {
	root = remove(player, root);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           remove()
     * Description      An overloaded recursive method to remove a node with 
     *                  given player and node. 
     * @author          <i>Robert Zimmerman</i>
     * @param           player Player to be removed
     * @param           node BinarySearchTreeNode
     * @return          node BinarySearchTreeNode--the new root
     * Date            9/28/2023
     * History Log      9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode remove(Player player, BinarySearchTreeNode node)
    {
	if( node == null )
	    return node;                        // Item not found; do nothing
	if(player.compareTo(node.data) < 0)
	    node.left = remove(player, node.left);
	else if(player.compareTo(node.data) > 0)
	    node.right = remove(player, node.right);
	else if(node.left != null && node.right != null) // Two children
        {
	    node.data = findMin(node.right).data;
	    node.right = remove(node.data, node.right);
	}
	else    //Case 1 & case 2: remove leaf node & single child
	    node = (node.left != null) ? node.left : node.right;
	return node;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getRoot()
     * Description  Getter method to return the root of the tree.
     * @author      <i>Robert Zimmerman</i>
     * @return      root BinarySearchTreeNode
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public BinarySearchTreeNode getRoot()
    {
        return root;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       removeAll()
     * Description  A method to remove all nodes of the BinarySearchTree.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void removeAll()
    {
        root = null;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findMin()
     * Description  A method to find and return the number with the minimum
     *              value. Calls an overloaded method to start the search 
     *              from the root node that is passed to it.
     * @author      <i>Robert Zimmerman</i>
     * @return      number int--with minimum value
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player findMin()
    {
        return findMin(root).data;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findMin()
     * Description  A recursive overloaded method to find the node with the 
     *              int containing the minimum value. 
     * @author      <i>Robert Zimmerman</i>
     * @param       node BinarySearchTreeNode--recursive node to search for minimum
     * @return      node BinarySearchTreeNode--node containing the smallest item
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode findMin(BinarySearchTreeNode node)
    {
	if(node == null)
	    return null;
	else if(node.left == null)
	    return node;
	return findMin(node.left);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findMax()
     * Description  A method to find and return the int with the maximum
     *              value. Calls an overloaded method to start the search 
     *              from the root node that is passed to it.
     * @author      <i>Robert Zimmerman</i>
     * @return      int int--with minimum name
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player findMax()
    {
        return findMax(root).data;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findMax()
     * Description  A recursive overloaded method to find the node with the 
     *              number containing the maximum value. 
     * @author      <i>Robert Zimmerman</i>
     * @param       node BinarySearchTreeNode--recursive node to search for minimum
     * @return      node BinarySearchTreeNode--node containing the largest item.
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode findMax(BinarySearchTreeNode node)
    {
	if( node != null )
        {
	    while( node.right != null )
		node = node.right;
        }	
	return node;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       elementAt()
     * Description  A method to return the int (data) given the node. 
     * @author      <i>Robert Zimmerman</i>
     * @param       node BinarySearchTreeNode
     * @return      Player
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private Player elementAt(BinarySearchTreeNode node)
    {
	return (node == null ? null : node.data);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       nodeWith()
     * Description  A method to return the int (data) given the node.
     * @author      <i>Robert Zimmerman</i>   
     * @param       data Player
     * @param       node BinarySearchTreeNode
     * @return      node BinarySearchTreeNode--the node with specified player
     * Date         9/28/2023
     * History Log  9/28/2023
    *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode nodeWith(Player data, BinarySearchTreeNode node)
    {
        if (node == null)
        {
            return null;
        }
        else
        {
            if(data == node.data)
                return node;
            else
                if (data.compareTo(node.data) < 0)
                    return nodeWith(data, node.left);
                else if (data.compareTo(node.data) > 0)
                    return nodeWith(data, node.right);
                else
                    return node;
        }            
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       contains()
     * Description  A boolean method to determine if a number is in the BST
     * @author      <i>Robert Zimmerman</i>   
     * @param       player Student
     * @return      true if int is in tree; false otherwise
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean contains(Player player)
    {
        if(nodeWith(player, root) == null)
            return false;
        else 
        {
            BinarySearchTreeNode foundPlayer = nodeWith(player, root);
            return foundPlayer.data == player;
        }            
    }
    
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       preorderTraversal()
     * Description  Display data of nodes in preorder: Node, Left, Right, Calls
     *              recursive preorderHelper method to do the real display.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void preorderTraversal()
    {
        preorderHelper( root );
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       preorderHelper()
     * Description  Display data of nodes id preorder: Node, Left, Right.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void preorderHelper( BinarySearchTreeNode node )
    {
        if ( node == null )
            return;
        System.out.print( node.data + " " );
        preorderHelper( node.left );
        preorderHelper( node.right );
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       inorderTraversal()
     * Description  Display data of nodes in preorder: Left, Node, Right. Calls
     *              recursive inorderHelper method to do the real display.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void inorderTraversal()
    {
        inorderHelper( root );
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       inorderHelper()
     * Description  Display data of nodes in preorder: Left, Node, Right.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void inorderHelper( BinarySearchTreeNode node )
    {
        if ( node == null )
            return;
        inorderHelper( node.left );
        System.out.print( node.data + " " );
        inorderHelper( node.right );
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       postorderTraversal()
     * Description  Display data of nodes in preorder: Left, Right, Node. Calls
     *              recursive postorderHelper method to do the real display.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void postorderTraversal()
    {
        postorderHelper( root );
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       postorderHelper()
     * Description  Display data of nodes in preorder: Left, Right, Node.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void postorderHelper( BinarySearchTreeNode node )
    {
        if ( node == null )
            return;
        postorderHelper( node.left );
        postorderHelper( node.right );
        System.out.print( node.data + " " );
    }
    
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       toString()
     * Description  Outputs the tree contents in sorted order as a string.
     *              It calls the printTree to print the tree inorder.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString( )
    {
	if( isEmpty() )
	    return( "" );
	else
	    return(printTree( root ));
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       printTree()
     * Description  Outputs the tree contents in preorder.
     * @param       node BinarySearchTreeNode--the node that roots the tree
     * @return      tree String
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String printTree(BinarySearchTreeNode node)
    {	        
	if(node != null)
        {
	    printTree(node.left);
            printBuffer.append(node.data.toString() + '\n');        
	    printTree(node.right);
	}
	return printBuffer.toString();
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       getBuffer()
     * Description  Return buffer.
     * @return      buffer  String
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public String getBuffer()
    {
        return  buffer.toString();      //printBuffer.toString();
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       setBuffer()
     * Description  Set buffer.
     * @param       buffer StringBuilder
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setBuffer(StringBuilder buffer)
    {
        this.buffer = buffer;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       isEmpty()
     * Description  Test if the tree is logically empty.
     * @return      true if empty, false otherwise
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean isEmpty()
    {
	return root == null;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       size()
     * Description  Find number of nodes in a tree. Calls sizeHelper with the
     *              root of the tree passed to it.
     * @return      number of nodes in a tree
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int size()
    {	
        return sizeHelper(root);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       sizeHelper()
     * Description  Recursive method to find number of nodes in a tree.
     * @param       node BinarySearchTreeNode
     * @return      number of nodes in the tree
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int sizeHelper (BinarySearchTreeNode node)
    {
	if (node == null)
	    return 0;
	else
	    return 1 + sizeHelper(node.left) + sizeHelper(node.right);
    }  

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       countLeaves()
     * Description  Find number of leaves in a tree. Calls countLeavesHelper  
     *              with the root of the tree passed to it.
     * @return      number of leaves in a tree to which node points
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int countLeaves() 
    {
        return countLeavesHelper(root);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       countLeavesHelper()
     * Description  Recursive method to find number of leaves in a tree.
     * @param       node BinarySearchTreeNode
     * @return      number of leaves in the tree
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int countLeavesHelper(BinarySearchTreeNode node)
    {
        if (node == null)
           return 0;
        else if (node.left == null && node.right == null)
            return 1;  // Node is a leaf.
        else
            return countLeavesHelper(node.left) + countLeavesHelper(node.right);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       height()
     * Description  Find height of a tree. Calls heighthHelper with the root 
     *              of the tree passed to it. The height of a node is the 
     *              number of edges on the longest path from the  node to a 
     *              leaf. A leaf node will have a height of 0.
     * @return      height of a tree int
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int height() 
    {
        return heighthHelper(root);        
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       heighthHelper()
     * Description  Recursive method to find the height of a node.
     * @param       node BinarySearchTreeNode
     * @return      height of a node int
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int heighthHelper(BinarySearchTreeNode node)
    {
        if(node == null)
            return 0;
        else
        {
            return 1 + Math.max(heighthHelper(node.left),
                    heighthHelper(node.right));
        }
//        int left = heighthHelper(node.left);
//        int right = heighthHelper(node.right);
//
//        int x = (left > right) ? left + 1 : right + 1;
//        return x;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findParent()
     * Description  Find parent of a number. Calls overloaded findParent with
     *              number, root and parent (null).
     * @param       player Player
     * @return      parent node of number BinarySearchTreeNode
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findParent(Player player) 
    {
        return findParent(player, root, null);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findParent()
     * Description  Recursive method to find the parent of a number.
     * @param       player Player
     * @param       node BinarySearchTreeNode
     * @param       parent BinarySearchTreeNode
     * @return      parent of a node or null--BinarySearchTreeNode
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findParent(Player player, 
            BinarySearchTreeNode node, BinarySearchTreeNode parent) 
    {
        if (node == null) 
        {
            return null;
        } 
        else if (node.data != player) 
        {
            parent = findParent(player, node.left, node);
            if (parent == null) 
            {
                parent = findParent(player, node.right, node);
            }
        }
        return parent;
    }
        
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findSuccessor()
     * Description  Recursive method to find the successor of a number 
     *              given the data.
     * @param       data int
     * @return      successor of an number or null--BinarySearchTreeNode
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findSuccessor(Player data) 
    {
        return findSuccessor(nodeWith(data,root));
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findSuccessor()
     * Description  An overloaded recursive method to find the successor of a
     *              number given a node.
     * @param       node BinarySearchTreeNode
     * @return      successor of an number or null--BinarySearchTreeNode
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findSuccessor(BinarySearchTreeNode node)
    {
	if (node == null)
		return null;
	
	if (node.right != null)
		return findMin(node.right);
	
	BinarySearchTreeNode y = findParent(node.data);
	BinarySearchTreeNode x = node;
	while (y != null && x == y.right)
	{
		x = y;
		y = findParent(y.data);
	}
	// Intuition: as we traverse left up the tree we traverse smaller values
	// The first node on the right is the next larger value
	return y;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findPredecessor()
     * Description  Recursive method to find the predecessor of a number 
     *              given the data.
     * @param       data int
     * @return      successor of an number or null--BinarySearchTreeNode
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findPredecessor(Player data) 
    {
        return findPredecessor(nodeWith(data,root));
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findPredecessor()
     * Description  An overloaded recursive method to find the predecessor of 
     *              a number given a node.
     * @param       node BinarySearchTreeNode
     * @return      predecessor of an number or null--BinarySearchTreeNode
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findPredecessor(BinarySearchTreeNode node)
    {
	if (node == null)
            return null;
	
	if (node.left!= null)
            return findMax(node.left);
			
	BinarySearchTreeNode parent = findParent(node.data);

	BinarySearchTreeNode y = parent;
	BinarySearchTreeNode x = node;
	while (y != null && x == y.left)
	{
            x = y;
            y = findParent(y.data);
	}	
	return y;
    }    
    
}
