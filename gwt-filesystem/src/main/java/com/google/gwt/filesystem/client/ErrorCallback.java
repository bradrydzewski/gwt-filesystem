package com.google.gwt.filesystem.client;

/**
 * 
 * When an Error occurs using the FileSystem, the ErrorCallback is made.
 * 
 * @see http://dev.w3.org/2009/dap/file-system/pub/FileSystem/#idl-def-ErrorCallback
 * @author Brad Rydzewski
 *
 */
public interface ErrorCallback {

	/**
	 * There was an error with the request. Details are provided by the
	 * FileError parameter.
	 * 
	 * @param err The error that was generated.
	 */
	void handleEvent (FileError err);
}
