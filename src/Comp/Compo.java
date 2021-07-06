package Comp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compo {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("cat");
        animals.add("ba");
        animals.add("qe");
        animals.add("fr");
        Collections.sort(animals,new StringLenghtComporator());
        System.out.println(animals);

        List<Integer> nums  = new ArrayList<>();
        nums.add(133);
        nums.add(12);
        nums.add(3);
        nums.add(34);

        Collections.sort(nums,new BackwardsIntComporator());
        System.out.println(nums);

    }
}
