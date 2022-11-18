package ba.unsa.etf.rpr;

import java.util.*;


public class App 
{
    /**
     * main metoda nam uzima upis s konzole,poziva metodu za provjerava validons upisa tj. ProvjeraUlaza
     * i poziva metodu evaluate
     */
    public static void main( String[] args ) throws RuntimeException {



        Scanner in= new Scanner(System.in);
        String ulaz;
        ulaz=in.nextLine();

        try{
            Provjera.ProvjeraUlaua(ulaz);
            double raz = ExpressionEvaluator.evaluate(ulaz);
            System.out.println(raz);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}
