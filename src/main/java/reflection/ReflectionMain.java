package reflection;

import java.lang.reflect.Method;

public class ReflectionMain {
    private static Trainer trainer;

    public static void main(String[] args) {
        trainer = new Trainer("Elgár", 1848);
        ReflectionMain main = new ReflectionMain();

        new ReflectionMain().writeMethodsOfTrainer();

        main.writeClassDatas();

        System.out.println( Human.class.getPackage().getName() +" = package of Human \n");

        System.out.println("Trainer.InnerSkills.getDeclaringClass() :");
        Trainer.InnerSkills iSkill = new Trainer().new InnerSkills();
        System.out.println( iSkill.getClass().getDeclaringClass() );


    }

    private void writeMethodsOfTrainer(){
        System.out.println("Public and inherited methods (from Human & Object) :");
        Method[] trPublMethods = Trainer.class.getMethods();
        for(Method m : trPublMethods){
            System.out.println(" "+ m);
        }

        System.out.println("\nAll methods (declared in this class) :");
        Method[] trDeclMethods = Trainer.class.getDeclaredMethods();
        for(Method m : trDeclMethods){
            System.out.println(" declared: "+ m);
        }
        System.out.println();
    }

    private void writeClassDatas(){
        System.out.println( trainer.getClass().getName() +" = Trainer classname \n");
        System.out.println( Course.class.getCanonicalName() +" = Course Canonical classname \n");

        System.out.println("Trainer.getDeclaredClasses() :");
        Class[] classesOfTrainer = Trainer.class.getDeclaredClasses();
        for (Class c : classesOfTrainer){
            System.out.println( c.getName() );
        }

        System.out.println("\nSuperclass of Trainer :");
        System.out.println( Trainer.class.getSuperclass().getTypeName());
        System.out.println();
    }

}
