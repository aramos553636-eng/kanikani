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


