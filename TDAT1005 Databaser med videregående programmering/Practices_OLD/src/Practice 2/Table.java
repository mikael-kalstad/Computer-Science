class Table {
    private String[] reservations; 

    Table(int tableAmount) {
        this.reservations = new String[tableAmount];
    }

    public String[] getReservations() {
        return this.reservations;
    }

    public int availableTables() {
        int counter = 0;
        for (int i = 0; i < this.reservations.length; i++) {
            if (this.reservations[i] == null) counter++;
        }
        return counter;
    }

    public int notAvailableTables() {
        return reservations.length - this.availableTables();
    }

    public void cleanTables(int tableNum[]) {
        for (int i = 0; i < tableNum.length; i++) {
            this.reservations[tableNum[i]] = null;
        }
    }

    public boolean reserveTables(int amount, String name) {
        int counter = 0;
        for (int i = 0; i < this.reservations.length; i++) {
            if (this.reservations[i] == null && counter < amount) {
                this.reservations[i] = name;
                counter++;
            }
        }

        if (counter != amount) return false;
        return true;
    }
}