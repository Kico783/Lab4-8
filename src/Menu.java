import java.io.Console;
import java.util.*;

public class Menu
{
     private Map<Integer,Command> commands = new HashMap<Integer,Command>();

     List<InsuranceObligation> obligations = new ArrayList<>();
     Derivative derivative = new Derivative(obligations);
     public Menu(){
          commands.put(1,new AddInsuranceCommand(obligations));
          commands.put(2,new CreateDerirativeCommand(obligations,derivative));
          commands.put(3,new SortByRiskLevelCommand(derivative));
          commands.put(4,new FindByCostCommand(derivative));
          commands.put(5,new GetTotalCostCommand(derivative));
     }
     public void displayMenu(){
          System.out.println("1)Добавити зобов'язання");
          System.out.println("2)Створити дериватив");
          System.out.println("3)Відсортувати за рівнем ризику");
          System.out.println("4)Знайти зобов'язання за діапазоном цін ");
          System.out.println("5)Отримати повну ціну деривативу");
          System.out.println("0)Закрити програму");
     }

     public void run(){
          Scanner scanner = new Scanner(System.in);
          int choice;
          do{
               displayMenu();
               choice = scanner.nextInt();
               if(commands.containsKey(choice)){
                    commands.get(choice).execute();
               }
               else if(choice!=0) {
                    System.out.println("Невідома команда.");
               }

          }while (choice!=0);
     }
}
