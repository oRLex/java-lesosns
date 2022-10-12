//package webX;
//
//import lombok.SneakyThrows;
//
//import java.io.IOException;
//
//public class SneakyThrowsApp {
//
//  public static void code() throws IOException {
//    throw new IOException("too bad");
//  }
//
//  @SneakyThrows
//  public static void block1() {
//    code();
//  }
//
//  public static void block2() {
//    try {
//      code();
//    } catch (IOException x) {
//      throw new IllegalArgumentException(x);
//    }
//  }
//
//  public static void main(String[] args) {
//    block1();
//  }
//
//}
