package aplikacja_rmi.algorytmy;

import java.io.Serializable;
import java.util.ArrayList;

public class NewInsert implements Serializable
{
    public ArrayList<Integer> solve1(ArrayList<Integer> list)
    {
        for (int i =1;i<list.size();++i)
        {
            int current=list.get(i);
            int step;
            for(step=i-1;step>-1 && list.get(step)>current;step--)
            {
                list.set(step+1,list.get(step));
            }
            list.set(step+1,current);
        }
        return list;
    }
}
