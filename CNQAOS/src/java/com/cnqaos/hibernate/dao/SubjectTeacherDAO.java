package com.cnqaos.hibernate.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnqaos.hibernate.pojo.SubjectTeacher;
import com.cnqaos.hibernate.pojo.SubjectTeacherId;

/**
 * A data access object (DAO) providing persistence and search support for
 * SubjectTeacher entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cnqaos.hibernate.pojo.SubjectTeacher
 * @author MyEclipse Persistence Tools
 */
public class SubjectTeacherDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SubjectTeacherDAO.class);

	// property constants

	public void save(SubjectTeacher transientInstance) {
		log.debug("saving SubjectTeacher instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SubjectTeacher persistentInstance) {
		log.debug("deleting SubjectTeacher instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SubjectTeacher findById(com.cnqaos.hibernate.pojo.SubjectTeacherId id) {
		log.debug("getting SubjectTeacher instance with id: " + id);
		try {
			SubjectTeacher instance = (SubjectTeacher) getSession().get(
					"com.cnqaos.hibernate.pojo.SubjectTeacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SubjectTeacher instance) {
		log.debug("finding SubjectTeacher instance by example");
		try {
			List results = getSession()
					.createCriteria("com.cnqaos.hibernate.pojo.SubjectTeacher")
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
		log.debug("finding SubjectTeacher instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SubjectTeacher as model where model."
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
		log.debug("finding all SubjectTeacher instances");
		try {
			String queryString = "from SubjectTeacher";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SubjectTeacher merge(SubjectTeacher detachedInstance) {
		log.debug("merging SubjectTeacher instance");
		try {
			SubjectTeacher result = (SubjectTeacher) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SubjectTeacher instance) {
		log.debug("attaching dirty SubjectTeacher instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SubjectTeacher instance) {
		log.debug("attaching clean SubjectTeacher instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}