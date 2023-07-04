package lk.ijse.dep10.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Calendar;

public class AppInitializer {
    public static void main(String[] args) {
        B bInstance = new B();
        Class<? extends B> bClassObj = bInstance.getClass();
        Type genericSuperclass = bClassObj.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        Type firstType = parameterizedType.getActualTypeArguments()[1];
        Class<Integer> integerClass = (Class<Integer>) firstType;
        System.out.println(integerClass);

        System.out.println((Class<Integer>)((ParameterizedType)(new B().getClass().getGenericSuperclass())).getActualTypeArguments()[1]);
    }
}

class A<T, K, V> {
}

class B extends A<String, Integer, Calendar> {
}

