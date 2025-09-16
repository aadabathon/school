public class BSTRotation<T extends Comparable<T>> extends BinarySearchTree<T> {

    protected void rotate(BinaryNode<T> child, BinaryNode<T> parent)
        throws NullPointerException, IllegalArgumentException {
            if (parent == null|| child == null) { // Throw NPE if either arguement is null.
                throw new NullPointerException();
            }
            
            if (parent != child.parent) { 
                throw new IllegalArgumentException(); 
            }

            BinaryNode<T> G = parent.parent; // "grandparent" Node. 

            if (parent.left == child) { // In this case we do a right rotation about the parent node
                // Child = parent.left
                BinaryNode<T> dummy = child.right;
                // dummy = child.right
                parent.left = dummy; // parent's left node is child's right node.
                if (dummy != null) { // if dummy is null, then theres not need to set its parent
                    dummy.parent = parent;
                } 

                child.parent = G;
                if (G == null) { //If G's parent is null, it is the root node and we must program accordingly.
                    this.root = child;
                } else if (G.left == parent) {
                    G.left = child;
                } else {
                    G.right = child;
                } 
                
                parent.parent = child; // Finish this off by putting parent on childs RIGHT SIDE.
                child.right = parent;
                


            } else if (parent.right == child) { // In this case we do a left rotation about the parent node
                BinaryNode<T> dummy = child.left;
                parent.right = dummy; // same thing but flipped, parent's right node is child's left node.
                if (dummy != null) { // If dummy is null, there's no need to set its parent.
                    dummy.parent = parent;
                }

                child.parent = G;
                if (G == null) { // Again, in this case parent is the root so we set child to be the root.
                    this.root = child;
                } else if (G.left == parent) {
                    G.left = child;
                } else {
                    G.right = child;
                }

                parent.parent = child;  // Finish off by putting parent on childs LEFT SIDE.
                child.left = parent;




            } else {
                throw new IllegalArgumentException(); // If neither case above hits, throw IAE
            } 
            public void test1() {

            }
            public void test2() {

            }
            public void test3() {

            }
            public void test4() {

            }
            public void test5() {
                
            }
    }
}