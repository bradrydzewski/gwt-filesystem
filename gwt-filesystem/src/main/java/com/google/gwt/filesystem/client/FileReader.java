package com.google.gwt.filesystem.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

/**
 * This class provides methods to read {@link File} objects or {@link Blob}
 * objects into memory, and to access the data from those Files or Blobs using
 * progress events and event handler attributes.
 * 
 * @see http://dev.w3.org/2006/webapi/FileAPI/#dfn-filereader
 * @author Brad Rydzewski
 * 
 * <span style="color:red">Experimental API: This API is still under development
 * and is subject to change.</span>
 */
public class FileReader extends JavaScriptObject  {

	public static final int EMPTY = 0;
	public static final int LOADING = 1;
	public static final int DONE = 2;
	
	protected FileReader() {
		
	}

	static protected EventBus EVENT_BUS = new SimpleEventBus();

	public final native void readAsArrayBuffer(Blob blob) /*-{
		this.readAsArrayBuffer(blob);
	}-*/;

	public final native void readAsBinaryString(Blob blob) /*-{
		this.readAsBinaryString(blob);
	}-*/;

	public final native void readAsText(Blob blob) /*-{
		this.readAsText(blob);
	}-*/;

	public final native void readAsText(Blob blob, String encoding) /*-{
		this.readAsText(blob, encoding);
	}-*/;

	public final native void readAsDataURL(Blob blob) /*-{
		this.readAsDataURL(blob);
	}-*/;

	public final native void abort() /*-{
		this.abort();
	}-*/;

	public final native int getReadyState() /*-{
		return this.readyState;
	}-*/;

	public final native String getResult() /*-{
		return this.result;
	}-*/;

	public final native String getResultAsString() /*-{
		return this.result;
	}-*/;

	public final native String getResultAsBlob() /*-{
		return this.result;
	}-*/;

	public final native void setCallback(FileReaderCallback callback) /*-{
		this.onloadstart = function(e) {
			@com.google.gwt.filesystem.client.FileReader::handleLoadStart(*)
			(callback, e);
		};
		this.onloadend = function(e) {
			@com.google.gwt.filesystem.client.FileReader::handleLoadEnd(*)
			(callback, e);
		};
		this.onload = function(e) {
			@com.google.gwt.filesystem.client.FileReader::handleLoad(*)
			(callback, e);
		};
		this.onabort = function(e) {
			@com.google.gwt.filesystem.client.FileReader::handleAbort(*)
			(callback, e);
		};
		this.onerror = function(e) {
			@com.google.gwt.filesystem.client.FileReader::handleError(*)
			(callback, e);
		};
		this.onprogress = function(e) {
			@com.google.gwt.filesystem.client.FileReader::handleProgress(*)
			(callback, e);
		};
	}-*/;

	static final void handleLoadStart(
			FileReaderCallback callback, ProgressEvent event) {
		callback.onLoadStart(event);
	}
	static final void handleLoadEnd(
			FileReaderCallback callback, ProgressEvent event) {
		callback.onLoadEnd(event);
	}
	static final void handleLoad(
			FileReaderCallback callback, ProgressEvent event) {
		callback.onLoad(event);
	}
	static final void handleAbort(
			FileReaderCallback callback, ProgressEvent event) {
		callback.onAbort(event);
	}
	static final void handleError(
			FileReaderCallback callback, ProgressEvent event) {
		callback.onError(event);
	}
	static final void handleProgress(
			FileReaderCallback callback, ProgressEvent event) {
		callback.onProgress(event);
	}
}
