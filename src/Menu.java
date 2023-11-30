import java.io.Console;
import java.util.*;

public class Menu
{
     private Map<Integer,Command> commands = new HashMap<Integer,Command>();
     public Menu(){
          commands.put(1,new AddInsuranceCommand());
          commands.put(2,new CreateDerirativeCommand());
          commands.put(3,new SortByRiskLevelCommand());
          commands.put(4,new FindByCostCommand());
          commands.put(5,new GetTotalCostCommand());
     }
     public void displayMenu(){
          for (var command: commands.entrySet()) {
               System.out.println(command.getKey());
          }
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
