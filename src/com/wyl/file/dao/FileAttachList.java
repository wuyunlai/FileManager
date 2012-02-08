package com.wyl.file.dao;

import java.util.Date;

/**
 * FileAttachList entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class FileAttachList extends AbstractFileAttachList implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public FileAttachList() {
	}

	/** minimal constructor */
	public FileAttachList(String uids, String pid, String transactionType,
			String transactionId, String fileLsh) {
		super(uids, pid, transactionType, transactionId, fileLsh);
	}

	/** full constructor */
	public FileAttachList(String uids, String pid, String transactionType,
			String transactionId, String fileType, String fileLsh,
			String fileName, Date uploadDate, String userid, String memo,
			String deptId, String unitId, String templateId, String transFlag,
			String transId, String isCompress, Long fileSize, String blobTable,
			String filesource) {
		super(uids, pid, transactionType, transactionId, fileType, fileLsh,
				fileName, uploadDate, userid, memo, deptId, unitId, templateId,
				transFlag, transId, isCompress, fileSize, blobTable, filesource);
	}

}
