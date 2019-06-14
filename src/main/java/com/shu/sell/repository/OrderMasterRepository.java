package com.shu.sell.repository;

import com.shu.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>OrderMaster dao接口</h1>
 *
 * @author yang
 * @date 2019/6/14 14:47
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    /**
     * 根据OpenId分页查询
     *
     * @param buyerOpenId 买家openid
     * @param pageable    {@link Pageable}
     * @return {@link OrderMaster}
     */
    Page<OrderMaster> findByBuyerOpenId(String buyerOpenId, Pageable pageable);
}
