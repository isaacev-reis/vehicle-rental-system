package view;

public class View {
    public String showMenu() {
        return """
            ================= SELECT AN OPTION =================
            1 - Insert Vehicle
            2 - Delete Vehicle
            3 - List All Vehicles
            4 - List Enabled Vehicles
            5 - Rent a Vehicle
            6 - Return a Vehicle
            7 - List All Rents
            8 - Exit
            """;
    }
}
