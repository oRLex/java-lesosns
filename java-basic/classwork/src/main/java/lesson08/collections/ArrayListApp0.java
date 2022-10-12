package lesson08.collections;

import java.util.ArrayList;

public class ArrayListApp0 {

  interface IOS {}
  static class ISInt implements IOS{
    final int x;

    ISInt(int x) {
      this.x = x;
    }
  }
  static class ISStr implements IOS{
    final String x;

    ISStr(String x) {
      this.x = x;
    }
  }

  public static void main(String[] args) {
    ArrayList<IOS> list3 = new ArrayList<IOS>();
    list3.add(new ISStr("123"));
    list3.add(new ISInt(123));
    IOS at0 = list3.get(0);
    if(at0 instanceof ISStr) {}
    if(at0 instanceof ISInt) {}
  }
}
