package com.zjc.core.service.product;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service(value = "uploadService")
public class UploadServiceImpl implements UploadService {
    //上传图片
    public String uploadPic(byte[] pic, String name, long size) {
        String etc = FilenameUtils.getExtension(name);
        String formatDate = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String newName = formatDate+uuid+"."+etc;
        File image = new File("D:\\ImageRepo\\" + newName);
        try (OutputStream os = new FileOutputStream(image)) {
            os.write(pic);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newName;
    }

    @Override
    public File getPic(String name) {
        return new File("D:\\ImageRepo\\" + name);
    }
}
