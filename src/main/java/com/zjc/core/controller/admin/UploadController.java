package com.zjc.core.controller.admin;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.zjc.common.web.ResponseUtils;
import com.zjc.core.web.Constants;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class UploadController {
    //上传图片
    @RequestMapping(value = "/upload/uploadPic.do")
    public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletRequest request, HttpServletResponse response) {
//扩展名
        String ext = FilenameUtils.getExtension(pic.getOriginalFilename());

        //图片名称生成策略
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //图片名称一部分
        String format = df.format(new Date());

        //随机三位数
        Random r = new Random();
        // n 1000   0-999   99
        for (int i = 0; i < 3; i++) {
            format += r.nextInt(10);
        }

        //实例化一个Jersey
        String root = request.getServletContext().getRealPath("\\");
        //保存数据库
        String url = "/res/imagerepo/" + format + "." + ext;
        String path = root + url;

        InputStream ins = null;
        FileOutputStream outStream = null;
        try  {
            ins = pic.getInputStream();
            File imageFile = new File(path);
            //判断父目录是否存在，如果不存在，则创建
            if (imageFile.getParentFile() != null && !imageFile.getParentFile().exists()) {
                imageFile.getParentFile().mkdirs();
            }
            outStream = new FileOutputStream(imageFile);
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕
            int len = 0;
            //使用一个输入流从buffer里把数据读取出来
            while ((len = ins.read(buffer)) != -1) {
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                outStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //返回二个路径
        JSONObject jo = new JSONObject();
        jo.put("url", url);
        jo.put("path", url);

        ResponseUtils.renderJson(response, jo.toString());
    }
}
