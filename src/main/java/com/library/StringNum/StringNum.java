package com.library.StringNum;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public enum StringNum {


    ADD_DATA_RBB_22C00 (1,"TEST"),

    FORMAT_DATE_STRIP_YYYYMMDD (2, "yyyy-MM-dd"),

    FORMAT_DATE_SLASH_YYYYMMDD (2, "dd/MM/yyyy"),

    LOCATION_FILE_GENERATE_TXT (4, FileSystems.getDefault().getPath("").toAbsolutePath()+"\\src\\main\\java\\com\\library\\files\\txt\\"),
    LOCATION_FILE_GENERATE_CSV (4, FileSystems.getDefault().getPath("").toAbsolutePath()+"\\src\\main\\java\\com\\library\\files\\csv\\")


    ;

    private int code;
    private String description;

    StringNum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static StringNum getStringNumType(final String description) {
        for (StringNum d : StringNum.values()) {
            if (d.getDescription().equalsIgnoreCase(description)) {
                return d;
            }
        }
        return null;
    }

}
