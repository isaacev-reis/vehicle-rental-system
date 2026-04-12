import dao.VehicleDAO;
import model.Vehicle;

public class Main {
    public static void main(String[] args) {
        VehicleDAO vehicleDAO = new VehicleDAO();

        System.out.println(vehicleDAO.listAllVehicles());
    }
}