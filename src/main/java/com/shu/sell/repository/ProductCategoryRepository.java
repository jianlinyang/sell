package com.shu.sell.repository;

import com.shu.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yang
 * @date 2019/6/13 20:46
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

}
