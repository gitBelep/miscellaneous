package reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionMain {
    private static Trainer trainer;

    public static void main(String[] args) {
        trainer = new Trainer("Elgár", 1848);
        Trainer.InnerSkills iSkill = new Trainer().new InnerSkills();
        ReflectionMain main = new ReflectionMain();

//        new ReflectionMain().writeMethodsOfTrainer();

//        main.writeClassDatas(iSkill);

//        main.aboutModifiers(iSkill);

        main.writeContsructors();

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

    private void writeClassDatas(Trainer.InnerSkills iSkill){
        System.out.println( Human.class.getPackage().getName() +" = package of Human \n");

        System.out.println("Trainer.InnerSkills.getDeclaringClass() :");
        System.out.println( iSkill.getClass().getDeclaringClass() );

        Class iSkillClass = iSkill.getClass();
        System.out.println(iSkillClass.isLocalClass() +" = Trainer.InnerSkill.class.isLocalClass()");
        System.out.println(Trainer.InnerSkills.class.isMemberClass() +" = Trainer.InnerSkills.class.isMemberClass()");

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

    private void aboutModifiers(Trainer.InnerSkills iSkill) {
        System.out.println("\nModifier for Trainer & InnerSkills :");
        int modifier = Trainer.class.getModifiers();
        System.out.println( modifier +": "+ Modifier.toString(modifier) );
        System.out.println( Modifier.isPublic(modifier) +" = public \n");
        int iSkillModifier = iSkill.getClass().getModifiers();
        System.out.println( iSkillModifier +": "+ Modifier.toString(iSkillModifier) +" ~ myText: nothing ~");
        System.out.println( Modifier.isProtected(iSkillModifier) +" = protected \n");
    }

    private void writeContsructors(){
        Constructor[] constructors = Trainer.class.getConstructors();

        for(int j = 0; j < constructors.length; j++){
            Class[] paramTypes = constructors[j].getParameterTypes();
            Type[] types = constructors[j].getGenericParameterTypes();
            System.out.println(j +": \n"+
                    Arrays.toString(paramTypes) +"\n"+
                    Arrays.toString(types));
        }
    }

}
