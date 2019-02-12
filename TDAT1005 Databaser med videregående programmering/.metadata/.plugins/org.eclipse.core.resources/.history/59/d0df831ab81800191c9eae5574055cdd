class Resturant {
    private String name;
    private int startYear;
    private Table tables;

    Resturant(String name, int startYear, int tableAmount) {
        this.name = name;
        this.startYear = startYear;
        tables = new Table(tableAmount);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public int age() {
        int year = 2019;
        return year - this.startYear;
    }


    public int availableTables() {
        return this.tables.availableTables();
    }

    public int notAvailableTables() {
        return this.tables.notAvailableTables();
    }

    public boolean reserveTables(int amount, String name) {
        return this.tables.reserveTables(amount, name);
    }

    public int[] tablesReservedBy(String name) {
        int[] tableNum = null;
        String[] arr = tables.getReservations();
        if (arr == null) return null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(name)) {
                tableNum = expandArray(tableNum, 1);
                tableNum[tableNum.length-1] = i;
            }
        }
        return tableNum;
    }

    public void cleanTables(int[] tableNum) {
        this.tables.cleanTables(tableNum);
    }

    // Hjelpemetoder
    public int[] expandArray(int[] arr, int amount) {
        if (arr == null) return new int[1];
        
        int[] newArr = new int[arr.length + amount];
        for (int i = 0; i < arr.length; i++) newArr[i] = arr[i];

        return newArr;
    }

    public String toString() {
        return 
        "Name: " + this.getName() + "\n" +
        "Start year: " + this.startYear + "\n" +
        "Age: " + this.age() + "\n" +
        "Available tables: " + this.availableTables() + "\n" +
        "Not available tables: " + this.notAvailableTables() + "\n";
    }

    public static void printArr(int[] arr) {
        if (arr == null) {
            System.out.println("Array is not initialized (value of null)");
            return;
        }

        String msg = "";
        for (int i : arr) {
            if (i == arr.length - 1) msg += arr[i];
            else msg += arr[i] + ",";
        }
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Resturant helstrom = new Resturant("Helstrøm", 2004, 5);
        System.out.println(helstrom);

        helstrom.reserveTables(2, "Mikael");
        printArr(helstrom.tablesReservedBy("Mikael"));
        
        int[] arr = {0, 1};
        helstrom.cleanTables(arr);
        printArr(helstrom.tablesReservedBy("Mikael"));
         System.out.println(helstrom);
    }   
}