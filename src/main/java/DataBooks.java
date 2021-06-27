public class DataBooks {
    public DataBooks() { }

    public DataBooks(int id, int author_id, String title) {
        this.id = id;
        this.author_id = author_id;
        this.title = title;
    }

    Integer id;
    Integer author_id;
    String title;

    public Integer getId() {
        return id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
