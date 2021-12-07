package day4;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day4
{
    public static void main(String[] args){
        List<BingoCard> cards = parseData("Day1Input.txt");
        int pt1Increases = part1(cards);
        int pt2Increases = part2(cards);
        System.out.println("Pt1: "+pt1Increases);
        System.out.println("Pt2: "+pt2Increases);
    }

    public static List<BingoCard> parseData(String input) {
        List<BingoCard> cards = new ArrayList<>();
        List<String> lines = Utils.readInLines(input);
        String calledNumbers = lines.get(0);
        Utils.readInLines(input).forEach(s->cards.add(Integer.parseInt(s)));
        return cards;
    }

    public static int part1(List<BingoCard> cards){
        return 0;
    }

    public static int part2(List<BingoCard> cards){
        return 0;
    }

    private class BingoCard{
        private final List<Integer> board = new ArrayList<>();


        public BingoCard(List<String> lines){
            for(String line:lines){
                for(String number:line.split(" ")){
                    board.add(Integer.parseInt(number));
                }
            }
        }

        public boolean isComplete(){
            return false;
        }
    }
}


