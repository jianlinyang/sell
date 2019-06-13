package com.shu.sell.repository;

import com.shu.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <h1>ProductInfoRepository 接口</h1>
 *
 * @author yang
 * @date 2019/6/13 22:42
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /**
     * <h2>通过商品状态查询</h2>
     *
     * @param productStatus 商品状态码
     * @return {@link ProductInfo}
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
