package com.google.gwt.filesystem.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides methods to monitor the asynchronous writing of {@link Blob}
 * objects to disk using progress events and event handler attributes.
 * 
 * @see http://dev.w3.org/2009/dap/file-system/file-writer.html#the-filesaver-interface
 * @author Brad Rydzewski
 *
 * <span style="color:red">Experimental API: This API is still under development
 * and is subject to change.</span>
 */
public class FileSaver extends JavaScriptObject {

	/**
	 * The object has been constructed, but there is no pending write.
	 */
	public static final int INIT = 0;
	
	/**
	 * The {@link Blob} is being written.
	 */
	public static final int WRITING = 1;
	
	/**
	 * The entire {@link Blob} has been written to the file, a file error
	 * occurred during the write, or the write was aborted using abort().
	 * The {@link FileSaver} is no longer writing the {@link Blob}.
	 */
	public static final int DONE = 2;
	
	protected FileSaver(){
		
	}
	
	/**
	 * The {@link FileSaver} object can be in one of 3 states. The readyState
	 * attribute, on getting, will return the current state, which
	 * must be one of the following values: {@link #INIT}, {@link #DONE},
	 * or {@link #WRITING}.
	 * 
	 * @return Gets the readyState of the {@link FileSaver}
	 */
	public final native int getReadyState() /*-{
		return this.readyState;
	}-*/;
	
	/**
	 * The last error that occurred on the {@link FileSaver}.
	 * 
	 * @return Gets the last error that occurred.
	 */
	public final native int getError() /*-{
		return this.error;
	}-*/;
	
	/**
	 * This method will terminate any steps having to do with writing
	 * a {@link File} and will stop dispatching any further Progress Events.
	 */
	public final native void abort() /*-{ //throws FileException
		return this.abort();
	}-*/;


}
