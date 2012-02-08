package com.wyl.file.dao;

import java.util.Date;

/**
 * AbstractFileAttachList entity provides the base persistence definition of the
 * FileAttachList entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractFileAttachList implements java.io.Serializable {

	// Fields

	private String uids;
	private String pid;
	private String transactionType;
	private String transactionId;
	private String fileType;
	private String fileLsh;
	private String fileName;
	private Date uploadDate;
	private String userid;
	private String memo;
	private String deptId;
	private String unitId;
	private String templateId;
	private String transFlag;
	private String transId;
	private String isCompress;
	private Long fileSize;
	private String blobTable;
	private String filesource;

	// Constructors

	/** default constructor */
	public AbstractFileAttachList() {
	}

	/** minimal constructor */
	public AbstractFileAttachList(String uids, String pid,
			String transactionType, String transactionId, String fileLsh) {
		this.uids = uids;
		this.pid = pid;
		this.transactionType = transactionType;
		this.transactionId = transactionId;
		this.fileLsh = fileLsh;
	}

	/** full constructor */
	public AbstractFileAttachList(String uids, String pid,
			String transactionType, String transactionId, String fileType,
			String fileLsh, String fileName, Date uploadDate, String userid,
			String memo, String deptId, String unitId, String templateId,
			String transFlag, String transId, String isCompress, Long fileSize,
			String blobTable, String filesource) {
		this.uids = uids;
		this.pid = pid;
		this.transactionType = transactionType;
		this.transactionId = transactionId;
		this.fileType = fileType;
		this.fileLsh = fileLsh;
		this.fileName = fileName;
		this.uploadDate = uploadDate;
		this.userid = userid;
		this.memo = memo;
		this.deptId = deptId;
		this.unitId = unitId;
		this.templateId = templateId;
		this.transFlag = transFlag;
		this.transId = transId;
		this.isCompress = isCompress;
		this.fileSize = fileSize;
		this.blobTable = blobTable;
		this.filesource = filesource;
	}

	// Property accessors

	public String getUids() {
		return this.uids;
	}

	public void setUids(String uids) {
		this.uids = uids;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileLsh() {
		return this.fileLsh;
	}

	public void setFileLsh(String fileLsh) {
		this.fileLsh = fileLsh;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getUnitId() {
		return this.unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTransFlag() {
		return this.transFlag;
	}

	public void setTransFlag(String transFlag) {
		this.transFlag = transFlag;
	}

	public String getTransId() {
		return this.transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getIsCompress() {
		return this.isCompress;
	}

	public void setIsCompress(String isCompress) {
		this.isCompress = isCompress;
	}

	public Long getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getBlobTable() {
		return this.blobTable;
	}

	public void setBlobTable(String blobTable) {
		this.blobTable = blobTable;
	}

	public String getFilesource() {
		return this.filesource;
	}

	public void setFilesource(String filesource) {
		this.filesource = filesource;
	}

}