package com.cnqaos.hibernate.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnqaos.hibernate.pojo.TrainingType;

/**
 * A data access object (DAO) providing persistence and search support for
 * TrainingType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cnqaos.hibernate.pojo.TrainingType
 * @author MyEclipse Persistence Tools
 */
public class TrainingTypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TrainingTypeDAO.class);
	// property constants
	public static final String TRAINING_TYPE_NAME = "trainingTypeName";
	public static final String DESCRIPTION = "description";

	public void save(TrainingType transientInstance) {
		log.debug("saving TrainingType instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TrainingType persistentInstance) {
		log.debug("deleting TrainingType instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrainingType findById(java.lang.Integer id) {
		log.debug("getting TrainingType instance with id: " + id);
		try {
			TrainingType instance = (TrainingType) getSession().get(
					"com.cnqaos.hibernate.pojo.TrainingType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TrainingType instance) {
		log.debug("finding TrainingType instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cnqaos.hibernate.pojo.TrainingType")
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
		log.debug("finding TrainingType instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TrainingType as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTrainingTypeName(Object trainingTypeName) {
		return findByProperty(TRAINING_TYPE_NAME, trainingTypeName);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all TrainingType instances");
		try {
			String queryString = "from TrainingType";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TrainingType merge(TrainingType detachedInstance) {
		log.debug("merging TrainingType instance");
		try {
			TrainingType result = (TrainingType) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TrainingType instance) {
		log.debug("attaching dirty TrainingType instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrainingType instance) {
		log.debug("attaching clean TrainingType instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}