package com.pluralsight.Controllers;

import com.pluralsight.DAO.DAO;
import com.pluralsight.DealershipApiApplication;
import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class VehiclesController {

    private DAO dao;

    @Autowired
    public VehiclesController(DAO dao){
        this.dao = dao;
    }
                //GET methods
    @RequestMapping(path="/dealership/vehicles/{min}/{max}",method = RequestMethod.GET)
    public ArrayList<Vehicle> getByPrice(@PathVariable double min, @PathVariable double max){
        return dao.getAllVehiclesByPriceRange(min,max);
    }

    @RequestMapping(path = "/dealership/vehicles/{make}/{model}",method = RequestMethod.GET)
    public ArrayList<Vehicle> getByMake(@PathVariable String make, @PathVariable String model){
        return dao.getVehiclesByMakeModel(make,model);
    }

    @RequestMapping(path = "/dealership/vehicles/{minYear}/{maxYear}",method = RequestMethod.GET)
    public ArrayList<Vehicle> getByYear(@PathVariable int minYear, @PathVariable int maxYear){
        return dao.getVehiclesByYear(minYear,maxYear);
    }

    @RequestMapping(path = "/dealership/vehicles/{color}",method = RequestMethod.GET)
    public ArrayList<Vehicle> getByColor(@PathVariable String color){
        return dao.getVehiclesByColor(color);
    }

    @RequestMapping(path = "/dealership/vehicles/{minMiles}/{maxMiles}",method = RequestMethod.GET)
    public ArrayList<Vehicle> getByMiles(@PathVariable int minMiles, @PathVariable int maxMiles){
        return dao.getVehiclesByMilage(minMiles,maxMiles);
    }

    @RequestMapping(path = "/dealership/vehicles/{type}",method = RequestMethod.GET)
    public ArrayList<Vehicle> getByType(@PathVariable String type){
        return dao.getVehiclesByType(type);
    }

    //POST methods

    @RequestMapping(path="/dealership/vehicles/add",method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
       return dao.addVehicle(vehicle);
    }

        //PUT methods

    @RequestMapping(path="/dealership/vehicles/update",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle){
        return dao.updateVehicleInDatabase(vehicle);
    }

    //Delete

    @RequestMapping(path="/dealership/vehicles/delete/{vin}",method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void deleteVehicle(@PathVariable String vin){
        dao.deleteVehicleFromDatabase(vin);
    }



}
