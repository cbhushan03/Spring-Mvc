package ti.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ti.spring.model.User;

@Repository("userDao ")
public class UserDaoImpl extends AbstractDao<Integer, User>  implements UserDao {

	public User findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	public User findBySSO(String sso) {
		// TODO Auto-generated method stub
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("ssoId", sso));
		return (User) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUser(){
		List<User> userList = getSession().createQuery(" from User ").list();
		
		return userList;
	}

}
