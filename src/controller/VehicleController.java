package controller;

import model.Vehicle;
import service.VehicleService;
import view.View;

import java.util.Scanner;

public class VehicleController {

    VehicleService vehicleService = new VehicleService();
    View view = new View();

    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println(view.showMenu());
        int option = scanner.nextInt();
    }

    public void insertVehicle(Vehicle vehicle) {
        vehicleService.insertVehicle(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleService.deleteVehicle(id);
    }

    public void listAllVehicles() {
        System.out.println(vehicleService.listAllVehicles());
    }

    public void listEnabledVehicles() {
        System.out.println(vehicleService.listEnabledVehicles());
    }
}
