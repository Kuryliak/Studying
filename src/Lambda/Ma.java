package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ma {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int[] x = new int[10];
        int[] x2 = new int[10];

        filList(list);
        fillMassive(x);


        System.out.println(Arrays.toString(x));
        System.out.println(list);

        x = Arrays.stream(x).map(a -> a * 5).toArray();
        list = list.stream().map(b -> b * 5).collect(Collectors.toList());

        System.out.println(Arrays.toString(x));
        System.out.println(list);

        filList2(list2);
        fillMassive2(x2);
        System.out.println(Arrays.toString(x2));
        System.out.println(list2);

        x2 = Arrays.stream(x2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println(Arrays.toString(x2));
        System.out.println(list2);


        Arrays.stream(x2).forEach(a -> System.out.println(a));
        list2.stream().forEach(System.out::println);

    }

    private static void filList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void filList2(List<Integer> list2) {
        for (int i = 0; i < 10; i++) {
            list2.add(i + 1);
        }
    }

    private static void fillMassive(int[] x) {
        for (int i = 0; i < 10; i++)
            x[i] = i + 1;


    }


    private static void fillMassive2(int[] x2) {
        for (int i = 0; i < 10; i++)
            x2[i] = i + 1;
    }
}
