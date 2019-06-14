package com.shu.sell.controller;

import com.shu.sell.dataobject.ProductCategory;
import com.shu.sell.dataobject.ProductInfo;
import com.shu.sell.service.CategoryService;
import com.shu.sell.service.ProductService;
import com.shu.sell.utils.ResultVoUtils;
import com.shu.sell.vo.ProductInfoVO;
import com.shu.sell.vo.ProductVO;
import com.shu.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>买家商品</h1>
 *
 * @author yang
 * @date 2019/6/14 12:20
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public BuyerProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("list")
    public ResultVO list() {
        //查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //查询类目(一次查询)
        List<Integer> categoryList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryList);
        //数据拼装
        ArrayList<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            ArrayList<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVoUtils.success(productVOList);
    }
}
