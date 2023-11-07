package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.util.LottoValues;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int getCorrectNumberCount(List<Integer> correctNumbers) {
        int count = 0;

        for (Integer correctNumber : correctNumbers) {
            if(numbers.contains(correctNumber)){
                count++;
            }
        }

        return count;
    }

    public int getCorrectNumberCount(int correctNumber) {
        int count = 0;

        if(numbers.contains(correctNumber)){
            count++;
        }

        return count;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoValues.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {

    }

    private void validateRange(List<Integer> numbers) {

    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
