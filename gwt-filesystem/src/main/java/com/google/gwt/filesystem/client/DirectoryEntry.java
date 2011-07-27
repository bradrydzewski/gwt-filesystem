package com.google.gwt.filesystem.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a directory on a file system.
 * 
 * @see http://dev.w3.org/2009/dap/file-system/pub/FileSystem/#idl-def-DirectoryEntry
 * @author Brad Rydzewski
 *
 * <span style="color:red">Experimental API: This API is still under development
 * and is subject to change.</span>
 */
public class DirectoryEntry extends Entry {

	protected DirectoryEntry() {
		
	}

	/**
	 * Creates a new {@link DirectoryReader} to read Entries from this Directory.
	 * @return A new {@link DirectoryReader}.
	 */
    public final native DirectoryReader createReader() /*-{
    	return this.createReader();
    }-*/;
   
    /**
     * Creates or looks up a file.
     * @param path
     * 			Either an absolute path or a relative path from this DirectoryEntry
     * 			to the file to be looked up or created. It is an error to attempt
     * 			to create a file whose immediate parent does not yet exist.
     * @param options
     * @param successCallback
     * 			A callback that is called to return the {@link File} selected or created.
     * @param errorCallback
     * 			A callback that is called when errors happen.
     */
    public final native void getFile(String path, Flags options, Callback<Entry, FileError> callback) /*-{
    	
		var success = $entry(function(entry) {
			@com.google.gwt.filesystem.client.Entry::handleSuccess(*)
			(callback, entry);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.Entry::handleEntryFailure(*)
			(callback, err);
		});
		
		var flags = @com.google.gwt.filesystem.client.DirectoryEntry::toJso(*)(options);

    	this.getFile(path, flags, success, failure);
    }-*/;

    /**
     * Creates or looks up a directory.
     * @param path
     * 			Either an absolute path or a relative path from this DirectoryEntry
     * 			to the file to be looked up or created. It is an error to attempt
     * 			to create a file whose immediate parent does not yet exist.
     * @param options
     * @param successCallback
     * 			A callback that is called to return the {@link File} selected or created.
     * @param errorCallback
     * 			A callback that is called when errors happen.
     */
    public final native void getDirectory(String path, Flags options, Callback<Entry, FileError> callback) /*-{
    	
		var success = $entry(function(entry) {
			@com.google.gwt.filesystem.client.Entry::handleSuccess(*)
			(callback, entry);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.Entry::handleEntryFailure(*)
			(callback, err);
		});

		var flags = @com.google.gwt.filesystem.client.DirectoryEntry::toJso(*)(options);
    	
    	this.getDirectory(path, flags, success, failure);
    }-*/;

    /**
     * Deletes a directory and all of its contents, if any. In the event of an error
     * [e.g. trying to delete a directory that contains a file that cannot be removed],
     * some of the contents of the directory may be deleted. It is an error to attempt
     * to delete the root directory of a {@link FileSystem}.
     * 
     * @param callback A {@link Callback} that is called on success or failure.
     */
    public final native void removeRecursively(Callback<Void, FileError> callback) /*-{
    	
		var success = $entry(function(nothing) {
			@com.google.gwt.filesystem.client.Entry::handleVoidSuccess(*)
			(callback, nothing);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.Entry::handleVoidFailure(*)
			(callback, err);
		});
    	
    	this.removeRecursively(success, failure);
    }-*/;

    static native JavaScriptObject toJso(Flags flags) /*-{
    	var opt = {};
    	opt.exclusive = flags.@com.google.gwt.filesystem.client.Flags::exclusive;
	    opt.create    = flags.@com.google.gwt.filesystem.client.Flags::create;

    	return opt;
  	}-*/;
}
