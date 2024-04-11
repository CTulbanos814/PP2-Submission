class Vehicle {
    private String regNo;
    private String make;
    private int year;
    private double value;

    public Vehicle(String regNo, String make, int year, double value) {
        this.regNo = regNo;
        this.make = make;
        this.year = year;
        this.value = value;
    }
    
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Reg No: " + regNo + ", Make: " + make + ", Year of Manufacture: " + year + ", Value: Php" + value;
    }
}
