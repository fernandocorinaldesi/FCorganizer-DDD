package ar.com.unpaz.organizerddd.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.IRepository;
import ar.com.unpaz.organizerddd.domain.specifications.Specification;

public class UserRepositoryImp implements IRepository<User>{

	@Override
	public List<User> get() {
		// TODO Auto-generated method stub
		String uslist = "SELECT U.DNI,U.NOMBRE,U.APELLIDO,U.USERNAME,U.PASS FROM USUARIOS U ";
		List<User> userlist = new ArrayList<>();
		Connection con = DbConection.getConection();
		try {
			PreparedStatement ps = con.prepareStatement(uslist);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt("DNI"),
						                     rs.getString("NOMBRE"), 
						                     rs.getString("APELLIDO"),
						                     rs.getString("USERNAME"),
						                     rs.getString("PASS"));
				userlist.add(user);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return userlist;
		
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		String insertuser = "INSERT INTO USUARIOS (DNI,NOMBRE,APELLIDO,USERNAME,PASS) values(?,?,?,?,?) ";
		Connection con = DbConection.getConection();
		try {
			PreparedStatement ps = con.prepareStatement(insertuser);
			ps.setInt(1, user.getDni());
			ps.setString(2, user.getName());
			ps.setString(3, user.getSecondName());
			ps.setString(4, user.getUser());
			ps.setString(5, user.getPass());
			ps.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void delete(int dni) {
		// TODO Auto-generated method stub
		String deleteuser = "DELETE FROM USUARIOS WHERE DNI=?";
		Connection con = DbConection.getConection();
		try (PreparedStatement st = con.prepareStatement(deleteuser)) {
			st.setInt(1,dni);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> query(Specification<User> spec) {
		// TODO Auto-generated method stub
		return null;
	}

}
