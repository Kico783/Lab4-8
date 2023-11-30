public class GetTotalCostCommand implements Command {
    Derivative derivative;
    public  GetTotalCostCommand(Derivative derivative){
        this.derivative=derivative;
    }
    @Override
    public void execute() {
        System.out.print("Повна вартість деривативу: "+ derivative.getTotalCost()+"\n");
    }
}
