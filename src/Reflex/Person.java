package Reflex;
@author(name = "Roman",dataOfCreation = 2026)
public class Person {
    private String name;
    private int id;

    public Person() {
        name = "no name";
        id = -1;
    }
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void sayHello(){
        System.out.println("hello from " +name +" with  id " +id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
