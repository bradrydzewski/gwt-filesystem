package com.google.gwt.filesystem.client;


/**
 * This interface is used to supply arguments to methods that look up or
 * create files or directories.
 * 
 * @see http://dev.w3.org/2009/dap/file-system/pub/FileSystem/#idl-def-Flags
 * @author Brad Rydzewski
 */
public class Flags {
	
	private boolean create;
	private boolean exclusive;
	
	public Flags() {
		
	}
	
	public Flags(boolean create, boolean exclusive) {
		this.create = create;
		this.exclusive = exclusive;
	}

	public boolean isCreate() {
		return create;
	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	public boolean isExclusive() {
		return exclusive;
	}

	public void setExclusive(boolean exclusive) {
		this.exclusive = exclusive;
	}
}
