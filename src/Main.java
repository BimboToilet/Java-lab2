import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String command = new String(in.nextLine());
        while(true){
            if(command.equals("выход")){
                break;
            }
            else if(command.equals("создать словарь")){
                System.out.print("Путь к файлу: ");
                String path1=new String(in.nextLine());
                System.out.print("Путь к сохранению: ");
                String path2=new String(in.nextLine());
                try {
                    new Dictionary(path1,path2);
                    System.out.println("Успех!");
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
            command=in.nextLine();
        }
    }
}