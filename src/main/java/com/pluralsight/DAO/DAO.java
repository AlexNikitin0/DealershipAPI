package com.pluralsight.DAO;

import com.pluralsight.models.LeaseContract;
import com.pluralsight.models.SalesContract;
import com.pluralsight.models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class DAO {


    private DataSource dataSource;

    @Autowired
    public DAO(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    public ArrayList<Vehicle> getAllVehiclesFromDatabase() {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicles")) {

            while (resultSet.next()) {
                Vehicle car = new Vehicle(
                        resultSet.getString("vin"),
                        resultSet.getInt("year"),
                        resultSet.getString("make"),
                        resultSet.getString("model"),
                        resultSet.getString("vehicle_type"),
                        resultSet.getString("color"),
                        resultSet.getInt("odometer"),
                        resultSet.getDouble("price")


                );
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }


    public ArrayList<Vehicle> getAllVehiclesByPriceRange(double min, double max) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?")) {

            statement.setDouble(1, min);
            statement.setDouble(2, max);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }


    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE vehicle_Type=?")) {

            statement.setString(1, type);


            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Vehicle> getVehiclesByMilage(int minMiles, int maxMiles) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?")) {

            statement.setDouble(1, minMiles);
            statement.setDouble(2, maxMiles);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE color=?")) {

            statement.setString(1, color);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?")) {

            statement.setDouble(1, min);
            statement.setDouble(2, max);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {


        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE make=? AND model=?")) {

            statement.setString(1, make);
            statement.setString(2, model);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }


    public Vehicle getVehicleByVin(String vin) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE vin=?")) {

            statement.setString(1, vin);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

            //POST
    public Vehicle addVehicle(Vehicle vehicle){
        String sql ="INSERT INTO vehicles (vin,make,model,price,year,vehicle_Type,odometer,color) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1,vehicle.getVin());
            statement.setString(2,vehicle.getMake());
            statement.setString(3,vehicle.getModel());
            statement.setDouble(4,vehicle.getPrice());
            statement.setInt(5,vehicle.getYear());
            statement.setString(6,vehicle.getVehicleType());
            statement.setInt(7,vehicle.getOdometer());
            statement.setString(8,vehicle.getColor());
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return vehicle;
    }

                //PUT
    public Vehicle updateVehicleInDatabase(Vehicle vehicle) {
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE vehicles SET make=?, model=?, year=?, color=?, price=?, odometer=?, vehicle_type=? WHERE vin=?")) {

            statement.setString(1, vehicle.getMake());
            statement.setString(2, vehicle.getModel());
            statement.setInt(3, vehicle.getYear());
            statement.setString(4, vehicle.getColor());
            statement.setDouble(5, vehicle.getPrice());
            statement.setInt(6, vehicle.getOdometer());
            statement.setString(7, vehicle.getVehicleType());
            statement.setString(8, vehicle.getVin());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    public void deleteVehicleFromDatabase(String vin) {
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM vehicles WHERE vin=?")) {
            statement.setString(1, vin);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // add sales contract to DB

    public void addSalesContractDetails(String vin, String buyerName, LocalDate saleDate, String email,boolean isFinance) {
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO sales_contracts (vin, buyer_name, sale_date,email,finance) VALUES (?,?,?,?,?)")) {

            statement.setString(1, vin);
            statement.setString(2, buyerName);
            statement.setDate(3, java.sql.Date.valueOf(saleDate));
            statement.setString(4,email);
            statement.setBoolean(5,isFinance);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SalesContract> getSalesContractByID(int id){
        ArrayList<SalesContract> contracts = new ArrayList<>();
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM sales_contracts WHERE id=?")
                ){
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    SalesContract salesContract = new SalesContract(
                            resultSet.getDate("sale_date").toLocalDate(),
                            resultSet.getString("buyer_name"),
                            resultSet.getString("email"),
                            resultSet.getString("vin"),
                            resultSet.getBoolean("finance")




                    );
                    contracts.add(salesContract);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;

        }



    public ArrayList<LeaseContract> getLeaseContractByID(int id){
        ArrayList<LeaseContract> contracts = new ArrayList<>();
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM lease_contracts WHERE id=?")
        ){
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    LeaseContract lease = new LeaseContract(
                            resultSet.getDate("sale_date").toLocalDate(),
                            resultSet.getString("buyer_name"),
                            resultSet.getString("email"),
                            resultSet.getString("vin")

                    );
                    contracts.add(lease);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;

    }





    public void addLeaseContractDetails(String vin, String buyerName, LocalDate saleDate, String email) {
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO lease_contracts (vin, buyer_name, sale_date,email) VALUES (?,?,?,?)")) {

            statement.setString(1, vin);
            statement.setString(2, buyerName);
            statement.setDate(3, java.sql.Date.valueOf(saleDate));
            statement.setString(4,email);


            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}









