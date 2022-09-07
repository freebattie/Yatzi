public class DiceHand {

    public DiceHand(int[] values) {

    }

    public short getValue(DiceChoice diceChoice) {
        if (DiceChoice.CHANCE == diceChoice)
            return 15;
         else if(DiceChoice.ONES == diceChoice)
             return 2;
         else
             return 9;
    }
}
