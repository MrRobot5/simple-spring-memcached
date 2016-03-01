package x.y.service;

import x.y.model.User;

import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;

public interface IMemcachedTestService {
	public void savePerson(User lpBean);

	public User getByPersonId(@ParameterValueKeyProvider String personId);

	public void updatePerson(@ParameterValueKeyProvider @ParameterDataUpdateContent User lpBean);

	public void deletePerson(@ParameterValueKeyProvider String personId);
}