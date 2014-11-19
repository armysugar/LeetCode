package trees;

import java.util.*;

/**
 * Created by Jun on 11/13/2014.
 */
public class BinarySearchTree <T extends Comparable<T>> {
    T data;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(){}
    public BinarySearchTree(T t){
        this.data = t;
        left = right = null;
    }

    public BinarySearchTree(BinarySearchTree<T> tree){
        if(null == tree){
            return;
        }
        this.data = tree.data;
        if(tree.left != null){
            this.left = new BinarySearchTree(tree.left);
        }else {
            this.left = null;
        }
        if(tree.right != null){
            this.right = new BinarySearchTree(tree.right);
        }else {
            this.right = null;
        }
//        this.right = new BinarySearchTree(tree.right);
    }
    public BinarySearchTree(Collection<T> col){
        Iterator<T> it = col.iterator();
        while (it.hasNext()){
            this.add(it.next());
        }

    }

    public BinarySearchTree add(T t){
        if(this.data == null){
            this.data = t;
        }else if(this.data.compareTo(t)>=0){//if the new node is small, put it into the left subtree
            if(this.left != null){
                this.left.add(t);
            }else {
                this.left = new BinarySearchTree(t);
            }

        }else {                            //if the new node is big, put it into the right subtree
            if(this.right != null){
                this.right.add(t);
            }else {
                this.right = new BinarySearchTree(t);
            }
        }
        return this;
    }

    public String toString(){
        int hight = 0;
        ArrayList<BinarySearchTree> arr = new ArrayList<BinarySearchTree>();
        String tree = this.data.toString();
        arr.add(this.left);
        arr.add(this.right);
        while (!arr.isEmpty()){
            if(arr.get(0).left != null) {
                arr.add(arr.get(0).left);
            }
            if(arr.get(0).right != null) {
                arr.add(arr.get(0).right);
            }
            tree = tree + " " + arr.get(0).data.toString();
            arr.remove(0);
        }
        return tree;
    }
}
