package com.zjc.core.service.product;

import org.springframework.stereotype.Service;

import java.io.*;

@Service(value = "uploadService")
public class UploadServiceImpl implements UploadService {
    //上传图片
    public String uploadPic(byte[] pic, String name, long size) {
        File image = new File("D:\\ImageRepo\\" + name);
        try (OutputStream os = new FileOutputStream(image)) {
            os.write(pic);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public File getPic(String name) {
        return new File("D:\\ImageRepo\\" + name);
    }
}
