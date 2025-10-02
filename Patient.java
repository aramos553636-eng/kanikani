package ramos;

import java.util.*;

 
class Patient implements Comparable<Patient> {
  private String name;
  private int priority;
  private String condition;
  private String arrivalTime;

  public Patient(String name, int priority, String condition, String arrivalTime) {
    this.name = name;
    this.priority = priority;
    this.condition = condition;
    this.arrivalTime = arrivalTime;

  }

  public int getPriority() {
    return priority;
  }

  public String getArrivalTime() {
    return arrivalTime;

  }

  public String getName() {
    return name;

  }

  public String getCondition() {
    return condition;

  }

  @Override

  public int compareTo(Patient other) {
    // Compare the prio
    if (this.priority != other.priority) {
      return Integer.compare(this.priority, other.priority);
    }
    // Then compare by arriv time so early comes first
    return this.arrivalTime.compareTo(other.arrivalTime);
  }

  @Override
  public String toString() {
    return "[P" + priority + "] " + name + " - " + condition + " (" + arrivalTime + ")";

  }

}

