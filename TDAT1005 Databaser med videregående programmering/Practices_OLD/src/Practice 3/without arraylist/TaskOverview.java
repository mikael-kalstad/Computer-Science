class TaskOverview {
    private Student[] students = new Student[5];
    private int numOfStud = 0;

    public TaskOverview() {}

    public TaskOverview(Student[] students) {
        // Deep copy of array in argument
        this.students = new Student[students.length];

        for (int i = 0; i < this.students.length; i++) {
            this.students[i] = students[i];
        }
        numOfStud = students.length;
    }

    public boolean registerNewStudent(String name) {
        name.trim();
        if (checkForDuplicate(name)) return false;

        // Check if array is full, increase size if necessary
        if (this.numOfStud == this.students.length) {
            this.students = increaseArray(this.students, 5);
        }

        // Register new student and increase num of students
        this.students[this.numOfStud] = new Student(name);
        numOfStud++;
        return true;
    }

    public int getNumOfStud() {return this.numOfStud;}

    public int numOfTasks(String name) {
        int index = findIndex(name);
        if (index == -1) return -1;
        return this.students[index].getNumOfTasks();
    }

    public void increaseNumOfTasks(String name, int increase) {
        int index = findIndex(name);
        this.students[index].increaseNumOfTasks(increase);
    }

    public String toString() {
        String msg = "";
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null) {
                msg += this.students[i].toString() + "\n";
            }
        }
        return msg + "Number of students: " + getNumOfStud() + "\n----------------";
    }

    // Helping methods 
    public Student[] increaseArray(Student[] arr, int amount) {
        // Check if object is null
        if (arr == null) return null;

        // Increase with amount
        Student[] newArr = new Student[arr.length + amount];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    public String[] increaseArray(String[] arr, int amount) {
        // Check if object is null
        if (arr == null) return null;

        // Increase with amount 
        String[] newArr = new String[arr.length + amount];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    public boolean checkForDuplicate(String name) {
        // Check for similar objects
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null && this.students[i].getName().equals(name.trim())) {
                return true;
            }
        }
        return false;
    }

    public int findIndex(String name) {
        // Check for similar objects
        // Return index if found, else return -1
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null && this.students[i].getName().equals(name.trim())) {
                return i;
            }
        }
        return -1;
    }

    public String[] getAllNames() {
        String[] arr = new String[1];

        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null) {
                if (arr[arr.length-1] != null) arr = increaseArray(arr, 1);
                arr[i] = this.students[i].getName();
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Student ole = new Student("Ole");
        Student per = new Student("Per", 3);

        Student[] studentsArr = {ole, per};
        TaskOverview o = new TaskOverview(studentsArr);

       o.increaseNumOfTasks("Ole", 2);
        System.out.println(o);
    }
}