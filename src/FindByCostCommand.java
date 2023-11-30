import java.util.Scanner;

public class FindByCostCommand implements Command {
    Derivative derivative;

    public FindByCostCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public void execute(){
        var scanner = new Scanner(System.in);
        double from;
        double to;
        System.out.print("Знайти зобов'язання, вартість яких від ");
        from = scanner.nextDouble();
        System.out.print("До ");
        to = scanner.nextDouble();
        var list =  derivative.findObligationsByParameters(from,to);
        System.out.printf("|%-20s|%-20s|%-20s|\n","Назва","Рівень ризику","Вартість");
        for (var obligation: list){
            obligation.showInformation();
        }
    }
}
