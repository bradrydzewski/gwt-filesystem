package com.google.gwt.filesystem.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 * @see http://dev.w3.org/2009/dap/file-system/file-writer.html#the-blobbuilder-interface
 * @author Brad Rydzewski
 *
 * TODO: Implement the append(ArrayBuffer data) method
 * 
 * <span style="color:red">Experimental API: This API is still under development
 * and is subject to change.</span>
 */
public class BlobBuilder extends JavaScriptObject {

	/**
	 * Instead use {@link #create()} for a new BlobBuilder.
	 */
	protected BlobBuilder() {
		
	}

	public final native Blob getBlob() /*-{
    	return this.getBlob();
    }-*/;

    public final native Blob getBlob(String contentType) /*-{
    	return this.getBlob(contentType);
    }-*/;
    
    public final native void append(String text) throws FileException /*-{
    	try {
    		this.append(text);
    	} catch (err) {
			@com.google.gwt.filesystem.client.BlobBuilder::handleFileException(*)(err.code);
    	}
    }-*/;

    public final native void append(Blob data) /*-{
    	this.appent(data);
    }-*/;

	public static native BlobBuilder create() /*-{
		BlobBuilder = window.BlobBuilder || window.WebKitBlobBuilder || window.MozBlobBuilder || window.OperaBlobBuilder;
		return new BlobBuilder();
	}-*/;
	
	static final void handleFileException(int code) throws FileException {
		throw new FileException(code);
	}
}
