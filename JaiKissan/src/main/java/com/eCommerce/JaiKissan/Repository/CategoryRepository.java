package com.eCommerce.JaiKissan.Repository;

import com.eCommerce.JaiKissan.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
