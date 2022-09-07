import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatziTest {
    @Test
    public void RandomDiceTest(){
        var diceHand = new DiceHand(new int[] {
                1,2,3,4,5
        });

        assertEquals(15,diceHand.getValue(DiceChoice.CHANCE) );
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

        assertEquals(2,diceHand.getValue(DiceChoice.ONES) );
    }
    @Test
    public void TwoDiceTest(){
        var diceHand = new DiceHand(new int[] {
                1,2,2,4,5
        });

        assertEquals(4,diceHand.getValue(DiceChoice.TWOS) );
    }
    @Test
    public void ThreesDiceTest(){
        var diceHand = new DiceHand(new int[] {
                3,3,3,3,3
        });

        assertEquals(15,diceHand.getValue(DiceChoice.THREES) );
    }
    @Test
    public void bestPairScoreTest(){
        var diceHand = new DiceHand(new int[] {
                2,2,3,3,4
        });

        assertEquals(6,diceHand.getValue(DiceChoice.ONEPAIR) );
    }
    @Test
    public void bestThreeOfAKindScoreTest(){
        var diceHand = new DiceHand(new int[] {
                2,2,3,3,3
        });


        assertEquals(9,diceHand.getValue(DiceChoice.THREEOFAKIND) );
    }

}

