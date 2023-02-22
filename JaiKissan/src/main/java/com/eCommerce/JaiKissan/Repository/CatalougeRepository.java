package com.eCommerce.JaiKissan.Repository;

import com.eCommerce.JaiKissan.Entities.Catalouge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalougeRepository extends JpaRepository<Catalouge, Integer> {
}
