package com.shoppingmall.service;

import com.github.pagehelper.PageInfo;
import com.shoppingmall.common.ServerResponse;
import com.shoppingmall.vo.OrderVo;

import java.util.Map;

/**
 * Created by zhenizhui on 2017/7/12.
 */
public interface IOrderService {

    ServerResponse createOrder(Integer userId, Integer shippingId);
    ServerResponse pay(Long orderNo, Integer userId, String path);
    ServerResponse aliCallback(Map<String,String> params);
    ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);
    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);
}
