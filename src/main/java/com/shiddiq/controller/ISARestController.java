package com.shiddiq.controller;
import java.util.List;
import com.shiddiq.entity.Isasensor;
import com.shiddiq.service.IsasensorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
 

 
@RestController
public class ISARestController {
 
    @Autowired
    IsasensorService isasensorService;  //Service which will do all data retrieval/manipulation work
 
     
    //-------------------Retrieve All Lamps JSON--------------------------------------------------------
     
    @RequestMapping(value = "/getsensor", method = RequestMethod.GET)
    public ResponseEntity<List<Isasensor>> listAllIsasensors()  {
        List<Isasensor> isasensors = isasensorService.getAllIsasensors();
        if(isasensors.isEmpty()){
            return new ResponseEntity<List<Isasensor>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Isasensor>>(isasensors, HttpStatus.OK);
    }



 
}