package pl.javastart.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {

    static LotteryResult getLotteryResult(List<Integer> userNumbers) {
        List<Integer> lotteryNumbers = getLotteryNumbers();
        ArrayList<Integer> matchedNumbers = new ArrayList<>(lotteryNumbers);
        matchedNumbers.retainAll(userNumbers);
        return new LotteryResult(lotteryNumbers, userNumbers, matchedNumbers);
    }

    private static List<Integer> getLotteryNumbers() {
        List<Integer> numberList = IntStream.rangeClosed(1, 49)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numberList);
        return numberList.subList(0,6);
    }
}
