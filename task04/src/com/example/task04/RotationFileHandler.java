package com.example.task04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.File;

public class RotationFileHandler implements MessageHandler {

    private String _path;
    private ChronoUnit _period;

    @Override
    public void log(String message)
    {
        String time = LocalDateTime.now().truncatedTo(_period).format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh"));
        try
        {
            File file = new File(_path + time + ".txt");
            FileOutputStream record = new FileOutputStream(file);
            byte[] messageBytes = message.getBytes();
            record.write(messageBytes);
            record.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
