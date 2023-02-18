package ru.task.brackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dputiatinskii
 */
public class Task {

    public static final Character RIGHT_BRACKET = '(';

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        validBracketsCount(reader.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
    }

    public static void validBracketsCount(List<Character> listOfCharacters) {
        int i;
        int cnt = 0;

        Deque<Character> stack = new ArrayDeque<>();
        List<Integer> listOfIndexes = new ArrayList<>();

        for (i = 0; i < listOfCharacters.size(); i++) {
            if (RIGHT_BRACKET.equals(listOfCharacters.get(i))) {
                stack.addFirst(listOfCharacters.get(i));
                listOfIndexes.add(i);
            } else if (!stack.isEmpty()) {
                stack.pop();
                cnt++;
                listOfIndexes.remove(listOfIndexes.size()-1);
            } else if (stack.isEmpty()) {
                listOfIndexes.add(i);
            }
        }

        i = 0;
        StringBuilder result = new StringBuilder();
        for (Character elem : listOfCharacters) {
            if (!listOfIndexes.contains(i)) {
                result.append(elem);
            }
            i++;
        }

        System.out.println(cnt == 0 ? 0 : cnt * 2 + " - " + result);

    }
}
