package com.google.gwt.filesystem.client;

public abstract class FileWriterCallback {
	public void onWriteStart(FileWriter writer) { }
	public void onProgress(FileWriter writer) { }
	public abstract void onWrite(FileWriter writer);
	public void onAbort(FileWriter writer){ }
	public abstract void onError(FileWriter writer);
	public void onWriteEnd(FileWriter writer){ }
}
