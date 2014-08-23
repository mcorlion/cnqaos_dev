package com.cnqaos.hibernate.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnqaos.hibernate.pojo.StudentCenter;

/**
 * A data access object (DAO) providing persistence and search support for
 * StudentCenter entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cnqaos.hibernate.pojo.StudentCenter
 * @author MyEclipse Persistence Tools
 */
public class StudentCenterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StudentCenterDAO.class);

	// property constants

	public void save(StudentCenter transientInstance) {
		log.debug("saving StudentCenter instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StudentCenter persistentInstance) {
		log.debug("deleting StudentCenter instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentCenter findById(java.lang.Integer id) {
		log.debug("getting StudentCenter instance with id: " + id);
		try {
			StudentCenter instance = (StudentCenter) getSession().get(
					"com.cnqaos.hibernate.pojo.StudentCenter", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StudentCenter instance) {
		log.debug("finding StudentCenter instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cnqaos.hibernate.pojo.StudentCenter")
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
		log.debug("finding StudentCenter instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StudentCenter as model where model."
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
		log.debug("finding all StudentCenter instances");
		try {
			String queryString = "from StudentCenter";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StudentCenter merge(StudentCenter detachedInstance) {
		log.debug("merging StudentCenter instance");
		try {
			StudentCenter result = (StudentCenter) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StudentCenter instance) {
		log.debug("attaching dirty StudentCenter instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudentCenter instance) {
		log.debug("attaching clean StudentCenter instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}