package ba.unsa.etf.rpr;

public class Provjera {


    /**
     * metoda ProvjeraUlaza uzima elemenat po elemenat iz ulaznog stringa
     * i provjerava da li je validan, takodjer provjerava da li ima razmak izmedju
     * svakog elementa
     */
    public static boolean ProvjeraUlaua(String s) throws RuntimeException{
        int prov=1;
        for(int i=0;i<s.length();i++){
            char c;
            c = s.charAt(i);
            if(((c>39 && c<44)||(c==45 || c==91 || c==93 || c==123 || c==125 || c==36 || c==47)) && prov==1) {
                prov = 0;
            }
            else if (c>47 &&c<58){
                prov=0;
            }
            else if( c==' ' && prov==0) {
                prov = 1;
            }
            else if ((c=='s' || c=='q' || c=='r' || c=='t') && prov==1) {
                if (c == 't')
                    prov = 0;
            }
            else throw new RuntimeException("upis nije validan. problematicni znak je "+c+" na poziciji "+(i+1)+".");
        }
        return  true;
    }
}
