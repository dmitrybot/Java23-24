import java.util.HashMap;
import java.util.Map;

public class Parser {
    private double raschodi = 0;
    private double dochodi = 0;
    private Map<String,Double> rashodiPerCompany = new HashMap<String,Double>();

    public void Calculate(String str) {
        String[] stroka = str.split(",", 18);
        this.raschodi += Double.parseDouble(stroka[6].replaceAll("\\\"", "").replace(',', '.'));
        this.dochodi += Double.parseDouble(stroka[5].replaceAll("\"", ""));

        String company = stroka[16].replaceAll("\"", "");

        if (!rashodiPerCompany.containsKey(company)) {
            rashodiPerCompany.put(company, Double.parseDouble(stroka[6].replaceAll("\\\"", "").replace(',', '.')));
        } else {
            double sum = rashodiPerCompany.get(company);
            sum += Double.parseDouble(stroka[6].replaceAll("\\\"", "").replace(',', '.'));
            rashodiPerCompany.put(company, sum);
        }

    }
    public void Print(){
        System.out.println("Сумма доходов: " + this.dochodi + " rub");
        System.out.println("Сумма расходов " + this.raschodi + " rub");
        System.out.println("Расходы по компаниям:");
        for(String company : this.rashodiPerCompany.keySet()){
            System.out.println(company + ": " + this.rashodiPerCompany.get(company) + " руб");
        }
    }
}
