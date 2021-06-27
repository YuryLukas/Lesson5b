public class Menu {
  private String menuline="\n---------------------------------------------\n" +
          "Menu:" +
          "\n---------------------------------------------\n" +
          "1 - Список авторов \n" +
          "2 - Список всех книг \n" +
          "3 - Выбрать автора \n" +
          "4 - Добавить автора \n" +
          "5 - Добавить книгу автора \n" +
          "6 -  Выход \n" +
          "------------------------------------------------\n";
  private int selectedAuthor=0;
  private Authors author;
  private boolean flag = true;
  private int key = 0;
  private final InputOutputHandler inOutHandler = new InputOutputHandler();

    public Menu(Authors author) throws Exception{
        this.author = author;

    }

    public void show() throws Exception{
        this.inOutHandler.showMessage(menuline);
        if(this.selectedAuthor >0){
            this.inOutHandler.showMessage("Выбранный автор: ");
            this.inOutHandler.showMessageLn(this.getSelectedAuthorName());
            this.inOutHandler.showMessageLn("------------------------------------------------");
        }
    }

    public String getSelectedAuthorName() throws Exception {
        if(this.selectedAuthor >0){
            DataAuthor item = this.author.getAuthorById(selectedAuthor);
            return  item.getName();
        }
        return null;
    }

    public int readKey(){
        return this.inOutHandler.getInteger();
    }

    public int getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(int selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }

    public String getMenuline() {
        return menuline;
    }

    public void setMenuline(String menuline) {
        this.menuline = menuline;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
