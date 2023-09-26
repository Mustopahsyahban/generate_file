package com.library.service.generateFileService;

import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
@Service
public class GenerateFileServiceImp implements GenerateFileService{


    @Autowired
    HttpServletResponse response;

    @Override
    public void setGenerateFile(File fileTxt) {

        try {

            String url = "application/octet-stream";

            response.setContentType(url);

            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + fileTxt.getName()));

            response.setContentLength((int) fileTxt.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(fileTxt));

            FileCopyUtils.copy(inputStream, response.getOutputStream());

            fileTxt.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File setFileTxtWriter(String header, List<String> datas, File fileCreate) {

            try {
                FileWriter writer = new FileWriter(fileCreate);

                    writer.write(header);
                if (!datas.isEmpty()) {
                    for (String data : datas) {
                        writer.write(data);
                    }
                }
                writer.flush();
                writer.close();

                return fileCreate;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    public File setFileCsvWriter(String[] header, List<String[]> datas, File fileCreate) {
        try {
            FileOutputStream fos = new FileOutputStream(fileCreate);
            OutputStreamWriter writerOutput = new OutputStreamWriter(fos);
            CSVWriter writer = new CSVWriter(writerOutput, '|',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            writer.writeNext(header);
            writer.writeAll(datas);
            writer.flush();
            writer.close();

            return fileCreate;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public File setFileTxtNullDataWriter(String header, File fileCreate) {
        try {
            FileWriter writer = new FileWriter(fileCreate);
            writer.write(header);

            writer.flush();
            writer.close();

            return fileCreate;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public File setFileCsvNullDataWriter(String[] header, File fileCreate) {
        try {
            FileOutputStream fos = new FileOutputStream(fileCreate);
            OutputStreamWriter writerOutput = new OutputStreamWriter(fos);
            CSVWriter writer = new CSVWriter(writerOutput, '|',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            writer.writeNext(header);
            writer.flush();
            writer.close();

            return fileCreate;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
