package com.shu.sell.repository;

import com.shu.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <h1>ProductCategoryRepository接口</h1>
 *
 * @author yang
 * @date 2019/6/13 20:46
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * <h2>通过集合查找</h2>
     *
     * @param categoryTypeList id集合
     * @return {@link ProductCategory}
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
