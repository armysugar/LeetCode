/**
 * Created by Jun on 11/17/2014.
 * Reverse bits of an unsigned integer.
 * http://leetcode.com/2011/08/reverse-bits.html
 */
public class BitsReversion {
    public static void main(String[] args) {
        int test = 3;
        System.out.println("origin: " + Integer.toBinaryString(test));

        BitsReversion reverser = new BitsReversion();
        System.out.println("revsersion: " +Integer.toBinaryString(reverser.reverIntBits(test)));
    }

    public int reverIntBits(int v){
        int reversion = 0;
        for(int i = 0; i < Integer.SIZE; i++){
            reversion = reversion * 2 + v%2;
            v = v /2;
        }
        return reversion;
    }

}
