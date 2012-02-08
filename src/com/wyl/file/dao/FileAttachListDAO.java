package com.wyl.file.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for FileAttachList entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.wyl.file.dao.FileAttachList
  * @author MyEclipse Persistence Tools 
 */

public class FileAttachListDAO extends HibernateDaoSupport  {
    private static final Log log = LogFactory.getLog(FileAttachListDAO.class);
	//property constants
	public static final String PID = "pid";
	public static final String TRANSACTION_TYPE = "transactionType";
	public static final String TRANSACTION_ID = "transactionId";
	public static final String FILE_TYPE = "fileType";
	public static final String FILE_LSH = "fileLsh";
	public static final String FILE_NAME = "fileName";
	public static final String USERID = "userid";
	public static final String MEMO = "memo";
	public static final String DEPT_ID = "deptId";
	public static final String UNIT_ID = "unitId";
	public static final String TEMPLATE_ID = "templateId";
	public static final String TRANS_FLAG = "transFlag";
	public static final String TRANS_ID = "transId";
	public static final String IS_COMPRESS = "isCompress";
	public static final String FILE_SIZE = "fileSize";
	public static final String BLOB_TABLE = "blobTable";
	public static final String FILESOURCE = "filesource";



	protected void initDao() {
		//do nothing
	}
    
    public void save(FileAttachList transientInstance) {
        log.debug("saving FileAttachList instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FileAttachList persistentInstance) {
        log.debug("deleting FileAttachList instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FileAttachList findById( java.lang.String id) {
        log.debug("getting FileAttachList instance with id: " + id);
        try {
            FileAttachList instance = (FileAttachList) getHibernateTemplate()
                    .get("com.wyl.file.dao.FileAttachList", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FileAttachList instance) {
        log.debug("finding FileAttachList instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding FileAttachList instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FileAttachList as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPid(Object pid
	) {
		return findByProperty(PID, pid
		);
	}
	
	public List findByTransactionType(Object transactionType
	) {
		return findByProperty(TRANSACTION_TYPE, transactionType
		);
	}
	
	public List findByTransactionId(Object transactionId
	) {
		return findByProperty(TRANSACTION_ID, transactionId
		);
	}
	
	public List findByFileType(Object fileType
	) {
		return findByProperty(FILE_TYPE, fileType
		);
	}
	
	public List findByFileLsh(Object fileLsh
	) {
		return findByProperty(FILE_LSH, fileLsh
		);
	}
	
	public List findByFileName(Object fileName
	) {
		return findByProperty(FILE_NAME, fileName
		);
	}
	
	public List findByUserid(Object userid
	) {
		return findByProperty(USERID, userid
		);
	}
	
	public List findByMemo(Object memo
	) {
		return findByProperty(MEMO, memo
		);
	}
	
	public List findByDeptId(Object deptId
	) {
		return findByProperty(DEPT_ID, deptId
		);
	}
	
	public List findByUnitId(Object unitId
	) {
		return findByProperty(UNIT_ID, unitId
		);
	}
	
	public List findByTemplateId(Object templateId
	) {
		return findByProperty(TEMPLATE_ID, templateId
		);
	}
	
	public List findByTransFlag(Object transFlag
	) {
		return findByProperty(TRANS_FLAG, transFlag
		);
	}
	
	public List findByTransId(Object transId
	) {
		return findByProperty(TRANS_ID, transId
		);
	}
	
	public List findByIsCompress(Object isCompress
	) {
		return findByProperty(IS_COMPRESS, isCompress
		);
	}
	
	public List findByFileSize(Object fileSize
	) {
		return findByProperty(FILE_SIZE, fileSize
		);
	}
	
	public List findByBlobTable(Object blobTable
	) {
		return findByProperty(BLOB_TABLE, blobTable
		);
	}
	
	public List findByFilesource(Object filesource
	) {
		return findByProperty(FILESOURCE, filesource
		);
	}
	

	public List findAll() {
		log.debug("finding all FileAttachList instances");
		try {
			String queryString = "from FileAttachList";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public FileAttachList merge(FileAttachList detachedInstance) {
        log.debug("merging FileAttachList instance");
        try {
            FileAttachList result = (FileAttachList) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FileAttachList instance) {
        log.debug("attaching dirty FileAttachList instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FileAttachList instance) {
        log.debug("attaching clean FileAttachList instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static FileAttachListDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (FileAttachListDAO) ctx.getBean("FileAttachListDAO");
	}
}