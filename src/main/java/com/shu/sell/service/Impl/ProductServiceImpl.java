package com.shu.sell.service.Impl;

import com.shu.sell.dataobject.ProductInfo;
import com.shu.sell.enums.ProductStatuEnum;
import com.shu.sell.repository.ProductInfoRepository;
import com.shu.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>商品服务实现</h1>
 *
 * @author yang
 * @date 2019/6/13 23:13
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductInfoRepository repository;

    public ProductServiceImpl(ProductInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatuEnum.UP.getCode());
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
