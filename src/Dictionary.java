import java.io.*;

public class Dictionary {

    Dictionary(String filepathFrom, String filepathTo) throws IOException {
        File file=new File(filepathFrom);
        File filet = new File(filepathTo);
        int[] dictionary;
        int count=0;
        if(file.exists() && file.isFile() && file.canRead()){
            dictionary =new int[58];
            try(BufferedReader input = new BufferedReader(new FileReader(file))){
                int c;
                while((c=input.read())!=-1){
                    if(((char)c>='A' && (char)c<='Z') || ((char)c>='a' && (char)c<='z')){
                        dictionary[(char)(c-'A')]++;
                    }
                    count++;
                }
            }
            catch(IOException ex){
                throw new IOException("Проблема чтения из файла");
            }
        }
        else{
            throw new IOException("Файл не существует или нет разрешения на чтение из файла");
        }
        if((filet.exists() && filet.isFile() && filet.canWrite()) || !filet.exists()){
            try(BufferedWriter output = new BufferedWriter(new FileWriter(filet))){
                if(count !=0){
                    for(int i=0;i<58;i++){
                        if(dictionary[i]!=0){
                            output.write((char) (i+'A')+ "-" + dictionary[i] + "\n");
                        }
                    }
                }
            }
            catch(IOException ex){
                throw new IOException("Проблема записи в файл");
            }
        }
        else{
            throw new IOException("Нет разрешения на запись в файл");
        }

    }
}
