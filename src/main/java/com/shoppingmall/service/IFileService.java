package com.shoppingmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zhenizhui on 2017/6/17.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
