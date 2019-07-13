package com.obss.generics.review;

import java.util.ArrayList;
import java.util.List;

public class TeacherTest {

    public static void main(String[] args) {
        List<Teacher> list = new ArrayList<>();

        list.add(new EnglishTeacher());
        list.add(new SpanishTeacher());

        for (Teacher teacher : list) {
            teacher.talk();
        }
    }


    public interface Teacher {
        void talk();
    }

    public static class EnglishTeacher implements Teacher {

        @Override
        public void talk() {
            System.out.println("I'm English Teacher. Hello!");
        }
    }

    public static class SpanishTeacher implements Teacher {

        @Override
        public void talk() {
            System.out.println("I'm Spanish Teacher. Hola!");
        }
    }
}
