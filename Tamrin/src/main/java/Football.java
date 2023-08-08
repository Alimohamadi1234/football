import java.sql.*;
public class Football {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String username1 = "postgres";
    private final String password = "postgres";
    public void addUser(String club) {
        String query = "INSERT INTO football_table (club) VALUES (?)";
        try (Connection connection = DriverManager.getConnection(url, username1, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, club);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("INFORMATION added successfully ");
            } else {
                System.out.println("Failed to add INFORMATION.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteuser(String club) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username1, password);
        Statement stmt = conn.createStatement();
        String sql = "DELETE FROM football_table WHERE club = ?";
        try (Connection connection = DriverManager.getConnection(url, username1, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, club);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("INFORMATION DELETED successfully!");
            } else {
                System.out.println("FAILED TO DELETE INFORMATION.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(String club,String games,String win,String lost,String equal,String point) throws SQLException {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "postgres";
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "UPDATE football_table SET club =? ,games=?, win = ?, lost = ? , equal = ?, point =? ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, club);
                pstmt.setString(2, games);
                pstmt.setString(3, win);
                pstmt.setString(4, lost);
                pstmt.setString(5, equal);
                pstmt.setString(6, point);

                int rowsUpdated = pstmt.executeUpdate();
                System.out.println(rowsUpdated + " rows updated.");
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
