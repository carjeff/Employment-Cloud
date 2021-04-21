package com.buct.employment.enums;

/**
 * 文件路径枚举类
 * @author
 * @date 2021/1/5 15:54
 */
public enum FilePathEnum {
    IMG_PATH("img"),
    USER_AVATAR("userAvatar"),
    USER_AVATAR_PATH(IMG_PATH,USER_AVATAR),
    COMPANY_ICON("companyIcon"),
    COMPANY_ICON_PATH(IMG_PATH,COMPANY_ICON);


    private final String path;

    FilePathEnum(String path) {
        this.path = path;
    }

    FilePathEnum(FilePathEnum firstPath, FilePathEnum secondPath) {
        this.path = "/" + firstPath.getPath() + "/" + secondPath.getPath() + "/";
    }

    public String getPath() {
        return this.path;
    }
}
