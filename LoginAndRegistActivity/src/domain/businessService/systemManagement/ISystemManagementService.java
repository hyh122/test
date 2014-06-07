package domain.businessService.systemManagement;

import domain.businessEntity.systemManagement.User;

public interface ISystemManagementService {
	//保存一个用户到数据库中
	public boolean saveUser(User user);
	//从数据库中根据Phone获取User数据
	public User findUserByPhone(String phone);
}
