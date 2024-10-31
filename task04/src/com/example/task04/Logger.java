package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Logger {
    private static final HashMap<String, Logger> _loggers = new HashMap<String, Logger>();
    private static ArrayList<MessageHandler> _handlers = new ArrayList<>();
    private final String Name;
    private ImportanceLevels Level;

    public Logger(String name)
    {
        Name = name;
        Level = ImportanceLevels.INFO;
        _loggers.put(name, this);
        _handlers.add(new ConsoleHandler());
    }

    public Logger(String name, ArrayList<MessageHandler> handlers)
    {
        Name = name;
        Level = ImportanceLevels.INFO;
        _loggers.put(name, this);
        _handlers = handlers;
    }

    public Logger(String name, ImportanceLevels level, ArrayList<MessageHandler> handlers)
    {
        Name = name;
        Level = level;
        _loggers.put(name, this);
        _handlers = handlers;
    }

    public String getName()
    {
        return Name;
    }

    public static Logger getLogger(String name)
    {
        if (_loggers.get(name) == null)
        {
            _loggers.put(name, new Logger(name));
        }
        return _loggers.get(name);
    }

    public void log(ImportanceLevels level, String message)
    {
        if (Level.ordinal() <= level.ordinal())
        {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String logMessage = MessageFormat.format("[{0}] {1} {2} - {3}", level, date, Name, message);

            for(MessageHandler handler : _handlers)
            {
                handler.log(logMessage);
            }
        }
    }

    public void log(ImportanceLevels level, String format, Object... args)
    {
        if (Level.ordinal() <= level.ordinal())
        {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String message = MessageFormat.format(format, args);
            String logMessage = MessageFormat.format("[{0}] {1} {2} - {3}", level, date, Name, message);

            for(MessageHandler handler : _handlers)
            {
                handler.log(logMessage);
            }
        }
    }

    public void setLevel(ImportanceLevels level)
    {
        Level = level;
    }
    public ImportanceLevels getLevel()
    {
        return Level;
    }

    public void set_handlers(ArrayList<MessageHandler> handlers)
    {
        _handlers = handlers;
    }

    public void debug(String message)
    {
        log(ImportanceLevels.DEBUG, message);
    }
    public void debug(String format, Object... args)
    {
        log(ImportanceLevels.DEBUG, format, args);
    }

    public void info(String message)
    {
        log(ImportanceLevels.INFO, message);
    }
    public void info(String format, Object... args)
    {
        log(ImportanceLevels.INFO, format, args);
    }

    public void warning(String message)
    {
        log(ImportanceLevels.WARNING, message);
    }
    public void warning(String format, Object... args)
    {
        log(ImportanceLevels.WARNING, format, args);
    }

    public void error(String message)
    {
        log(ImportanceLevels.ERROR, message);
    }
    public void error(String format, Object... args)
    {
        log(ImportanceLevels.ERROR, format, args);
    }
}
