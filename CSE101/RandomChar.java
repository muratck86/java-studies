package CSE101;

public class RandomChar {
    public static void main(String[] args) {
        char ch1 = getRandomChar();
        char ch2 = getRandomUpperCaseLetter2();
        char ch3 = getRandomDigit();
        char ch4 = getRandomCharBetween('k','m'); //including
        System.out.print("\nRandom Char : "+ch1+"\nRandom Upper Case Letter : "+ch2+"\nRandom Digit : "+ch3+"\nRandom Character Between : "+ch4);

    }
    //Generate a random character between c1 and ch2
    public static char getRandomCharBetween(char ch1, char ch2){
        char ch = (char) ( ch1 + Math.random()*(ch2-ch1+1));
        return ch;
    }
    //Generate a random uppercase letter Alt1
    public static char getRandomUpperCaseLetter(){
        return (char)('A'+Math.random()*('Z'-'A'+1));
    }
    //Generate a random uppercase letter Alt2
    public static char getRandomUpperCaseLetter2(){
        return getRandomCharBetween('A','Z');
    }
    //Generate a random digit character
    public static char getRandomDigit(){
        return getRandomCharBetween('0','9');
    }
    //Generate a random character
    public static char getRandomChar(){
        return getRandomCharBetween('\u0000','\uFFFF');
    }
    //Generate a random lowercase character
    public static char getRandomLowerCaseLetter(){return (char)('a'+Math.random()*('z'-'a'+1));}
}
