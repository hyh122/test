package domain.businessService.systemManagement;

import domain.businessEntity.systemManagement.User;

public interface ISystemManagementService {
	//����һ���û������ݿ���
	public boolean saveUser(User user);
	//�����ݿ��и���Phone��ȡUser����
	public User findUserByPhone(String phone);
}
