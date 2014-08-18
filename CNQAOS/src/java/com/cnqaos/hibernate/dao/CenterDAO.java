package com.cnqaos.hibernate.dao;

import com.cnqaos.hibernate.pojo.Center;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Center entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cnqaos.hibernate.pojo.Center
 * @author MyEclipse Persistence Tools
 */
public class CenterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CenterDAO.class);
	// property constants
	public static final String CENTER_NAME = "centerName";
	public static final String CENTER_ADDRESS = "centerAddress";
	public static final String STREET = "street";
	public static final String CITY = "city";
	public static final String PIN = "pin";
	public static final String DESCRIPTION = "description";
        
	public void save(Center transientInstance) {
		log.debug("saving Center instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Center persistentInstance) {
		log.debug("deleting Center instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Center findById(java.lang.Integer id) {
		log.debug("getting Center instance with id: " + id);
		try {
			Center instance = (Center) getSession().get(
					"com.cnqaos.hibernate.pojo.Center", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Center instance) {
		log.debug("finding Center instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cnqaos.hibernate.pojo.Center")
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
		log.debug("finding Center instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Center as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCenterName(Object centerName) {
		return findByProperty(CENTER_NAME, centerName);
	}

	public List findByCenterAddress(Object centerAddress) {
		return findByProperty(CENTER_ADDRESS, centerAddress);
	}

	public List findByStreet(Object street) {
		return findByProperty(STREET, street);
	}

	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List findByPin(Object pin) {
		return findByProperty(PIN, pin);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all Center instances");
		try {
			String queryString = "from Center";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Center merge(Center detachedInstance) {
		log.debug("merging Center instance");
		try {
			Center result = (Center) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Center instance) {
		log.debug("attaching dirty Center instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Center instance) {
		log.debug("attaching clean Center instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}