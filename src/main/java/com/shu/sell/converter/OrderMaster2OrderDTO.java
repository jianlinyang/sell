package com.shu.sell.converter;

import com.shu.sell.dataobject.OrderMaster;
import com.shu.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>OrderMaster2OrderDTO转换器</h1>
 *
 * @author yang
 * @date 2019/6/14 21:18
 */
public class OrderMaster2OrderDTO {
    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(OrderMaster2OrderDTO::convert).collect(Collectors.toList());
    }
}
