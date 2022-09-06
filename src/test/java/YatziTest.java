import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatziTest {
    @Test
    public void RandomDiceTest(){
        var diceHand = new DiceHand(new Dice[] {
                new Dice(6),
                new Dice(3),
                new Dice(3),
                new Dice(2),
                new Dice(1)
        }, DiceChoice.CHANCE);

        assertEquals(diceHand.getValue(), 15);
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

