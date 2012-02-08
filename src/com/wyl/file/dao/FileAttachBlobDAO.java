package com.wyl.file.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for FileAttachBlob entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.wyl.file.dao.FileAttachBlob
  * @author MyEclipse Persistence Tools 
 */

public class FileAttachBlobDAO extends HibernateDaoSupport  {
    private static final Log log = LogFactory.getLog(FileAttachBlobDAO.class);
	//property constants
	public static final String FILE_LSH = "fileLsh";
	public static final String FILE_NR = "fileNr";



	protected void initDao() {
		//do nothing
	}
    
    public void save(FileAttachBlob transientInstance) {
        log.debug("saving FileAttachBlob instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FileAttachBlob persistentInstance) {
        log.debug("deleting FileAttachBlob instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FileAttachBlob findById( java.lang.String id) {
        log.debug("getting FileAttachBlob instance with id: " + id);
        try {
            FileAttachBlob instance = (FileAttachBlob) getHibernateTemplate()
                    .get("com.wyl.file.dao.FileAttachBlob", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FileAttachBlob instance) {
        log.debug("finding FileAttachBlob instance by example");
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
      log.debug("finding FileAttachBlob instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FileAttachBlob as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByFileLsh(Object fileLsh
	) {
		return findByProperty(FILE_LSH, fileLsh
		);
	}
	
	public List findByFileNr(Object fileNr
	) {
		return findByProperty(FILE_NR, fileNr
		);
	}
	

	public List findAll() {
		log.debug("finding all FileAttachBlob instances");
		try {
			String queryString = "from FileAttachBlob";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public FileAttachBlob merge(FileAttachBlob detachedInstance) {
        log.debug("merging FileAttachBlob instance");
        try {
            FileAttachBlob result = (FileAttachBlob) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FileAttachBlob instance) {
        log.debug("attaching dirty FileAttachBlob instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FileAttachBlob instance) {
        log.debug("attaching clean FileAttachBlob instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static FileAttachBlobDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (FileAttachBlobDAO) ctx.getBean("FileAttachBlobDAO");
	}
}