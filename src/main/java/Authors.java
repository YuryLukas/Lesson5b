import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Authors extends PgsqlHandler {

    public Authors(String url, String user, String password) throws Exception {
        super(url, user, password);
    }

    public ResultSet getListResult() throws Exception{
        Statement st = connection.createStatement();
        String query = "SELECT * FROM Authors";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public ArrayList<DataAuthor> getListArrayList() throws Exception{
        ArrayList<DataAuthor> result = new ArrayList<DataAuthor>();
        ResultSet rs = getListResult();
        while (rs.next()){
            DataAuthor data = new DataAuthor(rs.getInt(1), rs.getString(2) );
            result.add(data);
        }
        return result;
    }

    public void add(String nameAuthor) throws Exception{
        Statement st = connection.createStatement();
        String query = "INSERT INTO authors (name) VALUES (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,  nameAuthor );
        preparedStatement.executeUpdate();
    }

    public DataAuthor getAuthorById(int id) throws Exception{
        DataAuthor dataAuthor = new DataAuthor();
        String query = "SELECT * FROM Authors WHERE id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                dataAuthor.setId(rs.getInt(1));
                dataAuthor.setName(rs.getString(2));
            }
        return  dataAuthor;
    }

}
