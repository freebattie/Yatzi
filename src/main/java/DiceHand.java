import java.util.HashMap;

public class DiceHand {

    private HashMap<Integer, Integer> diceFrequency;

    public DiceHand(int[] dies) {

        this.diceFrequency = getFrequencyOfDices(dies);
    }

    public int getMaxTotalForDiceChoice(DiceChoice diceChoice) {

        Integer score = 0;

        //Here we check for number of 1s,2s,3s etc
        switch (diceChoice) {
            case ONES:
                score = diceFrequency.get(1);
                break;
            case TWOS:
                score = diceFrequency.get(2) * 2;
                break;
            case THREES:
                score = diceFrequency.get(3) * 3;
                break;
            case FOURS:
                score = diceFrequency.get(4) * 4;
                break;
            case FIVES:
                score = diceFrequency.get(5) * 5;
                break;
            case SIXES:
                score = diceFrequency.get(6) * 6;
                break;
            case ONEPAIR:
                score = getMaxScoreOfGivenFrequency(diceFrequency, 2);
                break;
            case TWOPAIR:
                score = getBestTwoPairScore();
                break;
            case THREEOFAKIND:
                score = getMaxScoreOfGivenFrequency(diceFrequency, 3);
                break;
            case HOUSE:
                score = getFullHouseScore();
                break;
            case STRAIGHTSMALL:
                score = getStraightLowScore(diceFrequency, new int[]{1, 2, 3, 4, 5});
                break;
            case STRAIGHTBIG:
                score = getStraightLowScore(diceFrequency, new int[]{2, 3, 4, 5, 6});
                break;
            case FOREOFAKIND:
                score = getMaxScoreOfGivenFrequency(diceFrequency, 4);
                break;
            case CHANCE:
                score = getChanceTotalScore();
                break;
            case YATZY:
                score = getYatzyScore(diceFrequency, 5);
                break;
            default:
                return 0;
        }

        if (score == null)
            return 0;
        else
            return score.intValue();


    }

    private Integer getChanceTotalScore() {
        Integer score;
        int maxvalue = 0;
        for ( var set :  diceFrequency.entrySet()){
            maxvalue += set.getKey() * set.getValue();
        }
        score = maxvalue;
        return score;
    }

    private Integer getFullHouseScore() {
        Integer score;
        var maxValue= getMaxScoreOfGivenFrequency(diceFrequency, 3);
        int maxValue2 = getMaxScoreOfGivenFrequency(diceFrequency, 2);

        if (maxValue2  < 0 || maxValue <0)
            return null;
        else
            score = maxValue + maxValue2;
        return score;
    }

    private Integer getBestTwoPairScore() {
        Integer score;
        var maxValue= getMaxScoreOfGivenFrequency(diceFrequency, 2);
        int maxValue2 = getMaxScoreOfGivenFrequency(diceFrequency, 2);

        if (maxValue2  < 0 || maxValue <0)
            return null;
        else
            score = maxValue + maxValue2;
        return score;
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
    private int getYatzyScore(HashMap<Integer, Integer> diceFrequency, int frequency) {

        for (var key  : diceFrequency.keySet()){

            if (diceFrequency.get(key) >= frequency) {

                diceFrequency.remove(key);
                return 50;
            }
        }

        return 0;
    }
    private int getStraightLowScore(HashMap<Integer, Integer> diceFrequency, int [] straight) {
        int totalPoints = 0;
        for (var val :straight ){
            if (!diceFrequency.containsKey(val))
                return 0;
            else
                totalPoints +=  val;
        }


        return totalPoints;
    }
}
