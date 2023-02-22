package com.eCommerce.JaiKissan.controller;

import com.eCommerce.JaiKissan.Entities.Catalouge;
import com.eCommerce.JaiKissan.Service.CatalougeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalouge")
public class CatalougeController {
    @Autowired
    private CatalougeService catalougeService;
    @PostMapping("/addCatalouge")
    public Catalouge addCatalouge(@RequestBody Catalouge catalouge){
        return  this.catalougeService.addCatalouge(catalouge);

    }

}
