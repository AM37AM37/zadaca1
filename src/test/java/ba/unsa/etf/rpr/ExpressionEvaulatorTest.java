package ba.unsa.etf.rpr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaulatorTest {

    /**
     * evaluate testovi provjeravaju ispravnost logike i izracunavanja
     * metode evaluate
     */

    @Test
    void evaluate1(){
        String s="( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(101,ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluate2(){
        String s="( 1 * ( ( 2 * 3 ) * ( 4 * 5 ) ) )";
        assertEquals(120,ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluate3(){
        String s="( 300 / ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(3,ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluate4(){
        String s="( ( 44 - 4 ) + ( 11 * 3 ) )";
        assertEquals(73,ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluate5(){
        String s="( 1 - ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(-99,ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluate6(){
        String s="( ( 44 - 4 ) / ( 11 * 3 ) )";
        assertEquals(1.2121212121212122,ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluate7(){
        String s="( ( sqrt625 ) / ( 5 * 1 ) )";
        assertEquals(5,ExpressionEvaluator.evaluate(s));
    }

    /**
     * testovi ProvjeraUlaza 1-3 provjravaju metodu za neispravne ulaze dok 4-6 za ispravne
     */


    @Test
    void ProvjeraUlaza1(){
        String s="( 1+ ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertThrows(RuntimeException.class, ()-> Provjera.ProvjeraUlaua(s));
    }

    @Test
    void ProvjeraUlaza2(){
        String s="( 1 + ( ( 2 + p ) * ( 4 * 5 ) ) )";
        assertThrows(RuntimeException.class, ()-> Provjera.ProvjeraUlaua(s));
    }

    @Test
    void ProvjeraUlaza3(){
        String s="( 1 + ( ( 2 + 3 ) *( 4 * 5 ) ) )";
        assertThrows(RuntimeException.class, ()-> Provjera.ProvjeraUlaua(s));
    }

    @Test
    void ProvjeraUlaza4(){
        String s="( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertTrue(Provjera.ProvjeraUlaua(s));
    }

    @Test
    void ProvjeraUlaza5(){
        String s="( ( sqrt625 ) / ( 5 * 1 ) )";
        assertTrue(Provjera.ProvjeraUlaua(s));
    }

    @Test
    void ProvjeraUlaza6(){
        String s="( 300 / ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertTrue(Provjera.ProvjeraUlaua(s));
    }



}
