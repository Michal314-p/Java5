package aplikacja_rmi.algorytmy;

import java.util.ArrayList;
import java.util.Collections;

public class NewQuick {

    float partition(ArrayList<Integer> list, int first, int last)
    {
        int pivot = list.get(last);
        int i = (first-1);
        for (int j = first; j < last; j++) {
            if (list.get(j) <= pivot) {
                i++;
                Collections.swap(list,i,j);
            }
        }
        Collections.swap(list,i+1,last);
        return i+1;
    }

    void quick_sort(ArrayList<Integer> list, int first, int last)
    {
        if (first < last)
        {
            int partitionIndex = (int) partition(list, first, last);

            quick_sort(list, first, partitionIndex-1);
            quick_sort(list, partitionIndex+1, last);
        }
    }

    public ArrayList<Integer> solve1(ArrayList<Integer> list)
    {
        quick_sort(list,0,list.size()-1);
        return list;
    }
}
