package org.ktz.example.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {
    @Test
    public void classType() throws Exception {
        Integer n = 10;
        Class<? extends Integer> k = n.getClass();
        int[] hello = {1,2,3};
        System.out.println(hello.toString());
    }

    public static class Foo {
        public Foo(){}

        public void printHello() {
            System.out.println("Hello");
        }
    }

    @Test
    public void instanceWithType() throws Exception {
        List<Integer> foo = newT(ArrayList.class);
        foo.add(1);
        System.out.println(foo.get(0));
    }

    public <T> T newT(Class<T> a) throws Exception {
        return a.newInstance();
    }
}
