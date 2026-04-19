package service;

import dao.VehicleDAO;
import model.Vehicle;

import java.time.LocalDate;

public class VehicleService {
    VehicleDAO vehicleDAO = new VehicleDAO();

    public void validateVehicle(Vehicle vehicle) {
        if (vehicle.getPlate() == null || vehicle.getPlate().isBlank()) {
            throw new IllegalArgumentException("Plate is required");
        }

        if (vehicle.getBrand() == null || vehicle.getBrand().isBlank()) {
            throw new IllegalArgumentException("Brand is required");
        }

        if (vehicle.getModel() == null || vehicle.getModel().isBlank()) {
            throw new IllegalArgumentException("Model is required");
        }

        if (vehicle.getYear() > LocalDate.now().getYear() || vehicle.getYear() < 1900) {
            throw new IllegalArgumentException("Year must be between 1900 and the current year");
        }

        if (vehicle.getDailyRate() <= 0) {
            throw new IllegalArgumentException("Daily rate must be greater than zero");
        }
    }

    public void insertVehicle(Vehicle vehicle) {
        validateVehicle(vehicle);
        vehicleDAO.insertVehicle(vehicle);
    }

    public void deleteVehicle(Long id) {

        Vehicle vehicle = vehicleDAO.findById(id);

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not found");
        }

        vehicleDAO.deleteVehicle(id);
    }

    public String listAllVehicles() {
        return vehicleDAO.listAllVehicles();
    }

    public String listEnabledVehicles() {
        return vehicleDAO.listEnabledVehicles();
    }
}
