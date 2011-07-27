package com.google.gwt.filesystem.client;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

/**
 * Supplies information about the state of a file or directory.
 * 
 * @see http://dev.w3.org/2009/dap/file-system/pub/FileSystem/#idl-def-Metadata
 * @author Brad Rydzewski
 */
public class Metadata extends JavaScriptObject {

	protected Metadata() {
		
	}
	
	@SuppressWarnings("deprecation")
	public final Date getModificationTime() {
		JsDate jsDate = getModificationTimeNative();
		Date date = null;
		
		//TODO: Find a better way to convert JsDate to java.util.Date
		if(jsDate!=null) {
			date = new Date();
			date.setYear(jsDate.getFullYear()-1900);
			date.setMonth(jsDate.getMonth());
			date.setDate(jsDate.getDate());
			date.setHours(jsDate.getHours());
			date.setMinutes(jsDate.getMinutes());
			date.setSeconds(jsDate.getSeconds());
		}
		
		return date;
	}

	public final native JsDate getModificationTimeNative() /*-{
		return this.modificationTime;
	}-*/;
}
