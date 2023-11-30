import java.util.List;
import java.util.Scanner;

public class AddInsuranceCommand implements Command{
    List<InsuranceObligation> obligations;
    public AddInsuranceCommand(List<InsuranceObligation> obligations){
        this.obligations= obligations;
    }
    @Override
    public void execute() {
        var scanner = new Scanner(System.in);
        String name;
        double cost;
        double riskLevel;
        System.out.print("Назва зобов'язання: ");
        name = scanner.nextLine();
        System.out.print("Рівень ризику: ");
        riskLevel = scanner.nextDouble();
        System.out.print("Вартість зобов'язання: ");
        cost = scanner.nextDouble();

        obligations.add(new InsuranceObligation(name,riskLevel,cost));
    }
}

