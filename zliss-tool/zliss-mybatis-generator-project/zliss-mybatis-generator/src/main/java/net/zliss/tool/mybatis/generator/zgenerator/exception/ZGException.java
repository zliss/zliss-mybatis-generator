package net.zliss.tool.mybatis.generator.zgenerator.exception;

public class ZGException extends RuntimeException{
    private int code;
    private Exception sourceException;

    public ZGException(int code, String message, Exception s) {
        super(message);
        this.code = code;
        this.sourceException = s;
    }

    public int getCode() {
        return code;
    }

    public Exception getSourceException() {
        return sourceException;
    }
}
