package com.zhiliao.common.upload.bean;

import io.swagger.annotations.ApiModelProperty;

public class UploadBean {

    @ApiModelProperty("图片网址")
     private String fileUrl;

    @ApiModelProperty("图片绝对路径")
    private String fileRealPath;

    @ApiModelProperty("附件类型")
    private String fileType;

    @ApiModelProperty("图片相对路径")
    private String fileRelativePath;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileRealPath() {
        return fileRealPath;
    }

    public void setFileRealPath(String fileRealPath) {
        this.fileRealPath = fileRealPath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileRelativePath() {
        return fileRelativePath;
    }

    public void setFileRelativePath(String fileRelativePath) {
        this.fileRelativePath = fileRelativePath;
    }
}
