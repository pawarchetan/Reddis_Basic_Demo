package com.asciiwarehouse.resource;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RestController
@RequestMapping("warehouse")
@Log4j2
public class WarehouseController {

    @GET
    @Path("/")
    @ResponseBody
    @Cacheable("calculateResult")
    public String calculateResults(){
        //call ASCII warehouuse API
        log.debug("Performing expensive calculation...");
        // perform computationally expensive calculation
        return "result";
    }
}
