package com.jayson.collection.controller;

import com.jayson.collection.constant.StringConstant;
import com.jayson.collection.entity.common.WrapTipEntity;
import com.jayson.collection.util.StatusCode;
import com.jayson.collection.util.file.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileController {
    //头像
    private String FileHeadType = "1";
    //普通图片
    private String FilePicType = "2";

    /**
     * @param file 要上传的文件
     * @param type 文件类型
     * @return
     */
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public Object upload(MultipartFile file,
                         @RequestParam("type") String type) {
        // 要上传的目标文件存放路径
        String localPath = "";
        if (FileHeadType.equals(type)) {
            localPath = "F:/WEB_COLLECTION/image/head";
        } else if (FilePicType.equals(type)) {
            localPath = "F:/WEB_COLLECTION/image/picture";
        }
        // 上传成功或者失败的提示
        String msg = "";
        WrapTipEntity wrapResEntity = new WrapTipEntity();
        //上传并返回新的文件名字
        String newFileName = FileUtils.upload(file, localPath, file.getOriginalFilename());
        if (newFileName != null) {
            // 上传成功，给出页面提示
            msg = "上传成功！";
            wrapResEntity.setCode(StatusCode.CODE_SUCCESS);
            wrapResEntity.setContent(StringConstant.HostUrl + "head/" + newFileName);
        } else {
            msg = "上传失败！";
            wrapResEntity.setCode(StatusCode.CODE_ERROR);
            wrapResEntity.setContent("");
        }
        wrapResEntity.setMsg(msg);
        return wrapResEntity;
    }
}
