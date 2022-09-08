package no.kristiania.Test;


import no.kristiania.Yatzy.DiceHand;
import no.kristiania.Yatzy.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class YatziTest {
    @Test
    public void RandomDiceTest(){
        var diceHand = new DiceHand(new int[] {
                1,2,3,4,5
        });

        assertEquals(15,diceHand.getMaxTotalForDiceChoice(Type.CHANCE) );
    }
    @Test
    public void ThreeOfAKindTest() {
        var diceHand = new DiceHand(new int[]{
                2, 2, 2, 4, 4
        });
        assertEquals(6,diceHand.getMaxTotalForDiceChoice(Type.THREEOFAKIND) );
    }
    @Test
    public void ThreeOfAKindFailTest() {
        var diceHand = new DiceHand(new int[]{
                2, 2, 0, 4, 4
        });
        assertEquals(0,diceHand.getMaxTotalForDiceChoice(Type.THREEOFAKIND) );
    }
    @Test
    public void FourOfAKindTest() {
        var diceHand = new DiceHand(new int[]{
                2, 2, 2, 2, 4
        });
        assertEquals(8,diceHand.getMaxTotalForDiceChoice(Type.FOUROFAKIND) );
    }
    @Test
    public void OnesDiceTest(){
        var diceHand = new DiceHand(new int[] {
                1,1,2,4,5
        });

        assertEquals(2,diceHand.getMaxTotalForDiceChoice(Type.ONES) );
    }
    @Test
    public void testStaticClass(){
    var test = new Type();

        assert (test instanceof Type);
    }
    @Test
    public void TwoDiceTest(){
        var diceHand = new DiceHand(new int[] {
                1,2,2,4,5
        });

        assertEquals(4,diceHand.getMaxTotalForDiceChoice(Type.TWOS) );
    }
    @Test
    public void ThreesDiceTest(){
        var diceHand = new DiceHand(new int[] {
                3,3,3,3,3
        });

        assertEquals(15,diceHand.getMaxTotalForDiceChoice(Type.THREES) );
    }
    @Test
    public void FoursDiceTest(){
        var diceHand = new DiceHand(new int[] {
                4,3,3,4,4
        });

        assertEquals(12,diceHand.getMaxTotalForDiceChoice(Type.FOURS) );
    }
    @Test
    public void FivesDiceTest(){
        var diceHand = new DiceHand(new int[] {
                4,3,5,5,5
        });

        assertEquals(15,diceHand.getMaxTotalForDiceChoice(Type.FIVES) );
    }
    @Test
    public void SixesDiceTest(){
        var diceHand = new DiceHand(new int[] {
                4,6,6,4,3
        });

        assertEquals(12,diceHand.getMaxTotalForDiceChoice(Type.SIXES) );
    }
    @Test
    public void bestPairScoreTest(){
        var diceHand = new DiceHand(new int[] {
                2,2,3,3,4
        });

        assertEquals(6,diceHand.getMaxTotalForDiceChoice(Type.ONEPAIR) );
    }
    @Test
    public void bestThreeOfAKindScoreTest(){
        var diceHand = new DiceHand(new int[] {
                2,2,3,3,3
        });


        assertEquals(9,diceHand.getMaxTotalForDiceChoice(Type.THREEOFAKIND) );
    }
    @Test
    public void bestThreeOfAKindScoreFailTest(){
        var diceHand = new DiceHand(new int[] {
                2,2,1,3,3
        });


        assertEquals(0,diceHand.getMaxTotalForDiceChoice(Type.THREEOFAKIND) );
    }
    @Test
    public void bestTwoPairs(){
        var diceHand = new DiceHand(new int[] {
                2,2,5,4,4
        });


        assertEquals(12,diceHand.getMaxTotalForDiceChoice(Type.TWOPAIR) );
    }
    @Test
    public void bestTwoPairsFail(){
        var diceHand = new DiceHand(new int[] {
                2,1,5,4,4
        });


        assertEquals(0,diceHand.getMaxTotalForDiceChoice(Type.TWOPAIR) );
    }
    @Test
    public void checkForHouse(){
        var diceHand = new DiceHand(new int[] {
                2,2,4,4,4
        });
        assertEquals(16,diceHand.getMaxTotalForDiceChoice(Type.FULLHOUSE) );
    }
    @Test
    public void checkForHouseFail(){
        var diceHand = new DiceHand(new int[] {
                2,2,3,4,4
        });
        assertEquals(0,diceHand.getMaxTotalForDiceChoice(Type.FULLHOUSE) );
    }
    @Test
    public void checkForYatzy(){
        var diceHand = new DiceHand(new int[] {
                5,5,5,5,5
        });
        assertEquals(50,diceHand.getMaxTotalForDiceChoice(Type.YATZY) );
    }
    @Test
    public void checkForLowStright(){
        var diceHand = new DiceHand(new int[] {
                1,2,3,4,5
        });
        assertEquals(15,diceHand.getMaxTotalForDiceChoice(Type.STRIGHTLOW) );
    }
    @Test
    public void checkForLowStrightFail(){
        var diceHand = new DiceHand(new int[] {
                1,2,3,1,5
        });
        assertEquals(0,diceHand.getMaxTotalForDiceChoice(Type.STRIGHTLOW) );
    }
    @Test
    public void checkForHighStright(){
        var diceHand = new DiceHand(new int[] {
                2,3,4,5,6
        });
        assertEquals(20,diceHand.getMaxTotalForDiceChoice(Type.STRIGHTHIGH) );
    }

}

