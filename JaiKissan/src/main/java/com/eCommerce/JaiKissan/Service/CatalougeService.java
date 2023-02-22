package com.eCommerce.JaiKissan.Service;

import com.eCommerce.JaiKissan.Entities.Catalouge;
import com.eCommerce.JaiKissan.Repository.CatalougeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalougeService {
    @Autowired
    private CatalougeRepository catalougeRepository;


    public Catalouge addCatalouge(Catalouge catalouge) {
        return this.catalougeRepository.save(catalouge);
    }
}
