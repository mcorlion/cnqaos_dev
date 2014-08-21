package com.cnqaos.hibernate.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnqaos.hibernate.pojo.PressRelease;

/**
 * A data access object (DAO) providing persistence and search support for
 * PressRelease entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cnqaos.hibernate.pojo.PressRelease
 * @author MyEclipse Persistence Tools
 */
public class PressReleaseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PressReleaseDAO.class);
	// property constants
	public static final String FILENAME = "filename";
	public static final String FILE = "file";
	public static final String DESCRIPTION = "description";

	public void save(PressRelease transientInstance) {
		log.debug("saving PressRelease instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PressRelease persistentInstance) {
		log.debug("deleting PressRelease instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PressRelease findById(java.lang.Integer id) {
		log.debug("getting PressRelease instance with id: " + id);
		try {
			PressRelease instance = (PressRelease) getSession().get(
					"com.cnqaos.hibernate.pojo.PressRelease", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PressRelease instance) {
		log.debug("finding PressRelease instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cnqaos.hibernate.pojo.PressRelease")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding PressRelease instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PressRelease as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}

	public List findByFile(Object file) {
		return findByProperty(FILE, file);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all PressRelease instances");
		try {
			String queryString = "from PressRelease";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PressRelease merge(PressRelease detachedInstance) {
		log.debug("merging PressRelease instance");
		try {
			PressRelease result = (PressRelease) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PressRelease instance) {
		log.debug("attaching dirty PressRelease instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PressRelease instance) {
		log.debug("attaching clean PressRelease instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}