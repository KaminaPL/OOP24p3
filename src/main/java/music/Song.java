package music;



import java.sql.*;
import java.util.Optional;

public record Song(String author, String title, int seconds) {

    public static class Persistance{

        public Optional<Song> read(int index) throws SQLException {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/bartosz/IdeaProjects/shop/songs.db");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM song WHERE id = ?");
            preparedStatement.setInt(1, index);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return Optional.of(new Song(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                ));
            }
            connection.close();
            return Optional.empty();
        }
        public Optional<Song> read(int index, Connection connection) throws SQLException {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM song WHERE id = ?");
            preparedStatement.setInt(1, index);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return Optional.of(new Song(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                ));
            }
            return Optional.empty();
        }
    }
}
