package Website;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import javax.persistence.Persistence.*;

import Website.DBUtil;
import model.Productdetail;
import model.Shoppinguser;;



public class WebsiteDB {
	public Shoppinguser getProfile(String username){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Shoppinguser usr = null;
		
		try {
			String sql = "select u from Shoppinguser u where u.username = :username";
			TypedQuery<Shoppinguser> q = em.createQuery(sql, Shoppinguser.class);
			q.setParameter("username", username);
			
			usr = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return usr;
	}
	
	
	
	public Shoppinguser getProfile(String username, String pwd){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Shoppinguser usr = null;
		
		try {
			String sql = "select u from Shoppinguser u where u.username = :username and u.pwd = :pwd";
			TypedQuery<Shoppinguser> q = em.createQuery(sql, Shoppinguser.class);
			q.setParameter("username", username);
			q.setParameter("pwd", pwd);
			
			usr = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return usr;
	}
	
	
	public boolean createNewUser(String username, String pwd){
		boolean isSuccess = false;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		Shoppinguser user = new Shoppinguser();
		user.setPwd(pwd);
		user.setUsername(username);
		
		
		trans.begin();
		
		try{
			em.persist(user);
			trans.commit();
			isSuccess = true;
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}
		
		return isSuccess;
	}
	/*public ArrayList<Twitterfeed> getAllFeeds(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Twitterfeed> fd = null;
		
		try {
			String sql = "select t from Twitterfeed t";
			TypedQuery<Twitterfeed> results = em.createQuery(sql, Twitterfeed.class);
			
			fd = results.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Twitterfeed>(fd);
	}
	
	
	public Twitteruser getProfile(String username){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Twitteruser usr = null;
		
		try {
			String sql = "select u from Twitteruser u where u.username = :username";
			TypedQuery<Twitteruser> q = em.createQuery(sql, Twitteruser.class);
			q.setParameter("username", username);
			
			usr = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return usr;
	}
	
	public Twitteruser getProfile(String username, String pwd){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Twitteruser usr = null;
		
		try {
			String sql = "select u from Twitteruser u where u.username = :username and u.pwd = :pwd";
			TypedQuery<Twitteruser> q = em.createQuery(sql, Twitteruser.class);
			q.setParameter("username", username);
			q.setParameter("pwd", pwd);
			
			usr = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return usr;
	}
	
	public boolean createNewUser(String username, String pwd){
		boolean isSuccess = false;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		Twitteruser user = new Twitteruser();
		user.setPwd(pwd);
		user.setUsername(username);
		
		trans.begin();
		
		try{
			em.persist(user);
			trans.commit();
			isSuccess = true;
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}
		
		return isSuccess;
	}*/
	
	public ArrayList<Productdetail> getAllProducts(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Productdetail> fd = null;
		
		try {
			String sql = "SELECT p from Productdetail p";
			TypedQuery<Productdetail> results = em.createQuery(sql, Productdetail.class);
			
			fd = results.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Productdetail>(fd);
	}
}
