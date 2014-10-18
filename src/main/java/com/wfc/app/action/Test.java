package com.wfc.app.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by wangfengchen on 14/10/17.
 */
public class Test {


    public static void main(String args[]){
//        List<String> list = new ArrayList<>();
//        list.add("hello");
//        list.add("world!");
//        list.forEach(System.out::println);
//        list.stream().map(String::toUpperCase).forEach(System.out::print);
//        String name = Thread.currentThread().getName();
//        System.out.println(name);
//        new Test().test();
//        new Test().get("123").ifPresent(System.out::println);
//        new Test().get(null).ifPresent(System.out::println);
//        Collections.sort(list, (a, b) -> b.compareTo(a));
        new Test().test(Integer::valueOf);
    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    void test(){
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

        new Thread(()-> {
            String name = Thread.currentThread().getName();
            System.out.println(name);
        }).start();

        Function<String, Integer> toInteger = Integer::valueOf;

        Supplier<Test> personSupplier = Test::new;
        personSupplier.get();   // new Person
    }

    Optional<String> get(String s){
        return Optional.ofNullable(s);
    }

    void test(Converter<String,Integer> converter){
        String a = "123";
        Integer i = converter.convert(a);
        Integer i1 = 456;
        System.out.print(i+i1);
    }
}
