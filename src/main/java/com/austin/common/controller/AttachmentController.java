package com.austin.common.controller;


import com.austin.common.core.bean.CodeMsg;
import com.austin.common.core.bean.Result;
import com.austin.common.entity.Attachment;
import com.austin.common.service.IAttachmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * 附件表 前端控制器
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/attachment")
@Api("附件前端控制器")
public class AttachmentController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IAttachmentService service;
    @Value("${file.upload-folder}")
    private String FILE_PATH;
    @Value("${file.pre-visit-url}")
    private String PRE_VISIT_URL;

    @ApiOperation(value = "上传文件", notes = "上传文件")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "form", name = "file", value = "文件对象", required = true, dataType = "__file"),
            }
    )
    @PostMapping(value = "/upload")
    private Result writeFile(@NotNull MultipartFile file) {
        Attachment at = new Attachment();
        byte[] bytes;
        Path result = null;
        try {
            bytes = file.getBytes();
            String fileName = file.getOriginalFilename();
            at.setFileName(fileName);
            String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            at.setExt(fileSuffix);
            String nowTimes = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + "-" + nowTimes + "." + fileSuffix;
            Path path = Paths.get(FILE_PATH + "/" + nowDate);
            if (!Files.isWritable(path)) Files.createDirectories(path);
            at.setCtime(LocalDateTime.now());
            at.setExt(fileSuffix);
            at.setUrl(PRE_VISIT_URL + "/" + nowDate + "/" + newFileName);
            this.service.save(at);
            result = Files.write(Paths.get(FILE_PATH + "/" + nowDate + "/" + newFileName), bytes);
        } catch (IOException e) {
            return Result.message(CodeMsg.OPERATE_FAIL);
        }
        return Result.success(at.getId());
    }


    @ApiOperation(value = "删除文件", notes = "删除文件")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "文件ID", required = true, dataType = "String"),
            }
    )
    @PostMapping(value = "/delete" , params = {"id"})
    private Result deleteFile(@NotNull String id){
        Attachment attachment = this.service.getById(id);


        File file = new File(attachment.getUrl());

        boolean result = file.delete();

        if(result) this.service.removeById(id);

        return Result.message(CodeMsg.OPERATE_SUCCESS);
    }


}

   