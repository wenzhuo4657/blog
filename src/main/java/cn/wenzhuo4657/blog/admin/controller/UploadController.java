package cn.wenzhuo4657.blog.admin.controller;

import cn.wenzhuo4657.blog.admin.Enum.Code;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.exception.SystemException;
import cn.wenzhuo4657.blog.basic.utils.PathUtils;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static cn.wenzhuo4657.blog.basic.utils.qiniuyunUtils.upload;

/**
 * @className: UploadController
 * @author: wenzhuo4657
 * @date: 2024/8/31 14:43
 * @Version: 1.0
 * @description:
 */
@RestController
@Api("上传")
public class UploadController {

    @PostMapping("/upload")
    public ResponseResult  uploadImg(@RequestParam ("img")MultipartFile img){
        String ortname=img.getOriginalFilename();

        long size=img.getSize();
        if (size>2*1024*1024){
            throw  new RuntimeException("文件大小不合格");
        }
        if (!ortname.endsWith(".png")){
            throw  new RuntimeException("文件格式不合格");
        }
        String filepath= PathUtils.generateFilePath(ortname);
        String url=upload(img,filepath);


        return ResponseResult.okResult(url);
    }


}