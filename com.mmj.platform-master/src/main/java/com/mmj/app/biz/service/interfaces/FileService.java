/*
 * Copyright 2011-2016 MSUN.com All right reserved. This software is the confidential and proprietary information of
 * MSUN.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with MSUN.com.
 */
package com.mmj.app.biz.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

import com.mmj.app.biz.base.BaseService;
import com.mmj.app.biz.service.impl.FileServiceImpl.IFileCreate;
import com.mmj.app.biz.service.impl.FileServiceImpl.IFileHandle;
import com.mmj.app.common.result.Result;

/**
 * @author zxc Jun 30, 2014 3:19:39 PM
 */
public interface FileService extends BaseService {

    /**
     * 根据文件名生成临时文件路径
     * 
     * @param file
     * @param fileName
     * @return
     */
    Result createFilePath(MultipartFile file, String fileName);

    /**
     * 根据ID生成临时文件路径
     * 
     * @param file
     * @param fileName
     * @return
     */
    Result createFilePath(MultipartFile file, IFileCreate... ihandle);

    /**
     * 根据文件名字,生成真正的文件路径,IFileHandle特定的文件路径生成策略
     * 
     * @param fileName
     * @return
     */
    Result saveFileByName(String fileName, IFileHandle... ihandle);

    /**
     * 根据文件路径,生成真正的文件路径,IFileHandle特定的文件路径生成策略
     * 
     * @param filePath 文件临时路径
     * @return
     */
    Result saveFileByPath(String filePath, IFileHandle... ihandle);

    /**
     * 删除 真正的生成文件路径
     * 
     * @param fileName
     * @return
     */
    Result delFileByPath(String filePath);
}
