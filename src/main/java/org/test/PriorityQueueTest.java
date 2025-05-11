package org.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Person> pq = new PriorityQueue<>((o1, o2) -> o1.age - o2.age);
        pq.add(new Person(18, "张三"));
        pq.add(new Person(20, "李四"));
        pq.add(new Person(19, "王五"));
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }


    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

    }
}
