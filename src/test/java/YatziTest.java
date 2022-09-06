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


/*    @Test
    public void DicePairTest(){
        var diceHand = new DiceHand(new Dice[] {
                new Dice(6),
                new Dice(2),
                new Dice(1),
                new Dice(1),
                new Dice(5)
        }, DiceChoice.ONES);

        assertEquals(diceHand.getValue(), 2);
    }*/
}

