
public class BinarySearchTree<T extends Comparable<T>> 
implements SortedCollection<T> { // This is a class that inherits from BinaryNode and implements the interfece SortedCollection
    protected BinaryNode<T> root = null;
    protected int size = 0;

    private BinaryNode<T> append(BinaryNode<T> Start, T val){
        if (Start == null) { //This helper method traverse returns the Node in which we are trying to insert or remove at
            return new BinaryNode<>(val);
        }

        int i = val.compareTo(Start.data);
        if (i <= 0) { //This calls recursively until the base case is met, in which a new node is made, returned, and has been assigned the correct pointers in this given BST
            Start.left = append(Start.left, val);
        } else {
            Start.right = append(Start.right, val);
        }
        return Start;  
    }

    @Override
    public void insert(T data) {
        if (data == null) throw new NullPointerException(); //Throws e if data == null
        root = append(root, data); //We call the helper method on root, it traverses the tree until the path points to null in which that same path is assigned to a new node of type data, ensuring path preservation AND optimziation.
    }

    @Override
    public boolean contains(Comparable<T> data) {
        if (data == null) throw new NullPointerException(); // Throw e if data == null
        
        BinaryNode<T> dummy = root; //Start at root
        while(dummy != null) { //Loop while dummy is not null
            int i = data.compareTo(dummy.data);
            if (i < 0){ // if dummy.data is less than our arguement, go left
                dummy = dummy.left;
            } else if (i > 0) { //if greater, go right
                dummy = dummy.right;
            } else return true; //if neither are true, dummy.data == data is true and we can safely return true
        }
        return false; //If the loop breaks it means that we traversed the list and did not find our value.
    }

    private int sizeOf(BinaryNode<T> dummy) { // This helper method lets us recursively find the size of any tree or subtree in a BST
        if (dummy == null){ // If arguement is null, return 0
            return 0;
        } else { // If it is not null, return 1 (size of itself; important for this recursive call) + the sizeOf its left and right child. This ensures all nodes are hit no matter where they are at in the tree.
            return 1 + sizeOf(dummy.left) + sizeOf(dummy.right);
        }
    }

    @Override
    public int size(){ // size is called with no arguements, so we assume that we should return the size of the whole BST. So we start at the root.
        return sizeOf(root);
    }

    @Override
    public boolean isEmpty(){
        return size() == 0; //If size is 0, BST is empty, I you could also do return root == null; not sure though.
    }

    @Override
    public void clear(){ //Setting size to 0 and clearing the root node renders the BST cleared, this seems ineffective however all of the BinaryNodes will be swept by the JVM Garabage collector. I imagine this would be poor practice in a language like C
        size = 0;
        root = null;
    }

    public boolean test1() {
        
        return true;
    }
    public boolean test2() {

        return true;
    }
    public boolean test3() {

        return true;

    }
}

