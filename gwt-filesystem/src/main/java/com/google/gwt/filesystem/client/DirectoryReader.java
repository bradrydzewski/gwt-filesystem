package com.google.gwt.filesystem.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Lets a user list files and directories in a directory.
 * 
 * @see http://dev.w3.org/2009/dap/file-system/pub/FileSystem/#idl-def-DirectoryReader
 * @author Brad Rydzewski
 * 
 * <span style="color:red">Experimental API: This API is still under development
 * and is subject to change.</span>
 */
public class DirectoryReader extends JavaScriptObject {

	/**
	 * Should create using {@link DirectoryEntry#createReader()}.
	 */
	protected DirectoryReader() {
		
	}

	/**
	 * Read the next block of entries from this directory.
	 * 
	 * @param successCallback
	 * 			Called once per successful call to readEntries to deliver the next
	 * 			previously-unreported set of Entries in the associated Directory.
	 * 			If all Entries have already been returned from previous invocations
	 * 			of readEntries, successCallback must be called with a zero-length
	 * 			array as an argument.
	 * 
	 * @param errorCallback
	 * 			A callback indicating that there was an error reading from the Directory.
	 */
	public final native void readEntries(Callback<Entry[], FileError> callback) /*-{
		
		var success = $entry(function(entries) {
			@com.google.gwt.filesystem.client.DirectoryReader::handleSuccess(*)
			(callback, entries);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.DirectoryReader::handleFailure(*)
			(callback, err);
		});
		
		this.readEntries(success, failure);
	}-*/;
	
    static final void handleSuccess(Callback<Entry[],FileError> callback, JsArray<Entry> entryArray) {
    	
    	Entry[] entries = new Entry[entryArray==null?0:entryArray.length()];
    	
    	for(int i=0;i<entries.length;i++) {
    		entries[i] = entryArray.get(i);
    	}

    	callback.onSuccess(entries);
    }

    static final void handleFailure(Callback<Entry[],FileError> callback, FileError err) {
    	callback.onFailure(err);
    }
}
