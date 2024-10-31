package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {

    private int _maxSize;
    private ArrayList<String> _messages = new ArrayList<>();
    private ArrayList<MessageHandler> _handlers = new ArrayList<>();

    public MemoryHandler(int maxSize, ArrayList<MessageHandler> handlers)
    {
        _maxSize = maxSize;
        _handlers = handlers;
    }

    @Override
    public void log(String message)
    {
        _messages.add(message);
        if(_messages.size() >= _maxSize)
        {
            SendMsgsToHendlers();
        }
    }

    public void SendMsgsToHendlers()
    {
        for(MessageHandler handler : _handlers)
            for (String message : _messages)
            {
                handler.log(message);
            }
        _messages.clear();
    }
}
