import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PgsqlHandler {
    Connection connection;
    private String url;
    private String user;
    private String password;

    PgsqlHandler(String url, String user, String password) throws Exception{
            this.url = url;
            this.user = user;
            this.password = password;
            this.connection = DriverManager.getConnection(url,user,password);
    }

    public String getVersion() throws Exception{
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT VERSION()");
        if (rs.next()) {
            return rs.getString(1);
        }
        return "none";
    }

    public Connection getConnection() {
        return this.connection;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
