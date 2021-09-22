package reflection;

import java.lang.reflect.Method;

public class ReflectionMain {

    public static void main(String[] args) {
        System.out.println( Trainer.class.getName() +" = Trainer classname \n");

        Course course = new Course("Java");
        System.out.println( course.getClass().getCanonicalName() +" = Course Canonical classname \n");

        System.out.println("Public and inherited methods (from Human & Object) :");
        Method[] trPublMethods = Trainer.class.getMethods();
        for(Method m : trPublMethods){
            System.out.println(m);
        }

        System.out.println("All methods (declared in this class) :");
        Method[] trDeclMethods = Trainer.class.getDeclaredMethods();
        for(Method m : trDeclMethods){
            System.out.print("\n declared: "+ m);
        }


    }

}
