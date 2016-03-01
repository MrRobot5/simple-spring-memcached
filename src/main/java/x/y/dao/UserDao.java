package x.y.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import x.y.model.User;

@Repository
public class UserDao {
	
	private Log logger = LogFactory.getLog(getClass());
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void add(User u){
		logger.info("hibernateTemplate.save");
		jdbcTemplate.update("insert into users(username) values(?)", u.getUsername());
	}

	public List<User> queryAll() {
		return null;
	}
	
	public User get(String id) {
		logger.info("hibernateTemplate.get...");
		return jdbcTemplate.queryForObject("select * from users where id = ?", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setUsername(rs.getString("username"));
				return u;
			}}, Integer.parseInt(id));
	}

	public void update(User lpBean) {
		logger.info("hibernateTemplate.update...");
		jdbcTemplate.update("update users set username = ? where id = ?", lpBean.getUsername(), lpBean.getId());
	}

	public void delete(String personId) {
		logger.info("hibernateTemplate.delete...");
		
	}
	
}
