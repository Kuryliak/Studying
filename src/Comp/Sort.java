package Comp;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Set<Person> personSet = new TreeSet<>();
        addUser(personList);
        addUser(personSet);

        Collections.sort(personList);

        System.out.println(personList);

    }
    private static void addUser(Collection collection){
        collection.add(new Person(17,"abab"));
        collection.add(new Person(14,"bob"));
        collection.add(new Person(50,"nick"));

    }
}
  class  Person implements Comparable<Person>{
      private int age;
      private String name;

      @Override
      public String toString() {
          final StringBuilder sb = new StringBuilder("Person{");
          sb.append("name='").append(name).append('\'');
          sb.append(", age=").append(age);
          sb.append('}');
          return sb.toString();
      }

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;

          Person person = (Person) o;

          if (age != person.age) return false;
          return name != null ? name.equals(person.name) : person.name == null;
      }

      @Override
      public int hashCode() {
          int result = name != null ? name.hashCode() : 0;
          result = 31 * result + age;
          return result;
      }

      public int getAge() {
          return age;
      }

      public Person(int age,String name) {
          this.age = age;
          this.name = name;
      }

      @Override
      public int compareTo(Person o) {
          if (this.age > o.getAge()){
              return 1;
          }else if (this.age < o.getAge()){
              return -1;
          }else return 0;
      }
  }