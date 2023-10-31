package others.C4Tree.P3BinaryTree;

import java.util.Objects;

public class Solution {

    public static void main(String[] args) {
        BinaryTree newBinaryTree = new BinaryTree(9);
        newBinaryTree.insert("N1");
        newBinaryTree.insert("N2");
        newBinaryTree.insert("N3");
        newBinaryTree.insert("N4");
        newBinaryTree.insert("N5");
        newBinaryTree.insert("N6");
        newBinaryTree.insert("N7");
        newBinaryTree.insert("N8");
        newBinaryTree.insert("N9");
        System.out.println(newBinaryTree.isFull());

        System.out.println();
        newBinaryTree.preOrder(1);

        System.out.println();
        newBinaryTree.inOrder(1);

        System.out.println();
        newBinaryTree.postOrder(1);

        System.out.println();
        newBinaryTree.levelOrder();

        System.out.println();
        System.out.println(newBinaryTree.search("N9"));

        System.out.println();
        newBinaryTree.delete("N5");
        System.out.println();
        newBinaryTree.levelOrder();

        System.out.println();
        newBinaryTree.deleteBT();
    }
}

class BinaryTree {

    String[] arr;
    int lastUsedIndex;

    public BinaryTree(int size) {
        arr = new String[size + 1];
        this.lastUsedIndex = 0;
        System.out.println("Blank Tree of size " + size + " has been created");
    }

    boolean isFull(){
        if(arr.length - 1 == lastUsedIndex){
            return true;
        } else {
            return false;
        }
    }

    void insert (String value) {
        if(!isFull()){
            arr[lastUsedIndex + 1] = value;
            lastUsedIndex++;
            System.out.println("The value of " + value + " has been inserted");
        } else {
            System.out.println("The BT is full");
        }
    }

    public void preOrder(int index){
        if(index > lastUsedIndex){
            return;
        }
        System.out.print(arr[index] + " ");
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    // InOrder Traversal
    public void inOrder (int index) {
        if(index > lastUsedIndex){
            return;
        }
        inOrder(index * 2);
        System.out.print(arr[index] + " ");
        inOrder(index * 2 + 1);
    }

    // post Order Traversal
    public void postOrder(int index){
        if(index > lastUsedIndex){
            return;
        }
        postOrder(2 * index);
        postOrder(2 * index + 1);
        System.out.print(arr[index] + " ");
    }

    // levelOrder Traversal
    public void levelOrder(){
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Search Method
    public int search(String value){
        for (int i = 0; i <= lastUsedIndex; i++) {
            if(Objects.equals(arr[i], value)){
                System.out.println(value + " exist at the location: " + i);
                return i;
            }
        }
        System.out.println("The value does not exist in BT");
        return -1;
    }

    // Delete Method
    public void delete(String value){
        int location = search(value);
        if(location == -1){
            return;
        } else {
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex--;
            System.out.print("The node successfully deleted ");
        }
    }

    public void deleteBT(){
        try {
            arr = null;
            System.out.println("The BT has been successfully deleted");
        } catch (Exception e) {
            System.out.println("There was an error deleting the tree");
        }
    }
}