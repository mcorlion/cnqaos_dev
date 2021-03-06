package com.cnqaos.hibernate.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnqaos.hibernate.pojo.CenterTraining;

/**
 * A data access object (DAO) providing persistence and search support for
 * CenterTraining entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cnqaos.hibernate.pojo.CenterTraining
 * @author MyEclipse Persistence Tools
 */
public class CenterTrainingDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CenterTrainingDAO.class);

	// property constants

	public void save(CenterTraining transientInstance) {
		log.debug("saving CenterTraining instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CenterTraining persistentInstance) {
		log.debug("deleting CenterTraining instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CenterTraining findById(java.lang.Integer id) {
		log.debug("getting CenterTraining instance with id: " + id);
		try {
			CenterTraining instance = (CenterTraining) getSession().get(
					"com.cnqaos.hibernate.pojo.CenterTraining", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CenterTraining instance) {
		log.debug("finding CenterTraining instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cnqaos.hibernate.pojo.CenterTraining")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<CenterTraining> findByProperty(String propertyName, Object value) {
		log.debug("finding CenterTraining instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CenterTraining as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all CenterTraining instances");
		try {
			String queryString = "from CenterTraining";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CenterTraining merge(CenterTraining detachedInstance) {
		log.debug("merging CenterTraining instance");
		try {
			CenterTraining result = (CenterTraining) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CenterTraining instance) {
		log.debug("attaching dirty CenterTraining instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CenterTraining instance) {
		log.debug("attaching clean CenterTraining instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}