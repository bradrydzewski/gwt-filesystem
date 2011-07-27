package com.google.gwt.filesystem.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a file system.
 * 
 * <p style="color:red">Experimental API: This API is still under development
 * and is subject to change.</p>
 * 
 * @see <a href="http://dev.w3.org/2009/dap/file-system/pub/FileSystem/#idl-def-FileSystem">HTML5 FileSystem Specification</a>
 * @author Brad Rydzewski
 *
 */
public class FileSystem extends JavaScriptObject {

	/**
	 * Used for storage with no guarantee of persistence.
	 * @see http://dev.w3.org/2009/dap/file-system/pub/FileSystem/#widl-LocalFileSystem-TEMPORARY
	 */
    public static final int TEMPORARY = 0;
    
    /**
     * Used for storage that should not be removed by the user agent without application or user permission.
     * @see http://dev.w3.org/2009/dap/file-system/pub/FileSystem/#widl-LocalFileSystem-PERSISTENT
     */
    public static final int PERSISTENT = 1;

    /**
     * Should be instantiated by {@link #requestFileSystem()}.
     */
	protected FileSystem() {
		
	}

	/**
	 * This is the name of the file system. The specifics of naming filesystems
	 * is unspecified, but a name must be unique across the list of exposed file systems.
	 * @return
	 */
    public native final String getName() /*-{
    	return this.name;
    }-*/;
    
    /**
     * The root directory of the file system.
     * @return
     */
    public native final DirectoryEntry getRoot() /*-{
    	return this.root;
    }-*/;

    /**
     * Requests a {link @FileSystem} in which to store application data.
     * @param type
     * 		Whether the {link @FileSystem} requested should be persistent,
     * 		as defined above. Use one of TEMPORARY or PERSISTENT.
     * @param size
     * 		This is an indicator of how much storage space, in bytes,
     * 		the application expects to need.
     * @param successCallback
     * 		The {link @Callback} that is called when the user agent provides a
     * 		{link @FileSystem}.
     * @param errorCallback
     * 		A {link @Callback} that is called when errors happen, or when the
     * 		request to obtain the {link @FileSystem} is denied.
     */
    public static final native void requestFileSystem(int type, int size,
    		Callback<FileSystem,FileError> callback) /*-{
	
		$wnd.requestFileSystem = $wnd.requestFileSystem || $wnd.webkitRequestFileSystem;
		
		var success = $entry(function(fs) {
			@com.google.gwt.filesystem.client.FileSystem::handleSuccess(*)
			(callback, fs);
		});

		var failure = $entry(function(err) {
			@com.google.gwt.filesystem.client.FileSystem::handleFailure(*)
			(callback, err);
		});
		
		$wnd.requestFileSystem(type, size, success, failure);
	}-*/;
    
    static final void handleSuccess(Callback<FileSystem,FileError> callback, FileSystem fs) {
    	callback.onSuccess(fs);
    }

    static final void handleFailure(Callback<FileSystem,FileError> callback, FileError err) {
    	callback.onFailure(err);
    }
}
