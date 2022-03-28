package com.ishan.dsalgo.problems.temp;

import java.util.HashMap;

@FunctionalInterface
interface Op {

  int operation(int a, int b);
}

public class FinalValueVariableAfterPerformingOperations_2011 {

  HashMap<String, Op> operationsMap = new HashMap<>();

  public FinalValueVariableAfterPerformingOperations_2011() {
    operationsMap.put("X++", Integer::sum);
    operationsMap.put("++X", Integer::sum);
    operationsMap.put("X--", (a, b) -> a - b);
    operationsMap.put("--X", (a, b) -> a - b);
  }

  public int operate(String[] operations) {
    int x = 0;

    for (String op : operations) {
      x = operationsMap.get(op).operation(x, 1);
    }
    return x;
  }

  public static void main(String[] args) {
    FinalValueVariableAfterPerformingOperations_2011 obj =
        new FinalValueVariableAfterPerformingOperations_2011();
    String operations[] = {"++X", "++X", "X++"};
    System.out.println(obj.operate(operations));
  }

}
