package CSE101;

public class CountLettersInArray {
    public static void main(String[] args) {
        //Create an array of 100 elements size and generate random chars for each
        char[] letters = new char[100];
        for (int a = 0 ; a<letters.length; a++)
            //letters[a] = (char) (Math.random()*('z'-'a')+'a');
            letters[a] = RandomChar.getRandomLowerCaseLetter();

        //Print chars
        for (char c:letters)
            System.out.print(c +"  ");
        System.out.println();

        //Count occurrence of letters in array
        int[] counts = countLetters(letters);

        //Display counts
        displayCounts(counts);
    }

    //Method returns a 26 element length array each index represents a lowercase letter and each element represents
    //count of that letter
    public static int[] countLetters(char[] charList){
        int [] counts = new int[26];
        for (int i = 0; i<charList.length; i++){
            //for assume charlist[i] is  lets say 'c'
            //and 'c' - 'a' is 2 so the counts[2] will be incremented because index of 2 represents c in line...
            counts[charList[i]-'a']++;
        }
        return counts;
    }
    public static void displayCounts(int[] counts){
        for (int i = 0;i < counts.length; i++)
            System.out.println(counts[i]+"     "+(char)(i+'a'));
    }


}
