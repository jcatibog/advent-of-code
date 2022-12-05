package net.catibog.advent_of_code.y2022.day5;

import net.catibog.advent_of_code.common.FileUtility;

import java.util.*;

public class SupplyStacks {
    static final String inputFile = "y2022/day5.input.txt";
    static final int stackCapacity = 9;

    record Instruction(int amount, int source, int dest) {}

    public static void main(String[] args) {
        List<String> lines = FileUtility.getLinesFromFile(inputFile);
        List<Deque<Character>> stackList = new ArrayList<>(stackCapacity);
        for (int i = 0; i < stackCapacity; i++) {
            stackList.add(new ArrayDeque<>());
        }
        List<Instruction> instructionsList = new ArrayList<>();

        boolean parsingStacks = true;
        for (String line : lines) {
            if (parsingStacks && line.charAt(0) != '[') {
                parsingStacks = false;
            }
            if (parsingStacks) {
                for (int i = 1; i <= 9; i++) {
                    String item = line.substring((i-1)*4, (i*4)-1);
                    item = item.trim();
                    if (item.length() > 0) {
                        stackList.get(i-1).push(item.charAt(1));
                    }
                }
            } else {
                var moveInstructions = line.split(" ");
                if (moveInstructions[0].equals("move")) {
                    var move = new Instruction(
                        Integer.parseInt(moveInstructions[1]),
                        Integer.parseInt(moveInstructions[3]),
                        Integer.parseInt(moveInstructions[5])
                    );
                    instructionsList.add(move);
                }
            }
        }

        for (Instruction inst : instructionsList) {
            ArrayDeque<Character> intermediate = new ArrayDeque<>();
            for (int i = 0; i < inst.amount; i++) {
                char c = stackList.get(inst.source-1).removeLast();
                intermediate.addFirst(c);
            }
            while (!intermediate.isEmpty()) {
                stackList.get(inst.dest-1).addLast(intermediate.removeFirst());
            }
        }

        for (Deque<Character> s : stackList) {
            System.out.println(s);
        }
    }
}