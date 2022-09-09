package no.kristiania.Yatzy;

import java.util.HashMap;

public class DiceHand {

    private HashMap<Integer, Integer> dicesFrequency;

    public DiceHand(int[] dies) {
        this.dicesFrequency = getFrequencyOfDices(dies);
    }

    public int getMaxTotalForDiceChoice(int diceChoice) {
        int[] LOWSTRAIGHT =  new int[]{1, 2, 3, 4, 5};
        int[] HIGHSTRAIGHT =  new int[]{2, 3, 4, 5, 6};

        return switch (diceChoice) {
            case Type.ONES, Type.TWOS, Type.THREES,
                 Type.FOURS, Type.FIVES,
                 Type.SIXES -> getDiceChoiceFrequency(diceChoice);
            case Type.ONEPAIR -> getMaxScoreOfGivenFrequency(dicesFrequency, 2);
            case Type.TWOPAIR -> getBestTwoPairScore();
            case Type.THREEOFAKIND -> getMaxScoreOfGivenFrequency(dicesFrequency, 3);
            case Type.FULLHOUSE -> getFullHouseScore();
            case Type.STRIGHTLOW -> getStraightScore(dicesFrequency,LOWSTRAIGHT );
            case Type.STRIGHTHIGH -> getStraightScore(dicesFrequency, HIGHSTRAIGHT);
            case Type.FOUROFAKIND -> getMaxScoreOfGivenFrequency(dicesFrequency, 4);
            case Type.CHANCE -> getChanceTotalScore();
            case Type.YATZY -> getYatzyScore(dicesFrequency, 5);
            default -> 0;
        };

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
    private int getDiceChoiceFrequency(int diceValue) {

        if (dicesFrequency.containsKey(diceValue))
            return  dicesFrequency.get(diceValue) *diceValue;
        else
            return 0;
    }
    private int getMaxScoreOfGivenFrequency(HashMap<Integer, Integer> diceFrequency, int frequency) {

        int maxValue = 0;
        int maxKey = 0;
        for (var key  : diceFrequency.keySet()){

            if (diceFrequency.get(key) >= frequency) {
                if (key * frequency > maxValue){
                    maxValue = key * frequency;
                    maxKey = key;
                }
            }
        }

        diceFrequency.remove(maxKey);
        return maxValue;
    }
    private Integer getBestTwoPairScore() {
        int score = 0;
        var maxValue= getMaxScoreOfGivenFrequency(dicesFrequency, 2);
        var maxValue2 = getMaxScoreOfGivenFrequency(dicesFrequency, 2);

        if (maxValue <= 0 || maxValue2 <= 0)
            score = 0;
        else
            score = maxValue + maxValue2;

        return score;
    }
    private Integer getFullHouseScore() {
        int score;
        var maxValue= getMaxScoreOfGivenFrequency(dicesFrequency, 3);
        var maxValue2 = getMaxScoreOfGivenFrequency(dicesFrequency, 2);

        if (maxValue <= 0 || maxValue2 <= 0)
            score = 0;
        else
            score = maxValue + maxValue2;

        return score;
    }
    private int getStraightScore(HashMap<Integer, Integer> diceFrequency, int [] straight) {
        int totalPoints = 0;

        for (var val :straight ){
            if (!diceFrequency.containsKey(val))
                return 0;
            else
                totalPoints +=  val;
        }

        return totalPoints;
    }
    private Integer getChanceTotalScore() {
        int maxvalue = 0;
        for ( var set :  dicesFrequency.entrySet())
            maxvalue += set.getKey() * set.getValue();

        return maxvalue;
    }
    private int getYatzyScore(HashMap<Integer, Integer> diceFrequency, int frequency) {

        for (var key  : diceFrequency.keySet()){

            if (diceFrequency.get(key) >= frequency) {

                diceFrequency.remove(key);
                return 50;
            }
        }

        return 0;
    }

}
