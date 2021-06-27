import java.lang.Exception;
import java.sql.ResultSet;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/lesson 5";
        String user = "yurock";
        String password = "Kjgeijr@2017";
        int key = 0;
        InputOutputHandler inputOutputHandler = new InputOutputHandler();

        try {
            Authors authors = new Authors(url, user, password);
            Books books = new Books(url, user, password);
            Menu menu = new Menu(authors);
            while (menu.isFlag()) {
                menu.show();
                key = menu.readKey();

                switch (key) {
                    case 1:
                        ArrayList<DataAuthor> authorList = authors.getListArrayList();
                        for (DataAuthor item : authorList) {
                            inputOutputHandler.showMessageLn(item.getId().toString() + " " + item.getName());
                        }
                        break;

                    case 2:
                        ArrayList<DataBooks> booksList = books.getListArrayList();
                        for (DataBooks item : booksList) {
                            inputOutputHandler.showMessageLn(item.getId().toString() + " " + item.getTitle());
                        }
                        break;

                    case 3:
                        int idAuthors = inputOutputHandler.getInteger();
                        DataAuthor dataAuthor = authors.getAuthorById(idAuthors);
                        if (dataAuthor.getId() != null) {
                            menu.setSelectedAuthor(idAuthors);
                        } else {
                            inputOutputHandler.showMessageLn("Нет автора с таким Id");
                        }
                        break;

                    case 4:
                        inputOutputHandler.showMessage("Введите имя нового автора:");
                        authors.add(inputOutputHandler.getString());
                        break;

                    case 5:
                        if (menu.getSelectedAuthor() > 0) {
                            inputOutputHandler.showMessage("Введите название новой книги:");
                            books.add(menu.getSelectedAuthor(), inputOutputHandler.getString());
                        } else {
                            inputOutputHandler.showMessageLn("Вы не выбрали автора!");
                        }
                        break;

                    case 6:
                        menu.setFlag(false);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}



