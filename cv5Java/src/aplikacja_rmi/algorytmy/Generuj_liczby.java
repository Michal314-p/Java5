package aplikacja_rmi.algorytmy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generuj_liczby implements Serializable
{

    public static List<Integer> losuj_inty(int ilosc, int min, int max)
    {
        List<Integer> dane = new ArrayList<>();
        Random generowanie = new Random();
        for (int i=0; i<ilosc; i++)
        {
            int wartosc = generowanie.nextInt(max-min+1)+min;
            dane.add(wartosc);
        }

        return dane;
    }


}
