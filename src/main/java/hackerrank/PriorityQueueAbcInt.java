package hackerrank;

import java.util.*;

class Priorities {
    PriorityQueue<Student> stq = new PriorityQueue<>(new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getCgpa() != o2.getCgpa()) {
                return o1.getCgpa() < o2.getCgpa() ? 1 : -1;
            }
            if (!o1.getName().equals(o2.getName())) {
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getId() > o2.getId() ? 1 : -1;
        }
    }
    );

    public List<Student> getStudents(List<String> strl) {

        for (String s : strl) {
            String[] data = s.split(" ");
            if (data[0].equals("ENTER")) {
                Student st = new Student(data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]));
                stq.add(st);
            } else {
                stq.poll();
            }
            stq.peek();
        }
//Nem adhatom vissza, mert a PrioQueue csak akkor rendez (JIT),
//amikor kiveszek belőle, benne rendezetlenek az elemek.
        List<Student> result = new ArrayList<>();
        int i = stq.size();
        while (i-- > 0) {
            result.add(stq.poll());
        }
        return result;
    }
}

public class PriorityQueueAbcInt {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
//this class was given code. Csak itt lépek ki más osztályba, innen kell mindent intézni.
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Student {
    private String name;
    private double cgpa;
    private int id;

    public Student(String name, double cgpa, int id) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
    public int getId() {
        return id;
    }

}
