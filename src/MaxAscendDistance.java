import java.util.Stack;

/**
 * Created by Jun on 11/17/2014.
 * Given an array A of integers, find the maximum of j-i subjected to the constraint of A[i] < A[j].
 * http://leetcode.com/2011/05/a-distance-maximizing-problem.html
 */
public class MaxAscendDistance {
    public static void main(String[] args) {
        int[] test = {4,3,5,2,1,3,2,3};
        MaxAscendDistance max = new MaxAscendDistance();
        System.out.println(max.intArrayToSting(test));
        System.out.println("brute force: "+max.intArrayToSting(max.bruteForce(test)));
        System.out.println("tow descendig: " + max.intArrayToSting(max.twoDescending(test)));
    }

    private int[] maxDisByBinaryInsertionSort(int[] arr){
        int[] dup = arr;
        for(int i = 0; i < arr.length; i ++ ){

        }
        return dup;
    }

    /**
     * O(n^2) complexity
     * @param arr
     * @return
     */
    private int[] bruteForce(int[] arr){
        int[] indices = new int[2];
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(arr[i] > arr[j] && (i-j) > (indices[1] - indices[0])){
//                    System.out.println("i " + i + " j " + j + " arr[i]" + arr[i] + " arr[j] " + arr[j]);
                    indices[1] = i;
                    indices[0] = j;
                }
            }
        }
        return indices;
    }

    /**
     * O(n) complexity
     * @param arr
     * @return
     */
    private int[] twoDescending(int[] arr){
        if(arr.length < 2){
            return new int[] {0,0};
        }
        Stack<Integer> potentialHeads = new Stack<Integer>();
        potentialHeads.push(0);
        Stack<Integer> potentialTails = new Stack<Integer>();
        potentialTails.push(arr.length-1);

        //if some index is the i in max[j - i], it could have no number smaller than it before it
        //so all potential i's (heads) form a descending array from the start
        for (int i = 0; i < arr.length; i ++){
            if(arr[i] < arr[potentialHeads.peek()]){
                potentialHeads.push(i);
            }
        }

        //if some index is the j in max[j - i], it could have no number bigger than it after it
        //so all potential j's (heads) form a descending array ending with the end
        for (int j = arr.length -1; j >= 0; j--){
            if(arr[j] > arr[potentialTails.peek()]){
                potentialTails.push(j);
            }
        }
        potentialTails = reverse(potentialTails);

        System.out.println("heads:" + potentialHeads);
        System.out.println("tails:" + potentialTails);
        int[] indices = {-1, -1}; //dafault return value -- noting error
        while (true){
            //if the current head is
            if(arr[potentialHeads.peek()] < arr[potentialTails.peek()]){
                if( (potentialTails.peek() - potentialHeads.peek()) > (indices[1] - indices[0]) ){
                    indices = new int[] { potentialHeads.peek(), potentialTails.peek() };
                }
                //if the current far tail can handle the current head, give it a chance to take on larger heads
                if(potentialHeads.size() > 1){
                    System.out.println("tail pop: " + potentialHeads.pop()); // pop to evaluate smaller but latter numbers--when there are some
                }else{
                    System.out.println("head pop:"+potentialTails.pop());
                }
            }else {
                //if the current tail is not larger than the current head, use a larger tail
                if(potentialTails.size() > 1){
                    potentialTails.pop();
                }else {
                    break;
                }
            }
            if(potentialHeads.size() == 1 && potentialTails.size() == 1){
                break;
            }
        }
        if(arr[potentialHeads.peek()] < arr[potentialTails.peek()]) {
            if ((potentialTails.peek() - potentialHeads.peek()) > (indices[1] - indices[0])) {
                indices = new int[]{potentialHeads.peek(), potentialTails.peek()};
            }
        }
        return indices;

    }

    public int descends(Stack<Integer> s){
        if(s.size() < 2){
            return 0xffffffff; //if there's no more than 1, return the biggest int (infinity)
        }
        int diff = s.get(s.size()-1) - s.get(s.size()-2);
        return diff >=0 ? diff : -diff;
    }

    public String intArrayToSting(int[] arr){
        StringBuffer sb = new StringBuffer();
        for (int i : arr){
            sb.append(i+" ");
        }
        return sb.toString();
    }

    public Stack reverse(Stack s){
        Stack re = new Stack();
        while (!s.isEmpty()){
            re.push(s.pop());
        }
        return re;
    }
}
