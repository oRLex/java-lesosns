package lesson09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ValidateBrackets2 {

  public boolean validate(String s) {
    HashSet<Character> open = new HashSet<Character>() {{
      add('(');
      add('[');
      add('{');
      add('<');
    }};
    //         key        value
    HashMap<Character, Character> pairs = new HashMap<Character, Character>() {{
      put(')', '(');
      put(']', '[');
      put('}', '{');
      put('>', '<');
    }};
    System.out.println(pairs.size());

    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      // current char
      char ch = s.charAt(i);

      // open bracket
      if (open.contains(ch)) {
        stack.push(ch);
        continue;
      }

      // close bracket
      if (pairs.containsKey(ch)) {
        if (!stack.empty() && stack.peek() == pairs.get(ch)) {
          stack.pop();
        } else return false;
      }

   }
    return stack.empty();
  }

}
