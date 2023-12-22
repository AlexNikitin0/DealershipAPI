package com.pluralsight.Controllers;
import com.pluralsight.DAO.DAO;
import com.pluralsight.DealershipApiApplication;
import com.pluralsight.models.Contract;
import com.pluralsight.models.LeaseContract;
import com.pluralsight.models.SalesContract;
import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class LeaseContractController {

    private DAO dao;
    @Autowired
    public LeaseContractController(DAO dao){
        this.dao = dao;
    }

    //GET

    @RequestMapping(path = "/dealership/contracts/lease/{id}",method = RequestMethod.GET)
    public ArrayList<LeaseContract> getContractByID(@PathVariable int id){
        return dao.getLeaseContractByID(id);
    }

}
