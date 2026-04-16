package service;

import connection.ConnectionFactory;
import dao.RentDAO;
import dao.VehicleDAO;
import model.Vehicle;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class RentService {

    VehicleDAO vehicleDAO = new VehicleDAO();
    RentDAO rentDAO = new RentDAO();

    public void rentVehicle(Long id, String clientName, LocalDate startDate) {

        Vehicle vehicle = vehicleDAO.findById(id);

        if (vehicle == null) {
            throw new RuntimeException("Vehicle not found");
        }

        if (!vehicle.isAvailable()) {
            throw new RuntimeException("Vehicle is not available");
        }

        if (clientName == null || clientName.isBlank()) {
            throw new RuntimeException("Client name cannot be null or blank");
        }

        if (startDate.isAfter(LocalDate.now())) {
            throw new RuntimeException("This date are invalid");
        }

        rentDAO.rentVehicle(vehicle, clientName, startDate);

    }

    public void returnVehicle(Long id) {

        Vehicle vehicle = vehicleDAO.findById(id);

        if (vehicle == null) {
            throw new RuntimeException("Vehicle not found");
        }

        if (vehicle.isAvailable()) {
            throw new RuntimeException("This vehicle is not rented");
        }

        rentDAO.returnVehicle(id);

    }

    public String listAllRents() {
        return rentDAO.listAllRents();
    }
}
