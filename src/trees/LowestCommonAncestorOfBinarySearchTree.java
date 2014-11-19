package trees;

import java.util.ArrayList;

/**
 * Created by Jun on 11/13/2014.
 * Given a binary tree, find the lowest common ancestor of two given nodes in the tree
 * http://leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-i.html
 */
public class LowestCommonAncestorOfBinarySearchTree<T extends Comparable<T>> {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Integer[] ints = {3,5,1,6,2,0,8,7,4};
        arr.add(ints[0]);
        arr.add(ints[1]);
        arr.add(ints[2]);
        arr.add(ints[3]);
        arr.add(ints[4]);
        arr.add(ints[5]);
        arr.add(ints[6]);
        arr.add(ints[7]);
        arr.add(ints[8]);
        BinarySearchTree test1 = new BinarySearchTree(arr);
        LowestCommonAncestorOfBinarySearchTree lcaob = new LowestCommonAncestorOfBinarySearchTree();
        System.out.println(lcaob.lowestCommonAncestor(test1, 0, 6 ));

    }

    private T lowestCommonAncestor(BinarySearchTree<T> tree, T a, T b){
        if(tree == null){
            return null;
        }else if(tree.data.compareTo(a) >= 0 && tree.data.compareTo(b) <0){//if this is the point when a ad b "diverge", it is the lowest ancestor
            return tree.data;
        }else if(tree.data.compareTo(a) < 0 && tree.data.compareTo(b) >=0){//if this is the point when a ad b "diverge", it is the lowest ancestor
            return tree.data;
        }

        //other wise, find their lowest common ancestor in the propriate subtree
        if(tree.data.compareTo(a) > 0){
            return lowestCommonAncestor(tree.left, a, b);
        }else {
            return lowestCommonAncestor(tree.right, a, b);
        }
//        lowestCommonAncestor()
    }

}
