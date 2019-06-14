package com.shu.sell.service.impl;

import com.shu.sell.dataobject.ProductInfo;
import com.shu.sell.dto.CartDTO;
import com.shu.sell.enums.ProductStatuEnum;
import com.shu.sell.enums.ResultEnum;
import com.shu.sell.exception.SellException;
import com.shu.sell.repository.ProductInfoRepository;
import com.shu.sell.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <h1>商品服务实现</h1>
 *
 * @author yang
 * @date 2019/6/13 23:13
 */
@SuppressWarnings("AlibabaTransactionMustHaveRollback")
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

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDtoList) {
        for (CartDTO cartDTO : cartDtoList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (null == productInfo) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }


    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDtoList) {
        for (CartDTO cartDTO : cartDtoList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (null == productInfo) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
