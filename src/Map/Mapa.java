package Map;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Mapa {
    public static void main(String[] args) {
        Map<String,String> hash = new HashMap<>();
        hash.put("iteration", "account already exist");
        hash.put("qwe","account already exist");
        hash.put("23", "account already exist");


        Map<String,String> sash = new TreeMap<>();
        sash.put("iteration", "account already exist");
        sash.put("qwe","cccount already exist");
        sash.put("23", "d   ccount already exist");


        for (Map.Entry<String, String> entry : hash.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (Map.Entry<String, String> entry : sash.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        Set<Integer> mow = new HashSet<>();
         mow.add(1);
         mow.add(2);
         mow.add(3);
         Set<Integer> ab = new HashSet<>();
         mow.add(1);
         mow.add(2);
         mow.add(3);
         mow.add(4);

         Set<Integer> bb = new HashSet<>(mow);
          bb.addAll(ab);

        System.out.println(bb);
    }
}


