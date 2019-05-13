package com.zjc.core.service.product;

import java.io.File;

public interface UploadService {
	
	//上传图片
	String uploadPic(byte[] pic ,String name,long size);

	File getPic(String name);
}
