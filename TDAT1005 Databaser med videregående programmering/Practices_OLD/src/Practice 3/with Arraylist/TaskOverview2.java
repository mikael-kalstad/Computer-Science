import java.util.ArrayList;

class TaskOverview2 {
    private ArrayList<Student2> students = new ArrayList<Student2>();
    private int numOfStud = 0;

    public TaskOverview2() {}

    public TaskOverview2(Student2[] students) {
        for (Student2 obj : students) {
            this.students.add(obj);
        }

        numOfStud = students.length;
    }

    public boolean registerNewStudent(String name) {
        name = name.trim();
        System.out.println(findIndex(name));
        if (findIndex(name) != -1) return false;

        // Register new student and increase num of students
        this.students.add(new Student2(name));
        numOfStud++;
        return true;
    }

    public int getNumOfStud() {return this.numOfStud;}

    public int numOfTasks(String name) {
        int index = findIndex(name);
        return this.students.get(0).getNumOfTasks();
    }

    public void increaseNumOfTasks(String name, int increase) {
        int index = findIndex(name);
        this.students.get(index).increaseNumOfTasks(increase);
    }

    public String toString() {
        String msg = "";
      
        for (Student2 obj: this.students) {
            msg += obj.toString() + "\n";
        }
        return msg + "Number of students: " + getNumOfStud() + "\n----------------";
    }

    // Helping methods 
    public int findIndex(String name) {
        for (Student2 obj : this.students) {
            if (obj.getName().equals(name)) {
                return this.students.indexOf(obj);
            }
        }
        return -1;
    }

    public String[] getAllNames() {
        ArrayList<String> arr = new ArrayList<String>();

        for (Student2 obj : this.students) {
            arr.add(obj.getName());
        }

        String[] newArr = new String[arr.size()];
        return arr.toArray(newArr);
    }

    public static void main(String[] args) {
        Student2 ole = new Student2("Ole");
        Student2 per = new Student2("Per", 3);

        Student2[] studentsArr = {ole, per};
        TaskOverview2 o = new TaskOverview2(studentsArr);

        o.increaseNumOfTasks("Per", 2);

        for (int i = 0; i < o.getAllNames().length; i++) {
            System.out.println("getAllNames: " + o.getAllNames()[i]);
        } 

        System.out.println("Index: " + o.findIndex("Per"));
        System.out.println(o.registerNewStudent("per"));
    }
}