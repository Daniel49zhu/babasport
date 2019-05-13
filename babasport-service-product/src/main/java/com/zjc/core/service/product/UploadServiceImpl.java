package com.zjc.core.service.product;

import org.springframework.stereotype.Service;

@Service(value="uploadService")
public class UploadServiceImpl implements UploadService{
    //上传图片
    public String uploadPic(byte[] pic ,String name,long size){
        return FastDFSUtils.uploadPic(pic, name, size);
    }
}
