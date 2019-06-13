package com.shu.sell.repository;

import com.shu.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * @date 2019/6/13 20:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory one = repository.findOne(1);
        System.out.println(one.getCategoryType());
    }

    @Test
    public void saveOneTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(2);
        productCategory.setCategoryName("最受欢迎的");
        repository.save(productCategory);
    }
    @Test
    public void updateOneTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryType(3);
        productCategory.setCategoryName("热销的");
        repository.save(productCategory);
    }

    @Test
    public void findByList(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        List<ProductCategory> byCategoryTypeIn = repository.findByCategoryTypeIn(list);
        System.out.println(byCategoryTypeIn.size());
    }
}