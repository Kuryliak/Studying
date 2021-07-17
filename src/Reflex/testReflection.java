package Reflex;

import java.lang.reflect.Method;
import java.util.Arrays;

@author(name = "ROMAN", dataOfCreation = 2222)
public class testReflection {
    public static void main(String[] args) {
        Class personClass = Person.class;
        Method[] method = personClass.getMethods();

        for (Method method1 : method) {
            System.out.println(method1.getName()
                    + "," + method1.getReturnType()
                    + "," + Arrays.toString(method1.getParameterTypes()));
        }
    }
}
