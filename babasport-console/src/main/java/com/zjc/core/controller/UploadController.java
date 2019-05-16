package com.zjc.core.controller;

import com.zjc.core.service.product.UploadService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 图片上传使用FastDFS 此处省略配置分布式文件系统，直接保存在本机来简化配置流程
 */
@Controller
public class UploadController {
    @Autowired
    private UploadService uploadService;

    //上传图片
    @RequestMapping(value = "/upload/uploadPic.do")
    public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) throws IOException {

        String newName = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());

        JSONObject jo = new JSONObject();
        jo.put("url", "/upload/getPic.do?name=" + newName);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(jo.toString());

    }

    //上传多张图片
    @RequestMapping(value = "/upload/uploadPics.do")
    @ResponseBody
    public List<String> uploadPics(@RequestParam(required = false) MultipartFile[] pics, HttpServletResponse response) throws IOException {
        List<String> urls = new ArrayList<>();

        for (MultipartFile pic : pics) {
            String newName = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
            String url = "/upload/getPic.do?name=" + newName;
            urls.add(url);
        }
        return urls;
    }

    @RequestMapping(value = "/upload/getPic.do")
    public void getPic(String name, HttpServletResponse response) {
        File file = uploadService.getPic(name);
        byte[] buffer = new byte[1 << 10];
        try (OutputStream writer = response.getOutputStream();
             FileInputStream fis = new FileInputStream(file);) {
            while (fis.read(buffer) != -1) {
                writer.write(buffer);
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //上传富文本图片
    @RequestMapping(value = "/upload/uploadFck.do")
    public void uploadFck(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        //无敌版接收
        //强转Spring 提供  MultipartRequest
        MultipartRequest mr = (MultipartRequest) request;
        Map<String, MultipartFile> fileMap = mr.getFileMap();
        Set<Map.Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
        for (Map.Entry<String, MultipartFile> entry : entrySet) {
            MultipartFile pic = entry.getValue();

            String path = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());

            String url = "/upload/getPic.do?name=" + path;

            JSONObject jo = new JSONObject();
            jo.put("error", 0);
            jo.put("url", url);

            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(jo.toString());
        }


    }

}
