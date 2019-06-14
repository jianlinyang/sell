package com.shu.sell.service.impl;

import com.shu.sell.dataobject.ProductCategory;
import com.shu.sell.repository.ProductCategoryRepository;
import com.shu.sell.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>CategoryService 实现</h1>
 *
 * @author yang
 * @date 2019/6/13 21:41
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final ProductCategoryRepository repository;

    public CategoryServiceImpl(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductCategory findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
