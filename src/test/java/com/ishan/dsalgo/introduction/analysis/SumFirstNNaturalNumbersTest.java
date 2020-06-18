package com.ishan.dsalgo.introduction.analysis;

import org.junit.Assert;
import org.junit.Test;

public class SumFirstNNaturalNumbersTest {

  @Test
  public void test1() {
    SumFirstNNaturalNumbers sumFirstNNaturalNumbers = new SumFirstNNaturalNumbers();
    Assert.assertEquals(1125000000750000000l, sumFirstNNaturalNumbers.calculate1(1500000000l));
  }

  @Test
  public void test2() {
    SumFirstNNaturalNumbers sumFirstNNaturalNumbers = new SumFirstNNaturalNumbers();
    Assert.assertEquals(1125000000750000000l, sumFirstNNaturalNumbers.calculate2(1500000000l));
  }

  //@Test
  public void test3() {
    SumFirstNNaturalNumbers sumFirstNNaturalNumbers = new SumFirstNNaturalNumbers();
    Assert.assertEquals(1125000000750000000l, sumFirstNNaturalNumbers.calculate3(1500000000l));
  }

}
