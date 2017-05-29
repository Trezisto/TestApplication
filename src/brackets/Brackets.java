package brackets;

import java.util.*;

/**
 * Created by eprijilevschi on 5/29/2017.
 */
public class Brackets {
    private final Map<Character, Character> OUTPUT_INPUT_ARGS = new HashMap<>(3);

    public Brackets() {
        OUTPUT_INPUT_ARGS.put('}', '{');
        OUTPUT_INPUT_ARGS.put(']', '[');
        OUTPUT_INPUT_ARGS.put(')', '(');
    }

    public boolean verify(String valid) {
        if(valid == null) {
            return false;
        }
        Set<Character> outputArgs = OUTPUT_INPUT_ARGS.keySet();
        Collection<Character> inputArgs = OUTPUT_INPUT_ARGS.values();

        Deque<Character> charsStack = new ArrayDeque<>();
        for (char c : valid.toCharArray()){
            if(inputArgs.contains(c)){
                charsStack.push(c);
            } else
                if(outputArgs.contains(c)){
                    Character lastBracket = charsStack.peek();
                    if(lastBracket == null)
                        return false;

                    if(lastBracket.equals(OUTPUT_INPUT_ARGS.get(c))){
                        charsStack.pop();
                    }
                }
        }

        return charsStack.isEmpty();
    }
}
