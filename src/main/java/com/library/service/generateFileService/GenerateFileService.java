package com.library.service.generateFileService;


import java.io.File;
import java.util.List;

public interface GenerateFileService {


    public void setGenerateFile(File fileTxt);

    public  File setFileTxtWriter(String header, List<String> datas,File fileCreate);

    public  File setFileCsvWriter(String[] header, List<String[]> datas,File fileCreate);

    public File setFileTxtNullDataWriter (String header, File fileCreate);
    public File setFileCsvNullDataWriter (String[] header, File fileCreate);
}
