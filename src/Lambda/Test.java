package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        Set<Integer> integers = new TreeSet<>();
        integers.add(5);
        integers.add(54);
        integers.add(2);

        a.add("bo");
        a.add("bob");
        a.add("aoba");
        a.add("bboba");

        a.sort((s1, s2) -> {
            if (s1.length() > s2.length()) return 1;
            else if (s1.length() > s2.length()) return -1;
            else return 0;
        });


        System.out.println(a);
        System.out.println(integers);
    }
}




