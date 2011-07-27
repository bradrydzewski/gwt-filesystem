package com.google.gwt.filesystem.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Used to report errors {@link LocalFileSystem} and {@link FileWriter} errors asynchronously
 * 
 * @see http://dev.w3.org/2009/dap/file-system/pub/FileSystem/#idl-def-FileError
 * @author Brad Rydzewski
 */
public class FileError extends JavaScriptObject {

    public static final int NOT_FOUND_ERR = 1;
    public static final int SECURITY_ERR = 2;
    public static final int ABORT_ERR = 3;
    public static final int NOT_READABLE_ERR = 4;
    public static final int ENCODING_ERR = 5;
    public static final int NO_MODIFICATION_ALLOWED_ERR = 6;
    public static final int INVALID_STATE_ERR = 7;
    public static final int SYNTAX_ERR = 8;
    public static final int INVALID_MODIFICATION_ERR = 9;
    public static final int QUOTA_EXCEEDED_ERR = 10;
    public static final int TYPE_MISMATCH_ERR = 11;
    public static final int PATH_EXISTS_ERR = 12;

    protected FileError() {
    	
    }
    
    /**
     * The code attribute, on getting, must return one of the constants of the
     * FileError error, which must be the most appropriate code from the table below:
     * 
     * ABORT_ERR
     * ENCODING_ERR
     * INVALID_MODIFICATION_ERR
     * INVALID_STATE_ERR 
     * NOT_FOUND_ERR
     * NOT_READABLE_ERR
     * NO_MODIFICATION_ALLOWED_ERR
     * PATH_EXISTS_ERR
     * QUOTA_EXCEEDED_ERR
     * SECURITY_ERR
     * SYNTAX_ERR
     * TYPE_MISMATCH_ERR
     * 
     * @return
     */
    public final native int getCode() /*-{
    	return this.code;
    }-*/;
}
