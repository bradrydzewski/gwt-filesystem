package com.google.gwt.filesystem.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * This interface represents immutable raw data. It provides a method to slice data
 * objects between ranges of bytes into further chunks of raw data. It also provides
 * an attribute representing the size of the chunk of data. The File interface inherits
 * from this interface.
 * 
 * @see http://dev.w3.org/2006/webapi/FileAPI/#dfn-Blob
 * @author Brad Rydzewski
 * 
 * <span style="color:red">Experimental API: This API is still under development
 * and is subject to change.</span>
 */
public class Blob extends JavaScriptObject {

	protected Blob() {
		
	}

	/**
	 * Returns the size of the Blob object in bytes. On getting, conforming user
	 * agents MUST return the total number of bytes that can be read by a FileReader
	 * or FileReaderSync object, or 0 if the Blob has no bytes to be read.
	 */
	private final native int getSize() /*-{
		return this.size;
	}-*/;

    private final native String getType() /*-{
		return this.type;
	}-*/;
    
    /**
     * Returns a new Blob object with bytes ranging from the optional start parameter
     * upto but not including the optional end parameter, and with a type attribute
     * that is the value of the optional contentType parameter.
     * @param optional
     * @return
     */
    public final native Blob slice() /*-{
		return this.slice();
	}-*/;

    public final native Blob slice(int start) /*-{
		return this.slice(start);
	}-*/;
    
    public final native Blob slice(int start, int end) /*-{
		return this.slice(start, end);
	}-*/;

    public final native Blob slice(int start, int end, String contentType) /*-{
		return this.slice(start, end, contentType);
	}-*/;
}
