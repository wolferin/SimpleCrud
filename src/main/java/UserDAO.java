import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kenny on 01.08.2015.
 */
public class UserDAO {

    private Connection connection;

    public UserDAO(){
        connection = MyDBController.getConnection();
    }

    public void delete (int id) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(User user) {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement
                                    ("insert into users(name, surname, email, phone) values (?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getPhone());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update (User user) {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement
                                    ("update users set name=?, surname=?, email=?, phone=? where id=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getPhone());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> allUser() {
        List<User> users = new ArrayList<User>();

        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getInt("phone"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User getUserById(int id) {
        User user = new User();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement
                                        ("select * from users where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getInt("phone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

}
