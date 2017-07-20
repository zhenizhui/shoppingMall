package com.shoppingmall.service;

import com.shoppingmall.common.ServerResponse;

import java.util.Map;

/**
 * Created by zhenizhui on 2017/7/12.
 */
public interface IOrderService {

    ServerResponse createOrder(Integer userId, Integer shippingId);
    ServerResponse pay(Long orderNo, Integer userId, String path);
    ServerResponse aliCallback(Map<String,String> params);
    ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);
}
