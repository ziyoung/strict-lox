package net.ziyoung.lox.cmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cmd {
    private static final Logger logger = LoggerFactory.getLogger(Cmd.class);

    private String fileName;
    private boolean inspect;
    private final String[] args;
    private boolean passed = false;

    public Cmd(String[] args) {
        this.args = args;
    }

    public void parse() {
        if (args.length == 0) {
            logger.error("no arguments");
            return;
        }
        for (String arg: args) {
            if ("-inspect".equals(arg)) {
                inspect = true;
                continue;
            }
            if (!arg.startsWith("-") && fileName == null) {
                fileName = arg;
            }
        }
        if (fileName == null) {
            logger.error("file name is required");
            return;
        }
        if (!fileName.endsWith(".lox")) {
            logger.error("file name should end width .lox");
            return;
        }
        passed = true;
    }

    public String getFileName() {
        return fileName;
    }


    public boolean isInspect() {
        return inspect;
    }

    public boolean isPassed() {
        return passed;
    }
}
