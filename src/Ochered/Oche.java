package Ochered;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Oche {
    public static void main(String[] args) {
        Person person5 = new Person(27);
        Person person2 = new Person(2);
        Person person45 = new Person(5);
        Person person445 = new Person(5);
        Person person5445 = new Person(5);
        Person person = new Person(1);
        Person person23 = new Person(24);

         Queue<Person> personQueue = new ArrayBlockingQueue<Person>(5);
          personQueue.offer(person2);
          personQueue.offer(person23);
          personQueue.offer(person45);
          personQueue.offer(person5445);
          personQueue.offer(person5445);
         System.out.println(personQueue);
          }
    }
class Person{
    private int age;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public Person(int age) {
        this.age = age;
    }
}

