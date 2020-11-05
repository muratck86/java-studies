package CSE101;

public class DeckOfCards {
    public static void main(String[] args) {
        int[] deck =new int[52];
        String[] suits = {"Spades","Hearts","Clubs","Diamonds"};
        String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

        //Initialize Cards...
        for (int i = 0; i < deck.length; i++)
            deck[i] = i;
        for (int s:deck)
            System.out.print(s+" ");

        //Shuffle the Cards...
        int temp;
        int index;
        for (int i = 0; i < deck.length; i++){
            index = (int)(Math.random()*deck.length);
            temp =deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
        //Print shuffled cards
        System.out.println();
        for (int s:deck)
            System.out.print(s+" ");

        //Display the first four cards...
        for (int i = 0;i<4;i++){
            String suit = suits[deck[i]/13];
            String rank = ranks[deck[i]%13];
            System.out.print("\n Card "+deck[i]+" :"+rank+" of "+suit);
        }



    }
}
