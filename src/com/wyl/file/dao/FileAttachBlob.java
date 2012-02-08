package com.wyl.file.dao;

/**
 * FileAttachBlob entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class FileAttachBlob extends AbstractFileAttachBlob implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public FileAttachBlob() {
	}

	/** minimal constructor */
	public FileAttachBlob(String uids, String fileLsh) {
		super(uids, fileLsh);
	}

	/** full constructor */
	public FileAttachBlob(String uids, String fileLsh, String fileNr) {
		super(uids, fileLsh, fileNr);
	}

}
