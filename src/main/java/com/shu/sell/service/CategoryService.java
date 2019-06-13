package com.shu.sell.service;

import com.shu.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * <h1>Category服务</h1>
 *
 * @author yang
 * @date 2019/6/13 21:34
 */
public interface CategoryService {
    /**
     * <h2>通过id查询一个</h2>
     *
     * @param id category id
     * @return {@link ProductCategory}
     */
    ProductCategory findOne(Integer id);

    /**
     * <h2>查询所有</h2>
     *
     * @return {@link ProductCategory}
     */
    List<ProductCategory> findAll();

    /**
     * <h2>通过集合查询所有</h2>
     *
     * @param categoryTypeList 类目集合
     * @return {@link ProductCategory}
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * <h2>保存一个</h2>
     *
     * @param productCategory {@link ProductCategory}
     * @return {@link ProductCategory}
     */
    ProductCategory save(ProductCategory productCategory);
}
