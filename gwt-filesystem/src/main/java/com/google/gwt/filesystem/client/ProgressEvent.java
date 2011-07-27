package com.google.gwt.filesystem.client;

import com.google.gwt.dom.client.NativeEvent;

/**
 * A progress event occurs when the user agent makes progress in some data
 * transfer operation
 * 
 * @author Brad Rydzewski
 * 
 */
public final class ProgressEvent extends NativeEvent {

	protected ProgressEvent() {

	}

	/**
	 * This parameter specifies the total number of bytes already loaded.
	 */
	public native int getLoaded() /*-{
		return this.loaded;
	}-*/;

	/**
	 * This specifies the total number of bytes to be loaded. If
	 * lengthComputable is false, this must be zero.
	 */
	public native int getTotal() /*-{
		return this.total;
	}-*/;

	/**
	 * If the user agent has reliable information about the value of total, then
	 * this should be true. If the user agent does not have reliable information
	 * about the vale of total, this should be false.
	 */
	public native boolean isLengthComputable() /*-{
		return this.lengthComputable;
	}-*/;

	/**
	 * Returns a file's data in string format, or null, depending on the read
	 * method that has been called on the FileReader object.
	 */
	public native String getResult() /*-{
		return this.target.result;
	}-*/;

	/**
	 * The state of the FileReader, which can only be set to one of the
	 * following values: {@link READY}, {@link LOADING}, and {@link DONE}.
	 */
	public native int getReadyState() /*-{
		return this.target.readyState;
	}-*/;

	/**
	 * The error code associated with the file read error.
	 * 
	 * @return
	 */
	public native int getErrorCode() /*-{
		return this.target.error.code;
	}-*/;

}
