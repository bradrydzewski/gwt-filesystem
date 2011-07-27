Summary
=======

This library adds browser-based FileSystem support to applications developed using Google Web Toolkit (GWT), based on the [HTML5 FileSystem specification](You can read the full specification at http://dev.w3.org/2009/dap/file-system/pub/FileSystem/)

> The HTML5 specification defines an API to navigate file system hierarchies, and defines a means by which a user agent may expose sandboxed sections of a user's local filesystem to web applications. In short,

In short, this enables a web applications to read and write files to and from a Virtual File System. A great use case for such and API would be enabling Google Docs in offline mode, where users could read an write to a File System without an internet connection, and sync with Google's servers when connected.

Getting Started
---------------

First, it is highly recommended that you familiarize yourself with the HTML5 FileSystem API. There is a fantastic article on HTML5 Rocks [http://www.html5rocks.com/en/tutorials/file/filesystem/](http://www.html5rocks.com/en/tutorials/file/filesystem/)
that walks you through all of the different functions and capabilities.

You will need to enable the FileSystem API in Google Chrome (as of version 14 canary) by adding the following flags:
    --unlimited-quota-for-files  --allow-file-access-from-files

You will need to either download the jar or compile and include the jar in your GWT project's build path. In addition, you will need to include the following reference to the library in your application's module xml file:
    <inherits name='com.google.gwt.filesystem.FileSystem' />

Example Code
============

The entire FileSystem API is asynchronous, which means there are a lot of callbacks involved.

The first step is to request a FileSystem

    FileSystem.requestFileSystem(FileSystem.PERSISTENT, 1024*1024, new Callback<FileSystem, FileError>() {
        
        public void onSuccess(FileSystem fileSystem) {
            
        }
    });

Create a File
-------------

To getFile method is dual-purposed to create and retrieve files. If a file doesn't exist, and you specify Flags#create=true,
the file will be created and returned in the callback if it doesn't already exist.

This example will create the file in the Root directory:

    fileSystem.getRoot().getFile("myfile.txt", new Flags(true, false),new Callback<Entry, FileError>() {

        @Override
        public void onSuccess(Entry result) {
            System.out.println("created file: " + result.getFullPath());
			FileEntry fileEntry = (FileEntry)result;
		}
    });

Create a Directory
------------------

    fileSystem.getRoot().getDirectory("/mydocuments", new Flags(true, false),new Callback<Entry, FileError>() {

        @Override
        public void onSuccess(Entry result) {
            System.out.println("created directory: " + result.getFullPath());
			DirectoryEntry dirEntry = (DirectoryEntry)result;
		}
    });



