import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by Jun on 10/21/2014.
 * http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String a = "aaaa";
        String b = "testtextforaaaaaaaaaaaaaaa";
        String c = "abcdedcba";
        new LongestPalindromicSubstring().palindromic(b);
//        new LongestPalindromicSubstring().palindromic(a);
    }



    private int palindromic(String text) {
        if(null == text || text.length() == 0){
            return -1;
        }else if(text.length() < 2){
            return 1; // assume empty string is polindromic
        }
        Hashtable<Integer, ArrayList<Integer>> palindromes = new Hashtable<Integer, ArrayList<Integer>>(); //tail -> heads
//        Hashtable<Character, Integer> charLocation = new Hashtable<Character, Integer>();
        ArrayList<Character> chars = new ArrayList<Character>();
        int max = 1;
        int start = 0;
        int end = 1;

        //special case
        //get chars
        palindromes.put(0,new ArrayList<Integer>(Arrays.asList(0)));
        chars.add(text.charAt(0));
        for(int i=1; i<text.length(); i++){
            System.out.println("i =" +i + "\n");
            chars.add(text.charAt(i));
            ArrayList<Integer> heads = new ArrayList<Integer>();
//            heads.clear();
//            heads.add(i-1);
            for(Integer j : palindromes.get(i-1)){
                System.out.println("j = " + j + "\n");
                if(chars.get(i).equals(chars.get(j)) ) {
                    System.out.println("get one \n");
                    if(j == 0) {
                        heads.add(0);
                    } else {
                        heads.add(j-1);
                    }
                    System.out.println("new length :" + (i +1 - heads.get(heads.size() - 1)));
                    if(max < (i +1 - heads.get(heads.size() - 1))) {
                        System.out.println(" increase \n");
                        max = i +1 - heads.get(heads.size() - 1);
                        start = (heads.get(heads.size() - 1) + 1 > 0) ? heads.get(heads.size() - 1) - 1 : 0 ;
                        end = i+1;
                    }
//                    break;
                }
            }
            heads.add(i-1);
            System.out.println("heads" + heads);
            palindromes.put(i, heads);
        }
        System.out.println("longest palin of " + text + " is ["+text.substring(start,end) + "] from " + start + " to " + end + "\n");
        return max;
    }
}

/**
 * added uni-length palin ends at prior index
 *
 * check if the prior index is a palin
 *
 * check if its head is the same with the current
 *       add new if yes
 *
 *       modify max if needed
 *
 *        ArrayList<Integer>  newPalin = new ArrayList<Integer>();
 newPalin.add(i);
 //if the char before the head of the shorter palin is the same with new char, gets a longer palin
 for(Integer j : palindromes.get(i-1)){
 //                if(chars.get(j-1).equals(chars.get(i))){
 ////                    newPalin.add(j-1);
 //                }
 if( (i - j +1) > maxLength){
 maxLength = i-j+1;
 }
 }
 palindromes.put(j,newPalin);
 */
