package ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Masive {
    public static void main(String[] args) {
        List<Integer> x = new LinkedList<>();
        List<Integer> y = new ArrayList<>();
        timeCheck(x);
        timeCheck(y);

    }
    private static void timeCheck(List<Integer> list){
        for (int i = 0; i<111111; i++){
            list.add(i);
            list.add(1,6);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i<111111; i++){
            list.get(i);
        }

        long end = System.currentTimeMillis();

        System.out.println(end-start);

    }
}

