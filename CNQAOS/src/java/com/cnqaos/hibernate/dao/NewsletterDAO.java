package com.cnqaos.hibernate.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnqaos.hibernate.pojo.Newsletter;

/**
 * A data access object (DAO) providing persistence and search support for
 * Newsletter entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cnqaos.hibernate.pojo.Newsletter
 * @author MyEclipse Persistence Tools
 */
public class NewsletterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(NewsletterDAO.class);
	// property constants
	public static final String FILENAME = "filename";
	public static final String FILE = "file";
	public static final String DESCRIPTION = "description";

	public void save(Newsletter transientInstance) {
		log.debug("saving Newsletter instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Newsletter persistentInstance) {
		log.debug("deleting Newsletter instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Newsletter findById(java.lang.Integer id) {
		log.debug("getting Newsletter instance with id: " + id);
		try {
			Newsletter instance = (Newsletter) getSession().get(
					"com.cnqaos.hibernate.pojo.Newsletter", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Newsletter instance) {
		log.debug("finding Newsletter instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cnqaos.hibernate.pojo.Newsletter")
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
		log.debug("finding Newsletter instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Newsletter as model where model."
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
		log.debug("finding all Newsletter instances");
		try {
			String queryString = "from Newsletter";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Newsletter merge(Newsletter detachedInstance) {
		log.debug("merging Newsletter instance");
		try {
			Newsletter result = (Newsletter) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Newsletter instance) {
		log.debug("attaching dirty Newsletter instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Newsletter instance) {
		log.debug("attaching clean Newsletter instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}