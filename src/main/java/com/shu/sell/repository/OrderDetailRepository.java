package com.shu.sell.repository;

import com.shu.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <h1>订单详情dao接口</h1>
 *
 * @author yang
 * @date 2019/6/14 14:50
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    /**
     * 根据orderId查询
     *
     * @param orderId id
     * @return {@link OrderDetail}
     */
    List<OrderDetail> findByOrderId(String orderId);
}
