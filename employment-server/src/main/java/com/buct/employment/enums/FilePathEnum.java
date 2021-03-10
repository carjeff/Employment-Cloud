package com.buct.employment.enums;

/**
 * 文件路径枚举类
 * @author Zhang JunFeng
 * @date 2021/1/5 15:54
 */
public enum FilePathEnum {
    IMG_PATH("img"),
    SINGER_PIC("singerPic"),
    USER_AVATAR("userAvatar"),
    USER_AVATAR_PATH(IMG_PATH,USER_AVATAR),
    SONG_PIC("songPic"),
    SINGER_PIC_PATH(IMG_PATH, SINGER_PIC),
    SONG_PIC_PATH(IMG_PATH, SONG_PIC),
    SONG_PATH("song/");

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
