package day4;

import utils.Utils;

import java.util.*;

public class Day4
{
    public static void main(String[] args){
        List<Object> data = parseData("Day4Input.txt");
        List<BingoCard> cards = (List<BingoCard>)data.get(0);
        List<Integer> calledNumbers = (List<Integer>)data.get(1);
        int pt1Increases = part1(cards, calledNumbers);
        int pt2Increases = part2(cards, calledNumbers);
        System.out.println("Pt1: "+pt1Increases);
        System.out.println("Pt2: "+pt2Increases);
    }

    public static List<Object> parseData(String input) {
        List<BingoCard> cards = new ArrayList<>();
        List<String> lines = Utils.readInLines(input);
        
        List<Integer> calledNumbers = Arrays.stream(lines.get(0).split(",")).map(Integer::parseInt).toList();
        for(int i=1; i<lines.size(); i+=5){
            cards.add(new BingoCard(List.of(
                    lines.get(i), lines.get(i+1),
                    lines.get(i+2), lines.get(i+3),
                    lines.get(i+4)
            )));
        }
        return List.of(cards, calledNumbers);
    }

    public static int part1(List<BingoCard> cards, List<Integer> calledNumbers){
        for(int calledNumber:calledNumbers){
            for(BingoCard card:cards){
                card.addCalledNumber(calledNumber);
                if(card.isComplete()){
                    int sum = card.sumUncalledNumbers();
                    return sum*calledNumber;
                }
            }
        }
        return 0;
    }

    public static int part2(List<BingoCard> cards, List<Integer> calledNumbers){
        Iterator<BingoCard> cardsIterator;
        int lastCalledNumber = -1;
        BingoCard lastCard = null;
        
        for(int calledNumber:calledNumbers){
            cardsIterator = cards.iterator();
            while(cardsIterator.hasNext()){
                lastCard = cardsIterator.next();
                lastCard.addCalledNumber(calledNumber);
                if(lastCard.isComplete()){
                    cardsIterator.remove();
                    cards.remove(lastCard);
                    if(!cardsIterator.hasNext()){
                        lastCalledNumber = calledNumber;
                    }
                }
            }
        }
        return lastCard.sumUncalledNumbers()*lastCalledNumber;
    }
}

class BingoCard{
    private final List<Integer> board = new ArrayList<>();
    private final List<Boolean> called;
    
    public BingoCard(List<String> lines){
        for(String line:lines){
            for(String number:line.trim().split("\\s+")){
                board.add(Integer.parseInt(number));
            }
        }
        called = new ArrayList<>(Arrays.asList(new Boolean[board.size()]));
        Collections.fill(called, Boolean.FALSE);
    }
    
    public void addCalledNumber(int calledNumber){
        for(int i=0; i<board.size(); i++){
            if(board.get(i)==calledNumber) called.set(i, true);
        }
    }
    
    public boolean isComplete(){
        int j;
        for(int i=0; i<board.size(); i+=5){
            if(called.get(i) && called.get(i+1) &&
               called.get(i+2) && called.get(i+3) && called.get(i+4)){
                return true;
            }
            j=i/5;
            if(called.get(j) && called.get(j+5) &&
               called.get(j+10) && called.get(j+15) && called.get(j+20)){
                return true;
            }
        }
        return false;
    }
    
    public int sumUncalledNumbers(){
        int sum = 0;
        for(int i=0; i<board.size(); i++){
            if(!called.get(i)) sum+=board.get(i);
        }
        return sum;
    }
    
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        StringBuilder calledString = new StringBuilder();
        for(int i=0; i<board.size(); i++){
            boardString.append(board.get(i));
            calledString.append(called.get(i));
            if(i>3 && (i+1)%5==0){
                boardString.append("\n");
                calledString.append("\n");
            }
            else{
                boardString.append(", ");
                calledString.append(", ");
            }
        }
        boardString.append("\n").append(calledString);
        return boardString.toString();
    }
}


