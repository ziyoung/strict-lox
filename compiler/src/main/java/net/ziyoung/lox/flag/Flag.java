package net.ziyoung.lox.flag;

public class Flag {

    private final String[] args;
    private String fileName;
    private boolean inspect;
    private boolean genFile = false;
    private boolean passed = false;

    public Flag(String[] args) {
        this.args = args;
    }

    public void parse() {
        if (args.length == 0) {
            System.err.println("no arguments");
            return;
        }
        for (String arg : args) {
            if ("-inspect".equals(arg)) {
                inspect = true;
                continue;
            }
            if (!arg.startsWith("-") && fileName == null) {
                fileName = arg;
            }
            if ("-generate".equals(arg)) {
                genFile = true;
            }
        }
        if (fileName == null) {
            System.err.println("file name is required");
            return;
        }
        if (!fileName.endsWith(".lox")) {
            System.err.println("file name should end width .lox");
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

    public boolean isGenFile() {
        return genFile;
    }

    public boolean isPassed() {
        return passed;
    }
}
