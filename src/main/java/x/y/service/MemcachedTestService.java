package x.y.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import x.y.dao.UserDao;
import x.y.model.User;

import com.google.code.ssm.api.InvalidateSingleCache;
import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.UpdateSingleCache;

@Service
public class MemcachedTestService implements IMemcachedTestService {

	private static final String NAMESPACE = "ns";

	@Autowired
	private UserDao userDao;
	
	@Override
	public void savePerson(User user) {
		
		userDao.add(user);
	}

	@Override
	@ReadThroughSingleCache(namespace = NAMESPACE, expiration = 600)
	public User getByPersonId(@ParameterValueKeyProvider String userId) {
		System.out.println("do query...");
		return userDao.get(userId);
	}

	@Override
	@UpdateSingleCache(namespace = NAMESPACE, expiration = 600)
	public void updatePerson(@ParameterValueKeyProvider @ParameterDataUpdateContent User user) {
		userDao.update(user);
	}

	@Override
	@InvalidateSingleCache(namespace = NAMESPACE)
	public void deletePerson(@ParameterValueKeyProvider String userId) {
		userDao.delete(userId);
	}

}