package com.linhnt.vhttest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Override
    public void appendToFile(String fileName, String content) {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter("benchmark-result/" + fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.newLine();
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                log.error(ex.getMessage());
            }
        }
    }
}
