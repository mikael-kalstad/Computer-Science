class Student {
    private final String name;
    private int numOfTasks = 0;

    public Student (String name) {
        this.name = name.trim();
    }

    public Student(String name, int numOfTasks) {
        this.name = name.trim();
        this.numOfTasks = numOfTasks;
    }

    // Get methods
    public String getName() {return this.name;}
    public int getNumOfTasks() {return this.numOfTasks;}

    // Set methods
    public void increaseNumOfTasks(int numOfTasks) {
        if (numOfTasks < 0) throw new IllegalArgumentException("Number of tasks can not be negative");
        else this.numOfTasks += numOfTasks;
    }

    public String toString() {
        return "Name: " + name + "\n" +
        "Number of tasks: " + this.numOfTasks + "\n";
    }
}