import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatziTest {
    @Test
    public void RandomDiceTest(){
        var diceHand = new DiceHand(new int[] {
                1,2,3,4,5
        });

        assertEquals(15,diceHand.getMaxTotalForDiceChoice(DiceChoice.CHANCE) );
    }
    @Test
    public void ThreeOfAKindTest() {
        var diceHand = new DiceHand(new int[]{
                2, 2, 2, 4, 4
        });
    }
    @Test
    public void OnesDiceTest(){
        var diceHand = new DiceHand(new int[] {
                1,1,2,4,5
        });

        assertEquals(2,diceHand.getMaxTotalForDiceChoice(DiceChoice.ONES) );
    }
    @Test
    public void TwoDiceTest(){
        var diceHand = new DiceHand(new int[] {
                1,2,2,4,5
        });

        assertEquals(4,diceHand.getMaxTotalForDiceChoice(DiceChoice.TWOS) );
    }
    @Test
    public void ThreesDiceTest(){
        var diceHand = new DiceHand(new int[] {
                3,3,3,3,3
        });

        assertEquals(15,diceHand.getMaxTotalForDiceChoice(DiceChoice.THREES) );
    }
    @Test
    public void bestPairScoreTest(){
        var diceHand = new DiceHand(new int[] {
                2,2,3,3,4
        });

        assertEquals(6,diceHand.getMaxTotalForDiceChoice(DiceChoice.ONEPAIR) );
    }
    @Test
    public void bestThreeOfAKindScoreTest(){
        var diceHand = new DiceHand(new int[] {
                2,2,3,3,3
        });


        assertEquals(9,diceHand.getMaxTotalForDiceChoice(DiceChoice.THREEOFAKIND) );
    }
    @Test
    public void bestTwoPairs(){
        var diceHand = new DiceHand(new int[] {
                2,2,5,4,4
        });


        assertEquals(12,diceHand.getMaxTotalForDiceChoice(DiceChoice.TWOPAIR) );
    }
    @Test
    public void checkForHouse(){
        var diceHand = new DiceHand(new int[] {
                2,2,4,4,4
        });
        assertEquals(16,diceHand.getMaxTotalForDiceChoice(DiceChoice.HOUSE) );
    }
    @Test
    public void checkForYatzy(){
        var diceHand = new DiceHand(new int[] {
                5,5,5,5,5
        });
        assertEquals(50,diceHand.getMaxTotalForDiceChoice(DiceChoice.YATZY) );
    }

}

