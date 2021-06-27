import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.nio.file.*;

class InputOutputHandler  {

    private Scanner keyboardScanner = new Scanner(System.in);
    
    InputOutputHandler() { 
        
    }

    public void showMessage(String message) {
        System.out.print(message);
    }

    public void showMessageLn(String message) {
        System.out.println(message);
    }
    
    public String getString() {
        keyboardScanner = new Scanner(System.in);
        return keyboardScanner.nextLine();
    }

    public int getInteger() {
        try{
            return keyboardScanner.nextInt();
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public ArrayList<String> readFile(String fileName) throws Exception{
        
        Scanner fileScanner = new Scanner(Paths.get(fileName));
        ArrayList<String> lines = new ArrayList<String>();

        while(fileScanner.hasNext()){
            String line = fileScanner.next();
            lines.add(line);
        }
        
        fileScanner.close();
        return lines;
    }

    public void addLine(String line, String fileName) throws Exception{
        FileWriter writer = new FileWriter(fileName,true);
        writer.write(line);
        writer.close();
    }

   
}