package com.shoppingmall.service;

import com.shoppingmall.common.ServerResponse;
import com.shoppingmall.pojo.Product;

/**
 * Created by zhenizhui on 2017/6/17.
 */
public interface IProductService {

    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId,Integer status);
}