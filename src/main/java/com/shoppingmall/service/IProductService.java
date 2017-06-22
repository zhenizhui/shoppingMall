package com.shoppingmall.service;

import com.github.pagehelper.PageInfo;
import com.shoppingmall.common.ServerResponse;
import com.shoppingmall.pojo.Product;
import com.shoppingmall.vo.ProductDetailVo;

/**
 * Created by zhenizhui on 2017/6/17.
 */
public interface IProductService {

    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId,Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName,Integer productId,int pageNum,int pageSize);
}
