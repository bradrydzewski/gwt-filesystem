package com.google.gwt.filesystem.client;


/**
 * This class expands on the {@link FileSaver} interface to allow for
 * multiple write actions, rather than just saving a single {@link Blob}.
 * 
 * @see http://dev.w3.org/2009/dap/file-system/file-writer.html#the-filewriter-interface
 * @author Brad Rydzewski
 *
 * <span style="color:red">Experimental API: This API is still under development
 * and is subject to change.</span>
 */
public class FileWriter extends FileSaver {

	/**
	 * Instead use {@link #create()}
	 */
	protected FileWriter() {
		
	}

    public native final int getPosition() /*-{
    	return this.position;
    }-*/;
    
    public native final int getLength() /*-{
    	return this.length;
    }-*/;
    
    public native final void write(Blob data) throws FileException /*-{ //throws FileException
    	this.write(data);
    }-*/;

    public native final void seek(int offset) /*-{ // throws FileException
    	this.seek(offset);
    }-*/;

    public native final void truncate(int size) throws FileException /*-{
    	try {
    		this.truncate(size);
    	} catch (err) {
			@com.google.gwt.filesystem.client.FileWriter::handleFileException(*)(err.code);
    	}
    }-*/;

	static final void handleFileException(int code) throws FileException {
		throw new FileException(code);
	}
	
	public final void setCallback(FileWriterCallback callback) {
		setCallback(callback, this);
	}

	static final native void setCallback(FileWriterCallback callback,
			FileWriter writer) /*-{
		this.onwrite = function(e) {
			@com.google.gwt.filesystem.client.FileWriter::handleWrite(*)
			(callback, writer);
		};
		this.onwritestart = function(e) {
			@com.google.gwt.filesystem.client.FileWriter::handleWriteStart(*)
			(callback, writer);
		};
		this.onwriteend = function(e) {
			@com.google.gwt.filesystem.client.FileWriter::handleWriteEnd(*)
			(callback, writer);
		};
		this.onerror = function(e) {
			@com.google.gwt.filesystem.client.FileWriter::handleError(*)
			(callback, writer);
		};
		this.onabort = function(e) {
			@com.google.gwt.filesystem.client.FileWriter::handleAbort(*)
			(callback, writer);
		};
		this.onprogress = function(e) {
			@com.google.gwt.filesystem.client.FileWriter::handleProgress(*)
			(callback, writer);
		};
	
	}-*/;

	static final void handleWriteStart(
			FileWriterCallback callback, FileWriter writer) {
		callback.onWriteStart(writer);
	}
	
	static final void handleWriteEnd(
			FileWriterCallback callback, FileWriter writer) {
		callback.onWriteEnd(writer);
	}
	
	static final void handleError(
			FileWriterCallback callback, FileWriter writer) {
		callback.onError(writer);
	}
	
	static final void handleAbort(
			FileWriterCallback callback, FileWriter writer) {
		callback.onAbort(writer);
	}
	
	static final void handleWrite(
			FileWriterCallback callback, FileWriter writer) {
		callback.onWrite(writer);
	}
	
	static final void handleProgress(
			FileWriterCallback callback, FileWriter writer) {
		callback.onProgress(writer);
	}
}
