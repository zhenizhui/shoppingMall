package com.shoppingmall.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhenizhui on 2017/7/9.
 */
public class QiNiuUtil {
    // ACCESS_KEY
    private static String ACCESS_KEY = PropertiesUtil.getProperty("QiNiu_ACCESS_KEY");
    // SECRET_KEY
    private static String SECRET_KEY = PropertiesUtil.getProperty("QiNiu_SECRET_KEY");
    // Bucket_Name
    private static String Bucket_Name = PropertiesUtil.getProperty("QiNiu_Bucket_Name");

    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    // 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();

    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);


    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(Bucket_Name);
    }

    public void upload(File targetFile) throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(targetFile.getPath(), targetFile.getName(), getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

}
