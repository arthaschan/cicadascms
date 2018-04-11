package com.zhiliao.common.upload;

import com.alibaba.fastjson.JSONObject;
import com.zhiliao.common.exception.ApiException;
import com.zhiliao.common.upload.bean.UploadBean;
import com.zhiliao.common.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadComponent uploadComponent;

    @RequestMapping
    public String upload(@RequestParam("file") MultipartFile multipartFile,
                         HttpServletRequest request){
        UploadBean result = uploadComponent.uploadFile(multipartFile,request);

        return JsonUtil.toUploadSUCCESS("上传成功！",result.getFileUrl());
    }


    @RequestMapping("/wangEditorUpload")
    public String WangEditorUpload(@RequestParam("file") MultipartFile multipartFile,
                         HttpServletRequest request) {
        UploadBean result = uploadComponent.uploadFile(multipartFile,request);
        return result.getFileUrl();

    }

    @RequestMapping("/CKEditorUpload")
    public String CKEditorUpload(@RequestParam("upload") MultipartFile multipartFile,
                                 HttpServletRequest request) {
        StringBuffer sb=new StringBuffer();
        UploadBean result = uploadComponent.uploadFile(multipartFile,request);
        sb.append("<script type=\"text/javascript\">");
        sb.append("window.parent.CKEDITOR.tools.callFunction("+ request.getParameter("CKEditorFuncNum") + ",'" +result.getFileRelativePath()+"','')");
        sb.append("</script>");
        return sb.toString();

    }

}
