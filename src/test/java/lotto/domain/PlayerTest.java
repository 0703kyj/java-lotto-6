package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.LottoValues;
import lotto.util.RankingMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class PlayerTest {
    Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player();
    }
    @Test
    @DisplayName("플레이어에 로또가 저장되어야 한다.")
    void addLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        player.addLotto(lotto);

        assertThat(player.getNumberOfLotto()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또의 정답 개수를 설정할 수 있어야 한다.")
    void setLottoCorrectCount() {
        setLotto(3,1);

        List<CorrectCount> correctLottoCounts = player.getCorrectLottoCounts();

        for (CorrectCount correctLottoCount : correctLottoCounts) {
            assertThat(correctLottoCount.getCorrectNumberCount()).isEqualTo(3);
            assertThat(correctLottoCount.getCorrectBonusNumberCount()).isEqualTo(1);
        }
    }

    @ParameterizedTest
    @EnumSource(RankingMessage.class)
    @DisplayName("전체 로또에서 특정 개수 만큼 맞춘 로또 개수를 반환할 수 있어야 한다.")
    void getNumberCount(RankingMessage rankingMessage) {
        setLottos();

        String message = rankingMessage.toString();
        int rankCount = Integer.parseInt(message.split(LottoValues.RANKING_SPLIT_PARAMETER)[0]);

        if(message.contains(RankingMessage.FIRST_RANK.toString())){
            assertThat(player.getNumberCount(message, rankCount)).isEqualTo(2);
        }
        if(message.contains(RankingMessage.SECOND_RANK.toString())){
            assertThat(player.getNumberCount(message, rankCount)).isEqualTo(2);
        }
        if(message.contains(RankingMessage.THIRD_RANK.toString())){
            assertThat(player.getNumberCount(message, rankCount)).isEqualTo(3);
        }
        if(message.contains(RankingMessage.FOURTH_RANK.toString())){
            assertThat(player.getNumberCount(message, rankCount)).isEqualTo(4);
        }
        if(message.contains(RankingMessage.FIFTH_RANK.toString())){
            assertThat(player.getNumberCount(message, rankCount)).isEqualTo(5);
        }
    }

    private void setLottos() {
        setLotto(3,1);
        setLotto(3,0);
        setLotto(3,1);
        setLotto(3,0);
        setLotto(3,1);
        setLotto(4,0);
        setLotto(4,1);
        setLotto(4,0);
        setLotto(4,1);
        setLotto(5,0);
        setLotto(5,0);
        setLotto(5,0);
        setLotto(5,1);
        setLotto(5,1);
        setLotto(6,1);
        setLotto(6,0);
    }

    private void setLotto(int correctNumberCount, int correctBonusCount) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        CorrectCount correctCount = new CorrectCount(correctNumberCount, correctBonusCount);

        player.addLotto(lotto);
        player.setLottoCorrectCount(lotto, correctCount);
    }
}
