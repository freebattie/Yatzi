import java.util.HashMap;

public class DiceHand {

    private HashMap<Integer, Integer> diceFrequency;

    public DiceHand(int[] dies) {

        this.diceFrequency = getFrequencyOfDices(dies);
    }

    public int getMaxTotalForDiceChoice(DiceChoice diceChoice) {

        if (diceChoice == DiceChoice.ONEPAIR ){
            return getMaxScoreOfGivenFrequency(diceFrequency, 2);
        }
        if (diceChoice == DiceChoice.THREEOFAKIND ){
            return getMaxScoreOfGivenFrequency(diceFrequency, 3);
        }
        if (diceChoice == DiceChoice.FOREOFAKIND ){
            return getMaxScoreOfGivenFrequency(diceFrequency, 4);
        }

        if (diceChoice == DiceChoice.CHANCE){
            int maxvalue = 0;
            for ( var set :  diceFrequency.entrySet()){
                maxvalue += set.getKey() * set.getValue();
            }
            return maxvalue;
        }
        //Here we check for number of 1s,2s,3s etc
        if (diceChoice == DiceChoice.ONES)
            return diceFrequency.get(1);
        if (diceChoice == DiceChoice.TWOS)
            return diceFrequency.get(2)*  2;
        if (diceChoice == DiceChoice.THREES)
            return diceFrequency.get(3)*  3;
        if (diceChoice == DiceChoice.FOURS)
            return diceFrequency.get(4)*  4;
        if (diceChoice == DiceChoice.FIVES)
            return diceFrequency.get(5)*  5;
        if (diceChoice == DiceChoice.SIXES)
            return diceFrequency.get(6)*  6;
        //Once code is done this should never happen.
        else
            return 0;


    }

    private HashMap<Integer, Integer> getFrequencyOfDices(int[] dies) {
        HashMap<Integer, Integer> valueOfEachDie = new HashMap();
        for (int die : dies) {

            if (!valueOfEachDie.containsKey(die))
                valueOfEachDie.put(die,1);
            else
                valueOfEachDie.put(die,valueOfEachDie.get(die) + 1);
        }
        return valueOfEachDie;
    }

    private int getMaxScoreOfGivenFrequency(HashMap<Integer, Integer> valueOfEachDie, int frequency) {

        int maxValue = -1;
        for (var key  : valueOfEachDie.keySet()){

            if (valueOfEachDie.get(key) >= frequency) {
                if (key * frequency > maxValue){
                    maxValue = key * frequency;
                }

            }
        }
        return maxValue;
    }
}
