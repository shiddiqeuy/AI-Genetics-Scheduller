package com.shiddiq.controller;
import com.shiddiq.entity.Isasensor;
import com.shiddiq.service.IsasensorService;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



/**
 * @author shiddiq 15 Mei 2016 shiddiqitt@gmail.com
 * @version 1.0
 * @ 15 Mei 2016
 * 
 */
@Controller
@EnableScheduling
public class ISAController {
	
	private static final Logger logger = Logger.getLogger(ISAController.class);
	
	public ISAController() {
		System.out.println("ISAController()");
	}

    @Autowired
    private IsasensorService isasensorService;
    
//    @Autowired
//    private WeatherSchedulerImpl WS;

    @RequestMapping("createIsa")
    public ModelAndView createISAsensor(@ModelAttribute Isasensor isasensor) {
    	logger.info("Creating Isasensor. Data: "+isasensor);
        return new ModelAndView("lampForm");
    }
    
    @RequestMapping("editIsa")
    public ModelAndView editISAsensor(@RequestParam long id, @ModelAttribute Isasensor isasensor) {
    	logger.info("Updating the Isasensor for the Id "+id);
        isasensor = isasensorService.getIsasensor(id);
        return new ModelAndView("lampForm", "lampObject", isasensor);
    }
    

    @RequestMapping("saveIsa")
    public ModelAndView saveISAsensor(@ModelAttribute Isasensor isasensor) {
    	logger.info("Saving the Isasensor. Data : "+isasensor);
        if(isasensor.getId() == 0){ // if lamp_registration id is 0 

	    	logger.info("controller create isasensor");
            isasensorService.createISAsensor(isasensor);

        } else {
	    	logger.info("controller update isasensor");
            isasensorService.updateISAsensor(isasensor);
        }
        return new ModelAndView();
        
    }
    

    
    @RequestMapping("deleteIsasensor")
    public ModelAndView deleteISAsensor(@RequestParam long id) {
    	logger.info("Deleting the Isasensor. Id : "+id);
        isasensorService.deleteISAsensor(id);
        return new ModelAndView("isasensordashboard");
    }
    
    @RequestMapping(value ="isasensordashboard")
    public ModelAndView getAllIsasensors() {
    	logger.info("Getting the all Isasensor.");
        List<Isasensor> isaSensorList = isasensorService.getAllIsasensors();

        return new ModelAndView("isaSensorList", "isaSensorList", isaSensorList);
    }
    
    @RequestMapping("GAtraining")
    public ModelAndView GAtraining() {
    	logger.info("Getting the all Isasensor for training");
        List<Isasensor> isaSensorList = isasensorService.getAllIsasensors();

        return new ModelAndView("GAtraining", "GAtraining", isaSensorList);
    }
    
    @RequestMapping("searchIsa")
    public ModelAndView searchISAsensor(@RequestParam("searchIsaid") String searchIsaid) {  
    	logger.info("Searching the Isasensor. Isasensor Led Id: "+searchIsaid);
    	List<Isasensor> isaSensorList = isasensorService.getAllIsasensors(searchIsaid);
        return new ModelAndView("isaList", "isaList", isaSensorList);    	
    }
    
   
  
}