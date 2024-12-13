package pl.javastart.lottery;

import java.util.List;

public class LotteryResult {
    private List<Integer> lotteryNumbers;
    private List<Integer> userNumbers;
    private List<Integer> matchedNumbers;

    public LotteryResult(List<Integer> lotteryNumbers, List<Integer> userNumbers, List<Integer> matchedNumbers) {
        this.lotteryNumbers = lotteryNumbers;
        this.userNumbers = userNumbers;
        this.matchedNumbers = matchedNumbers;
    }

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public List<Integer> getMatchedNumbers() {
        return matchedNumbers;
    }
}
