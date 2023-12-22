package com.pluralsight.Controllers;
import com.pluralsight.DAO.DAO;
import com.pluralsight.DealershipApiApplication;
import com.pluralsight.models.Contract;
import com.pluralsight.models.SalesContract;
import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SalesContractsController {
    private DAO dao;

    @Autowired
    public SalesContractsController(DAO dao){
        this.dao = dao;
    }

    //GET

    @RequestMapping(path = "/dealership/contracts/sales/{id}",method = RequestMethod.GET)
    public ArrayList<SalesContract> getContractByID(@PathVariable int id){
        return dao.getSalesContractByID(id);
    }

}
