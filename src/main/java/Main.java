import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(Paths.get("src/main/resources/final_transaction_table.csv"));

        Parser parser = new Parser();
        for(int i=1;i<list.size();i++){
            parser.Calculate(list.get(i));
        }

        parser.Print();

    }
}