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
    public void OnesDiceTest(){
        var diceHand = new DiceHand(new int[] {
                1,1,2,4,5
        });

        assertEquals(2,diceHand.getValue(DiceChoice.ONES) );
    }

    @Test
    public void ThreeDiceTest(){
        var diceHand = new DiceHand(new int[]{
                3,2,2,3,5,4
        });

        assertEquals(6, diceHand.getValue(DiceChoice.THREEOFAKIND) );
    }

}

