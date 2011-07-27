package com.google.gwt.filesystem.client;

/**
 * Represents a file on a {@link FileSystem}.
 * 
 * @see http://dev.w3.org/2009/dap/file-system/pub/FileSystem/#the-fileentry-interface
 * @author Brad Rydzewski
 *
 */
public class FileEntry extends Entry {

	protected FileEntry(){
		
	}

	/**
	 * Creates a new {@link FileWriter} associated with the file that this
	 * {@link FileEntry} represents.
	 * 
	 * @param callback
	 */
    public native final void createWriter(Callback<FileWriter, FileError> callback) /*-{
    	
		var success = $entry(function(writer) {
			@com.google.gwt.filesystem.client.Entry::handleFileWriterSuccess(*)
			(callback, writer);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.Entry::handleFileWriterFailure(*)
			(callback, err);
		});
    	
    	this.createWriter(success, failure);
    	
    }-*/;

    /**
     * Returns a {@link File} that represents the current state of the file
     * that this {@link FileEntry} represents.
     * 
     * @param callback
     */
	public native final void file(Callback<File, FileError> callback) /*-{
    
		var success = $entry(function(file) {
			@com.google.gwt.filesystem.client.Entry::handleFileSuccess(*)
			(callback, file);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.Entry::handleFileFailure(*)
			(callback, err);
		});
    	
    	this.file(success, failure);
    }-*/;
}
