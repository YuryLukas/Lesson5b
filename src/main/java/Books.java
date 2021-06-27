import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Books extends PgsqlHandler{

    Books(String url, String user, String password) throws Exception {
        super(url, user, password);
    }

    public ResultSet getListResult() throws Exception{
        Statement st = connection.createStatement();
        String query = "SELECT * FROM Books";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public ArrayList<DataBooks> getListArrayList() throws Exception{
        ArrayList<DataBooks> result = new ArrayList<DataBooks>();
        ResultSet rs = getListResult();
        while (rs.next()){
            DataBooks data = new DataBooks(rs.getInt(1), rs.getInt(2), rs.getString(3));
            result.add(data);
        }
        return result;
    }

    public DataBooks getBooksById(int id) throws Exception {
        DataBooks dataBooks = new DataBooks();
        String query = "SELECT * FROM Books WHERE id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();

        dataBooks.setId(rs.getInt(1));
        dataBooks.setTitle(rs.getString(2));

        return  dataBooks;
    }

    public DataBooks getBookLikeTitle(String seatchLine) throws Exception{
        DataBooks dataBooks = new DataBooks();
        String query = "SELECT * FROM Books WHERE title LIKE ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, seatchLine);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()) {
            dataBooks.setId(rs.getInt(1));
            dataBooks.setTitle(rs.getString(2));
        }
        return  dataBooks;
    }

    public void add(int idAuthor, String titleBook) throws Exception {
        Statement st = connection.createStatement();
        String query = "INSERT INTO books (author_id,title) VALUES (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idAuthor);
        preparedStatement.setString(2,titleBook);
        preparedStatement.executeUpdate();
    }
}
