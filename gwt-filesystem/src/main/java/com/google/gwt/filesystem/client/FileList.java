package com.google.gwt.filesystem.client;
import com.google.gwt.core.client.JsArray;

/**
 * This interface exposes the list of files that have been selected.
 * 
 * @see http://dev.w3.org/2006/webapi/FileAPI/#dfn-filelist
 * @author Brad Rydzewski
 *
 */
public class FileList extends JsArray<File> {

	protected FileList() {
	
	}
}