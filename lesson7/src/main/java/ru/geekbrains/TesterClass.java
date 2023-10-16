package ru.geekbrains;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class TesterClass {

    public static void start(Class TestClass) throws Exception {

        ArrayList<Method> methodsBS = new ArrayList<>();
        for (Method m : TestClass.getDeclaredMethods()){
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                m.setAccessible(true);
                methodsBS.add(m);
            }
            if (methodsBS.size() > 1)
                throw new RuntimeException("Class has more than 1 method with annotation @BeforeSuite");
        }

        ArrayList<Method> methodsAS = new ArrayList<>();
        for (Method m : TestClass.getDeclaredMethods()){
            if (m.isAnnotationPresent(AfterSuite.class)) {
                m.setAccessible(true);
                methodsAS.add(m);
            }
            if (methodsAS.size() > 1)
                throw new RuntimeException("Class has more than 1 method with annotation @AfterSuite");
        }


        ArrayList<Method> methodsT = new ArrayList<>();
        for (Method m : TestClass.getDeclaredMethods()){
            if (m.isAnnotationPresent(Test.class)) {
                m.setAccessible(true);
                if (m.getAnnotation(Test.class).order() < 1 || m.getAnnotation(Test.class).order() > 10){
                    throw new RuntimeException("@Test value should be in the range 1-10");
                }
                methodsT.add(m);
            }
        }

//        Collections.sort(methodsT, (first, second) ->
//                (first.getAnnotation(Test.class).order() - second.getAnnotation(Test.class).order()));

//        Collections.sort(methodsT, Comparator.comparing(Method.getAnnotation::order);
//        Collections.sort(methodsT, Comparator.comparing(Method::getAnnotation,
//                  (s, t) -> Integer.compare(s.order(), t.order())));
        Collections.sort(methodsT, Comparator.comparingInt(
                  m -> m.getAnnotation(Test.class).order()));



        for(Method m : methodsBS) m.invoke(TestClass.newInstance());
        for(Method m : methodsT) m.invoke(TestClass.newInstance());
        for(Method m : methodsAS) m.invoke(TestClass.newInstance());











    }
}
