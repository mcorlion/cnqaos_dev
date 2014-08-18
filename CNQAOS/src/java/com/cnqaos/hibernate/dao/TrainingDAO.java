package com.cnqaos.hibernate.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnqaos.hibernate.pojo.Training;

/**
 * A data access object (DAO) providing persistence and search support for
 * Training entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cnqaos.hibernate.pojo.Training
 * @author MyEclipse Persistence Tools
 */
public class TrainingDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TrainingDAO.class);
	// property constants
	public static final String TRAINING_NAME = "trainingName";
	public static final String DESCRIPTION = "description";

	public void save(Training transientInstance) {
		log.debug("saving Training instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Training persistentInstance) {
		log.debug("deleting Training instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Training findById(java.lang.Integer id) {
		log.debug("getting Training instance with id: " + id);
		try {
			Training instance = (Training) getSession().get(
					"com.cnqaos.hibernate.pojo.Training", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Training instance) {
		log.debug("finding Training instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cnqaos.hibernate.pojo.Training")
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
		log.debug("finding Training instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Training as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTrainingName(Object trainingName) {
		return findByProperty(TRAINING_NAME, trainingName);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all Training instances");
		try {
			String queryString = "from Training";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Training merge(Training detachedInstance) {
		log.debug("merging Training instance");
		try {
			Training result = (Training) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Training instance) {
		log.debug("attaching dirty Training instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Training instance) {
		log.debug("attaching clean Training instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}