package CSE101;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter a word: ");
        Scanner input = new Scanner(System.in);
        String word = input.next();
        System.out.println("The word "+word+" is "+ (isPalindrome(word) ? "":"not ")+"palindrome");
        System.out.println("The word "+word+" is "+ (isPalindrome1(word) ? "":"not ")+"palindrome");

    }
    public static boolean isPalindrome(String word){
        word = word.toLowerCase();
        if (word.length() <= 1)
            return true;
        else return (word.charAt(0) == word.charAt(word.length()-1) &&
                isPalindrome(word.substring(1,word.length()-1)));
    }
    //Same method in a more efficient way with helper method...
    public static boolean isPalindrome1(String s){
        s = s.toLowerCase();
        return isPalindrome1(s, 0, s.length()-1);
    }
    private static boolean isPalindrome1(String s,int low, int high){
        if (high <= low)
            return true;
        else if (s.charAt(low) != s.charAt(high))
            return false;
        else return isPalindrome1(s, s.charAt(low+1), s.charAt(high-1));
    }
}
