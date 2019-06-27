package com.shu.sell.controller;

import com.shu.sell.converter.OrderForm2OrderDTOConverter;
import com.shu.sell.dto.OrderDTO;
import com.shu.sell.enums.ResultEnum;
import com.shu.sell.exception.SellException;
import com.shu.sell.form.OrderForm;
import com.shu.sell.service.OrderService;
import com.shu.sell.utils.ResultVoUtils;
import com.shu.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * <h1>买家订单Controller</h1>
 *
 * @author yang
 * @date 2019/6/27 14:00
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    private final OrderService orderService;

    public BuyerOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 创建订单
     *
     * @param orderForm     {@link OrderForm}
     * @param bindingResult {@link BindingResult}
     * @return {@link ResultVO}
     */
    @PostMapping("/create")
    public ResultVO creat(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("创建订单参数不正确,orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);
        HashMap<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVoUtils.success(map);
    }

    //订单列表

    //订单详情

    //取消订单
}