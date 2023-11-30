import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Derivative {
    List<InsuranceObligation> obligations;
    double totalCost;

    public double getTotalCost() {
        return totalCost;
    }

    private void setTotalCost() {
        totalCost = 0;
        for (InsuranceObligation obligation : obligations) {
            totalCost += obligation.getCost();
        }
    }


    public Derivative(List<InsuranceObligation> obligations) {
        this.obligations = new ArrayList<>();
        createDerivative(obligations);
    }

    public void createDerivative(List<InsuranceObligation> obligations) {
        this.obligations.clear();
        this.obligations.addAll(obligations);
        setTotalCost();
        obligations.clear();
    }

    public void showObligations() {
        System.out.printf("|%-20s|%-20s|%-20s|\n", "Назва", "Рівень ризику", "Вартість");
        for (var obligation : obligations) {
            obligation.showInformation();
        }
    }

    public void sortObligationsByRisk() {
        obligations.sort(Comparator.comparingDouble(InsuranceObligation::getRiskLevel).reversed());
    }


    public List<InsuranceObligation> findObligationsByParameters(double minCost, double maxCost) {
        List<InsuranceObligation> obligationsByParameters = new ArrayList<>();
        for (var obligation : obligations) {
            if (obligation.getCost() > minCost && obligation.getCost() < maxCost)
                obligationsByParameters.add(obligation);
        }
        return obligationsByParameters;
    }
}
