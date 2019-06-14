package com.shu.sell.service.impl;

import com.shu.sell.dataobject.OrderDetail;
import com.shu.sell.dataobject.OrderMaster;
import com.shu.sell.dataobject.ProductInfo;
import com.shu.sell.dto.CartDTO;
import com.shu.sell.dto.OrderDTO;
import com.shu.sell.enums.ResultEnum;
import com.shu.sell.exception.SellException;
import com.shu.sell.repository.OrderDetailRepository;
import com.shu.sell.repository.OrderMasterRepository;
import com.shu.sell.service.OrderService;
import com.shu.sell.service.ProductService;
import com.shu.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>Order服务实现</h1>
 *
 * @author yang
 * @date 2019/6/14 16:56
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final ProductService productService;

    private final OrderDetailRepository detailRepository;

    private final OrderMasterRepository masterRepository;

    public OrderServiceImpl(ProductService productService, OrderDetailRepository detailRepository, OrderMasterRepository masterRepository) {
        this.productService = productService;
        this.detailRepository = detailRepository;
        this.masterRepository = masterRepository;
    }

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        BigDecimal orderAmount = new BigDecimal(0);
        String orderId = KeyUtil.genUniqueKey();
        //查询商品(数量,价格)
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //计算订单总价
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
            //写入订单详情orderDetail
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            detailRepository.save(orderDetail);
        }
        //写入订单master
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        masterRepository.save(orderMaster);
        //扣库存
        List<CartDTO> collect = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productService.decreaseStock(collect);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
