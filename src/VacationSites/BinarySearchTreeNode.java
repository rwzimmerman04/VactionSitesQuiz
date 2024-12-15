package VacationSites;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        BinarySearchTreeNode.java
 * Project      VacationSites
 * Description  A self-refential class representing a binary tree node of 
 *              Player objects.      
 * Platform     jdk 1.8.0_241; NetBeans IDE 18; Windows 10
 * Course       CS 143, Edmonds College
 * Hours        25 minutes
 * Date         9/28/2023
 * History Log  9/28/2023
 * @author	<i>Robert Zimmerman</i>
 * @version 	%1% %2%
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class BinarySearchTreeNode {
    
    BinarySearchTreeNode left;      // left node
    Player data;                   // data item
    BinarySearchTreeNode right;     // right node
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  BinarySearchTreeNode()-- constructor
     * Description  Initialize data to player and make this a leaf node.
     * @param       player Player
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode(Player player) 
    {
        data = player;
        left = right = null;        //Node has no children
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       Insert()
     * Description  Recursive method to insert a Student object into a Tree 
     *              that contains node.
     * @param       player Player
     * @author      <i>Robert Zimmerman</i>
     * Date         9/28/2023
     * History Log  9/28/2023
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public synchronized void insert(Player player)
    {
        if (player.compareTo(data) < 0)
        {
            if (left == null)
                left = new BinarySearchTreeNode(player);
            else
                left.insert(player);
        }
        else
        {
            if (player.compareTo(data) >= 0)
            {
                if (right == null)
                    right = new BinarySearchTreeNode(player);
                else
                    right.insert(player);
            }
        }
    }
}
