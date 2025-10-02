import java.util.*;

public class ERMain {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ERQueue er = new ERQueue();

    boolean running = true;

    while (running) {
      System.out.println("\n--- ER TRIAGE MENU --- \n"
      + "[1] ADD PATIENT \n"
      + "[2] DISPLAY\n"
      + "[3] TREAT NEXT PATIENT\n"
      + "[4]EXIT\n"
      + "ENTER CHOICE :");
      int choice = sc.nextInt();
      sc.nextLine(); 

 

      switch (choice) {
        case 1:
          System.out.print("Enter patient name: ");
          String name = sc.nextLine();

          System.out.print("Enter priority (1=Critical, 2=Serious, 3=Stable, 4=Minor): ");
          int priority = sc.nextInt();
          sc.nextLine();

          System.out.print("Enter condition: ");
          String condition = sc.nextLine();

          System.out.print("Enter arrival time (HH:mm): ");
          String time = sc.nextLine();

          er.arrive(name, priority, condition, time);
          break;

 

        case 2:
          er.displayQueue();
          break;

        case 3:
          er.treatNext();
          break;

        case 4:
          running = false;
          System.out.println("Exiting ER system...");
          break;


        default:
          System.out.println("Invalid choice, try again.");
      }
    }
    sc.close();

  }

}


  
package ramos;
import java.util.*;

class ERQueue {

  private PriorityQueue<Patient> queue;


  public ERQueue() {
    queue = new PriorityQueue<>();

  }

  public void arrive(String name, int priority, String condition, String time) {
    Patient patient = new Patient(name, priority, condition, time);
    queue.add(patient);

  }

  public void treatNext() {
    if (queue.isEmpty()) {
      System.out.println(" No patients to treat.");
    } else {

      Patient next = queue.poll();
      System.out.println("\n Treating patient now");
      System.out.println("Treated: " + next.toString());

    }

  }

  public void displayQueue() {
    System.out.println("\n--- UPDATED QUEUE ---");
    System.out.println("Patients Waiting: " + queue.size());

    List<Patient> patients = new ArrayList<>(queue);
    Collections.sort(patients);
    int i = 1;
    for (Patient p : patients) {
      System.out.println(i + ". " + p.toString());
      i++;

    }

  }

}


