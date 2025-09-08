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

    public boolean test1() { //Int Type BST, tests insert() and size()
        BinarySearchTree<Integer> test1 = new BinarySearchTree<>();
        test1.insert(2); test1.insert(4); test1.insert(6); test1.insert(8); test1.insert(10);
        test1.insert(1); test1.insert(3); test1.insert(5); test1.insert(7); test1.insert(9);
        boolean leg1 = test1.contains(1) && test1.contains(2) && test1.contains(3) && test1.contains(4) && test1.contains(5) && test1.contains(6) && test1.contains(7) && test1.contains(8) && test1.contains(9) && test1.contains(10); 
        boolean leg2 = (test1.size() == 10);
        return leg1 && leg2;
    }
    public boolean test2() { //String Type BST, again testing insert() and size() with a different shape as well
        BinarySearchTree<String> test2 = new BinarySearchTree<>();
        test2.insert("J"); test2.insert("a"); test2.insert("v"); test2.insert("a"); test2.insert("I");
        test2.insert("s"); test2.insert("C"); test2.insert("o"); test2.insert("o"); test2.insert("l");
        boolean leg1 = test2.contains("J") && test2.contains("a") && test2.contains("v") && test2.contains("I") && test2.contains("s") && test2.contains("C") &&  test2.contains("o") && test2.contains("l"); 
        boolean leg2 = !test2.contains("Z");
        boolean leg3 = test2.size() == 10;
        return leg1 && leg2 && leg3;
    }

    public boolean test3() { //Testing clear() and IsEmpty()
        BinarySearchTree<Integer> test3 = new BinarySearchTree<>();
        test3.insert(100); test3.insert(300); test3.insert(200);
        boolean leg1 = test3.size() == 3;
        test3.clear();
        boolean leg2 = test3.size() == 0 && test3.isEmpty();
        return leg1 && leg2;
    }

    public boolean test4() { //Testing NullPointerException
        BinarySearchTree<Integer> test4 = new BinarySearchTree<>();
        try {
            test4.insert(null);
            return false; // If no exception is caught, return false immediately
        }
        catch (NullPointerException e) { //Correct exception is caught, return True
            return true;
        }
        catch (Exception e){ //An erroneous exception is caught, return false
            return false;
        }

    }
    public static void main(String[] args){
        BinarySearchTree<Integer> testingInt = new BinarySearchTree<>();
        BinarySearchTree<String> testingString = new BinarySearchTree<>();
        boolean l1 = testingInt.test1();
        boolean l2 = testingString.test2();
        boolean l3 = testingInt.test3();
        boolean l4 = testingInt.test4();
        if (l1 && l2 && l3 && l4){
            System.out.println("ALL TESTS PASSED");
        } else{
            System.out.println("Get Back To Work.");
        }
    }
}

