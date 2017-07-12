package com.shoppingmall.service;

import com.shoppingmall.common.ServerResponse;

/**
 * Created by zhenizhui on 2017/7/12.
 */
public interface IOrderService {
    ServerResponse createOrder(Integer userId, Integer shippingId);
}
