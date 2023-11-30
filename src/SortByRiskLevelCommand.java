public class SortByRiskLevelCommand implements Command {
    Derivative derivative;

    public SortByRiskLevelCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public void execute() {
        derivative.sortObligationsByRisk();
        System.out.println("Дериватив відсортовано за зменшенням рівнем ризику");
        derivative.showObligations();
    }
}
