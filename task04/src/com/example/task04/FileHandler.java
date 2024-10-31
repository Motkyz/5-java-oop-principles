package com.example.task04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileHandler implements MessageHandler {

    private String _path;

    public FileHandler(String path)
    {
        _path = path;
    }

    @Override
    public void log(String message) {
        try
        {
            FileOutputStream record = new FileOutputStream(_path);
            byte[] messageBytes = message.getBytes();
            record.write(messageBytes);
            record.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
