package com.shu.sell.service;

import com.shu.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

/**
 * <h1>商品服务接口</h1>
 *
 * @author yang
 * @date 2019/6/13 23:10
 */
public interface ProductService {
    /**
     * 查询一个
     *
     * @param productId 商品id
     * @return {@link ProductInfo}
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品
     *
     * @return {@link ProductInfo}
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有
     *
     * @param pageable {@link Pageable}
     * @return {@link Page} {@link ProductInfo}
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存
     *
     * @param productInfo {@link ProductInfo}
     * @return {@link ProductInfo}
     */
    ProductInfo save(ProductInfo productInfo);
}
