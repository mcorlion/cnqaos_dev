package com.cnqaos.hibernate.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnqaos.hibernate.pojo.TrainingSubject;
import com.cnqaos.hibernate.pojo.TrainingSubjectId;

/**
 * A data access object (DAO) providing persistence and search support for
 * TrainingSubject entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cnqaos.hibernate.pojo.TrainingSubject
 * @author MyEclipse Persistence Tools
 */
public class TrainingSubjectDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TrainingSubjectDAO.class);

	// property constants

	public void save(TrainingSubject transientInstance) {
		log.debug("saving TrainingSubject instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TrainingSubject persistentInstance) {
		log.debug("deleting TrainingSubject instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrainingSubject findById(
			com.cnqaos.hibernate.pojo.TrainingSubjectId id) {
		log.debug("getting TrainingSubject instance with id: " + id);
		try {
			TrainingSubject instance = (TrainingSubject) getSession().get(
					"com.cnqaos.hibernate.pojo.TrainingSubject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TrainingSubject instance) {
		log.debug("finding TrainingSubject instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cnqaos.hibernate.pojo.TrainingSubject")
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
		log.debug("finding TrainingSubject instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TrainingSubject as model where model."
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
		log.debug("finding all TrainingSubject instances");
		try {
			String queryString = "from TrainingSubject";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TrainingSubject merge(TrainingSubject detachedInstance) {
		log.debug("merging TrainingSubject instance");
		try {
			TrainingSubject result = (TrainingSubject) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TrainingSubject instance) {
		log.debug("attaching dirty TrainingSubject instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrainingSubject instance) {
		log.debug("attaching clean TrainingSubject instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}