package com.google.gwt.filesystem.client;

@SuppressWarnings("serial")
public class FileException extends Throwable {

    public static final int NOT_FOUND_ERR = 1;
    public static final int SECURITY_ERR = 2;
    public static final int ABORT_ERR = 3;
    public static final int NOT_READABLE_ERR = 4;
    public static final int ENCODING_ERR = 5;
    public static final int NO_MODIFICATION_ALLOWED_ERR = 6;
    public static final int INVALID_STATE_ERR = 7;
    public static final int SYNTAX_ERR = 8;
    public static final int QUOTA_EXCEEDED_ERR = 10;
    
    private int code;
    
    public FileException(int code) {
    	this.code = code;
    }
    
    public int getCode() {
    	return code;
    }
}
