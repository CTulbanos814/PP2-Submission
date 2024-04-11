import java.util.*;

public class VehicleManagement {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Sort vehicle list by age");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = key.nextInt();
            key.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter registration number: ");
                    String regNo = key.nextLine();
                    System.out.print("Enter make: ");
                    String make = key.nextLine();
                    System.out.print("Enter year of manufacture: ");
                    int year = key.nextInt();
                    System.out.print("Enter value: ");
                    double value = key.nextDouble();
                    vehicleList.add(new Vehicle(regNo, make, year, value));
                    System.out.println("Vehicle added successfully!");
                    break;
                case 2:
                    System.out.println("List of vehicle details:");
                    for (Vehicle vehicle : vehicleList) {
                        System.out.println(vehicle);
                    }
                    break;
                case 3:
                    System.out.print("Enter the index of the vehicle to delete: ");
                    int index = key.nextInt();
                    if (index >= 1 && index <= vehicleList.size()) {
                        vehicleList.remove(index - 1);
                        System.out.println("Vehicle deleted successfully!");
                    } else {
                        System.out.println("Invalid index. No vehicle deleted.");
                    }
                    break;
                case 4:
    int sortChoice;
    do {
        System.out.println("\nSort Menu:");
        System.out.println("1. Sort by age (ascending)");
        System.out.println("2. Sort by age (descending)");
        System.out.println("3. Back to main menu");
        System.out.print("Enter your choice: ");
        sortChoice = key.nextInt();
        key.nextLine();  // Consume newline character

        switch (sortChoice) {
            case 1:
                // Sorting by age ascending
                vehicleList.sort(Comparator.comparing(Vehicle::getYear));
                System.out.println("List of vehicle details sorted by age (ascending):");
                for (Vehicle vehicle : vehicleList) {
                    System.out.println(vehicle);
                }
                break;
            case 2:
                // Sorting by age descending
                vehicleList.sort(Comparator.comparing(Vehicle::getYear).reversed());
                System.out.println("List of vehicle details sorted by age (descending):");
                for (Vehicle vehicle : vehicleList) {
                    System.out.println(vehicle);
                }
                break;
            case 3:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (sortChoice != 3);
    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        key.close();
    }
}