class Student2 {
    private final String name;
    private int numOfTasks = 0;

    public Student2 (String name) {
        this.name = name.trim();
    }

    public Student2(String name, int numOfTasks) {
        this.name = name.trim();
        setNumOfTasks(numOfTasks);
    }

    // Get methods
    public String getName() {return this.name;}
    public int getNumOfTasks() {return this.numOfTasks;}

    // Set methods
    public void setNumOfTasks(int numOfTasks) {
        if (numOfTasks < 0) throw new IllegalArgumentException("Number of tasks can not be negative");
        else this.numOfTasks = numOfTasks;
    }

    public void increaseNumOfTasks(int increase) {
        if (this.numOfTasks + increase < 0) throw new IllegalArgumentException("Number of tasks can not be negative");
        else this.numOfTasks += increase;
    }

    public String toString() {
        return "Name: " + name + "\n" +
        "Number of tasks: " + this.numOfTasks + "\n";
    }
}