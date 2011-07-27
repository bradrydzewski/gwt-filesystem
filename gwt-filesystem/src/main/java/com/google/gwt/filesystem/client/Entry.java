package com.google.gwt.filesystem.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An abstract interface representing entries in a {@link FileSystem}, each of which
 * may be a {@link File} or {@link DirectoryEntry}.
 * 
 * @author Brad Rydzewski
 *
 */
public class Entry extends JavaScriptObject {

	protected Entry() {
		
	}

    public final native boolean isFile() /*-{
    	return this.isFile;
    }-*/;

    public final native boolean isDirectory() /*-{
    	return this.isDirectory;
    }-*/;

    public final native String getName() /*-{
    	return this.name;
    }-*/;
    
    public final native String getFullPath() /*-{
		return this.fullPath;
	}-*/;

    public final native FileSystem getFileSystem() /*-{
		return this.filesystem;
	}-*/;

    public final native String toURL() /*-{
		return this.toUrl();
	}-*/;

    public final native String toURL(String mimeType) /*-{
		return this.toUrl(mimeType);
	}-*/;

    public native final void getMetadata(Callback<Metadata, FileError> callback) /*-{
    	
		var success = $entry(function(meta) {
			@com.google.gwt.filesystem.client.Entry::handleMetadataSuccess(*)
			(callback, meta);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.Entry::handleMetadataFailure(*)
			(callback, err);
		});
    	
    	this.getMetadata(success, failure);
    }-*/;

    public native final void moveTo(DirectoryEntry parent, String newName, Callback<Entry, FileError> callback) /*-{
    	
		var success = $entry(function(entry) {
			@com.google.gwt.filesystem.client.Entry::handleSuccess(*)
			(callback, entry);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.Entry::handleEntryFailure(*)
			(callback, err);
		});
    	
    	this.moveTo(parent, newName, success, failure);
    }-*/;

    public native final void copyTo(DirectoryEntry parent, String newName, Callback<Entry, FileError> callback) /*-{
    	
		var success = $entry(function(entry) {
			@com.google.gwt.filesystem.client.Entry::handleSuccess(*)
			(callback, entry);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.Entry::handleEntryFailure(*)
			(callback, err);
		});
    	
    	this.copyTo(parent, newName, success, failure)
    }-*/;

    public native final void remove(Callback<Void, FileError> callback) /*-{

		var success = $entry(function(nothing) {
			@com.google.gwt.filesystem.client.Entry::handleVoidSuccess(*)
			(callback, nothing);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.Entry::handleVoidFailure(*)
			(callback, err);
		});

    	this.remove(success, failure);
    }-*/;

    public native final void getParent(Callback<Entry, FileError> callback) /*-{
    	
		var success = $entry(function(entry) {
			@com.google.gwt.filesystem.client.Entry::handleSuccess(*)
			(callback, entry);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.Entry::handleEntryFailure(*)
			(callback, err);
		});
    	
    	this.getParent(success, failure);
    }-*/;


    static final void handleMetadataSuccess(Callback<Metadata,FileError> callback, Metadata meta) {
    	callback.onSuccess(meta);
    }

    static final void handleSuccess(Callback<Entry,FileError> callback, Entry entry) {
    	callback.onSuccess(entry);
    }

    static final void handleFileSuccess(Callback<File,FileError> callback, File file) {
    	callback.onSuccess(file);
    }

    static final void handleFileWriterSuccess(Callback<FileWriter,FileError> callback, FileWriter fileWriter) {
    	callback.onSuccess(fileWriter);
    }
    
    static final void handleVoidSuccess(Callback<Void,FileError> callback, Void nothing) {
    	callback.onSuccess(nothing);
    }

    static final void handleMetadataFailure(Callback<Metadata,FileError> callback, FileError err) {
    	callback.onFailure(err);
    }

    static final void handleEntryFailure(Callback<Entry,FileError> callback, FileError err) {
    	callback.onFailure(err);
    }

    static final void handleVoidFailure(Callback<Void,FileError> callback, FileError err) {
    	callback.onFailure(err);
    }

    static final void handleFileFailure(Callback<File,FileError> callback, FileError err) {
    	callback.onFailure(err);
    }

    static final void handleFileWriterFailure(Callback<FileWriter,FileError> callback, FileError err) {
    	callback.onFailure(err);
    }
}
