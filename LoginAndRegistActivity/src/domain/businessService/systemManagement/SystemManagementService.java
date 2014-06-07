/**
 * 
 */
package domain.businessService.systemManagement;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.stmt.QueryBuilder;

import domain.businessEntity.systemManagement.User;
import foundation.data.DataContext;
import foundation.data.IDataContext;

/**
 * @author szp-ThinkPad
 * 实现service接口
 */
public class SystemManagementService implements ISystemManagementService {
	private IDataContext ctx=null;
	public SystemManagementService(){
		ctx= new DataContext();
	}
	@Override
	public boolean saveUser(User user) {
		try {
			ctx.add(user, User.class, int.class);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * QueryBuilder 查询方法
	 */
	@Override
	public User findUserByPhone(String phone) {
		List<User> list = null;
		try {
			QueryBuilder<User,Integer> qb = ctx.getQueryBuilder(User.class, int.class);
			qb.where().eq("userPhone", phone);
			list = ctx.query(User.class, int.class, qb.prepare());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.size()>0)
			return list.get(0);
		else {
			return new User();
		}
	}
	
}
