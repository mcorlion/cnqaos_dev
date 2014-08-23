package com.cnqaos.hibernate.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnqaos.hibernate.pojo.UserMaster;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserMaster entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cnqaos.hibernate.pojo.UserMaster
 * @author MyEclipse Persistence Tools
 */
public class UserMasterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserMasterDAO.class);
	// property constants
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String SUR_NAME = "surName";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String CELLPHONE_NUMBER = "cellphoneNumber";
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String PASSWORD = "password";

	public void save(UserMaster transientInstance) {
		log.debug("saving UserMaster instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserMaster persistentInstance) {
		log.debug("deleting UserMaster instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserMaster findById(java.lang.Integer id) {
		log.debug("getting UserMaster instance with id: " + id);
		try {
			UserMaster instance = (UserMaster) getSession().get(
					"com.cnqaos.hibernate.pojo.UserMaster", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserMaster instance) {
		log.debug("finding UserMaster instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cnqaos.hibernate.pojo.UserMaster")
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
		log.debug("finding UserMaster instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserMaster as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findById(Object id) {
		return findByProperty(ID, id);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findBySurName(Object surName) {
		return findByProperty(SUR_NAME, surName);
	}

	public List findByPhoneNumber(Object phoneNumber) {
		return findByProperty(PHONE_NUMBER, phoneNumber);
	}

	public List findByCellphoneNumber(Object cellphoneNumber) {
		return findByProperty(CELLPHONE_NUMBER, cellphoneNumber);
	}

	public List findByEmailAddress(Object emailAddress) {
		return findByProperty(EMAIL_ADDRESS, emailAddress);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findAll() {
		log.debug("finding all UserMaster instances");
		try {
			String queryString = "from UserMaster";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserMaster merge(UserMaster detachedInstance) {
		log.debug("merging UserMaster instance");
		try {
			UserMaster result = (UserMaster) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserMaster instance) {
		log.debug("attaching dirty UserMaster instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserMaster instance) {
		log.debug("attaching clean UserMaster instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
        
        public List findAllStudents(){
            return null;
        }
}