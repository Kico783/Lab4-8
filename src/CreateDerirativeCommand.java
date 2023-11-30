import java.util.List;

public class CreateDerirativeCommand implements Command {
    List<InsuranceObligation> obligations;
    Derivative derivative;

    public CreateDerirativeCommand(List<InsuranceObligation> obligations, Derivative derivative) {
        this.obligations = obligations;
        this.derivative = derivative;
    }

    @Override
    public void execute() {
        derivative.createDerivative(obligations);
        System.out.println("Дериватив зібрано із доданих зобов'язань");
    }
}
