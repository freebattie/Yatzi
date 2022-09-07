import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;

public class DiceHand {

    private int[] dies;

    public DiceHand(int[] dies) {

        this.dies = dies;
    }

    public int getValue(DiceChoice diceChoice) {
        HashMap<Integer, Integer> valueOfEachDie = new HashMap<Integer, Integer>();

        for (int die : dies) {

            if (!valueOfEachDie.containsKey(die))
                valueOfEachDie.put(die,1);
            else
                valueOfEachDie.put(die,valueOfEachDie.get(die) + 1);
        }

        for (var key  : valueOfEachDie.keySet()){

        }
        if (diceChoice == DiceChoice.CHANCE){
            return 15;
        }
        // [2,2,3,1,5]
        if (diceChoice == DiceChoice.ONES)
            return valueOfEachDie.get(1);
        if (diceChoice == DiceChoice.TWOS)
            return valueOfEachDie.get(2)*  2;
        if (diceChoice == DiceChoice.THREES)
            return valueOfEachDie.get(3)*  3;
        if (diceChoice == DiceChoice.FOURS)
            return valueOfEachDie.get(4)*  4;
        if (diceChoice == DiceChoice.FIVES)
            return valueOfEachDie.get(5)*  5;
        if (diceChoice == DiceChoice.SIXES)
            return valueOfEachDie.get(6)*  6;
        else
            return 0;

    }
}
