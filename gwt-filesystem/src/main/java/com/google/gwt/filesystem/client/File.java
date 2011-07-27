package com.google.gwt.filesystem.client;

import java.util.Date;

import com.google.gwt.core.client.JsDate;

/**
 * This interface describes a single file in a FileList and exposes its name.
 * It inherits from Blob.
 * 
 * @author Brad Rydzewski
 *
 */
public class File extends Blob {

	protected File() {

	}

    public final native String getName() /*-{
		return this.name;
	}-*/;

    @SuppressWarnings("deprecation")
	public final Date getLastModifiedDate() {
		JsDate jsDate = this.getLastModifiedDateNative();
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
	};
    
    public final native JsDate getLastModifiedDateNative() /*-{
		return this.lastModifiedDate;
	}-*/;
}
