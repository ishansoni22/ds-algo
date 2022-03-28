package com.ishan.dsalgo.problems.temp;

public class DefangingIPAddress_1108 {

  public String defang(String ipAddress) {
    ipAddress = ipAddress.replace(".", "[.]");
    return ipAddress;
  }

  public static void main(String[] args) {
    DefangingIPAddress_1108 obj = new DefangingIPAddress_1108();
    System.out.println(obj.defang("255.100.50.0"));

  }

}
