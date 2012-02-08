package com.wyl.file.dao;

/**
 * AbstractFileAttachBlob entity provides the base persistence definition of the
 * FileAttachBlob entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractFileAttachBlob implements java.io.Serializable {

	// Fields

	private String uids;
	private String fileLsh;
	private String fileNr;

	// Constructors

	/** default constructor */
	public AbstractFileAttachBlob() {
	}

	/** minimal constructor */
	public AbstractFileAttachBlob(String uids, String fileLsh) {
		this.uids = uids;
		this.fileLsh = fileLsh;
	}

	/** full constructor */
	public AbstractFileAttachBlob(String uids, String fileLsh, String fileNr) {
		this.uids = uids;
		this.fileLsh = fileLsh;
		this.fileNr = fileNr;
	}

	// Property accessors

	public String getUids() {
		return this.uids;
	}

	public void setUids(String uids) {
		this.uids = uids;
	}

	public String getFileLsh() {
		return this.fileLsh;
	}

	public void setFileLsh(String fileLsh) {
		this.fileLsh = fileLsh;
	}

	public String getFileNr() {
		return this.fileNr;
	}

	public void setFileNr(String fileNr) {
		this.fileNr = fileNr;
	}

}