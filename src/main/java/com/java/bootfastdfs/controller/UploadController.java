package com.java.bootfastdfs.controller;

import com.java.bootfastdfs.service.UploadServcice;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName UploadController
 * @Description TODO
 * @Author itw_zhaowg
 * @Date 2019/7/10 20:32
 **/
@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private UploadServcice uploadServcice;

    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String url = this.uploadServcice.upload(file);
        if (StringUtils.isBlank(url)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok(url);
    }
}
