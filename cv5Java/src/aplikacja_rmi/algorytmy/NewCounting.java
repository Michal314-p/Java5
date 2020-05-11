package aplikacja_rmi.algorytmy;

import java.io.Serializable;
import java.util.ArrayList;

public class NewCounting implements Serializable
{
    public ArrayList<Integer> solve1(ArrayList<Integer> list)
    {
        int maximum = 0;


        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)>maximum)
            {
                maximum = (int) list.get(i);
            }
        }

        int[] counter = new int[(int) (maximum+1)];
        for (int i = 0; i <= maximum; i++)
        {
            counter[i] = 0;
        }

        for(int i=0;i<list.size();i++)
        {
            counter[(int) list.get(i)] += 1;
        }


        for (int i=1; i<=maximum; i++)
        {
            counter[i] +=counter[i-1];
        }

        int[] sorted = new int[(int) (maximum+1)];
        String [] nam_sorted = new String[(int) (maximum+1)];
        for (int i = 0; i < list.size(); i++)
        {
            sorted[counter[(int) list.get(i)]-1] = (int) list.get(i);
            counter[(int) list.get(i)]--;
        }

        int put_element;
        for(int i=0;i<list.size();i++)
        {
            put_element =sorted[i];
            list.set(i,put_element);
        }
        return list;
    }
}
