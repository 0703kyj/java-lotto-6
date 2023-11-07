package lotto.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Player;
import lotto.util.LottoValues;
import lotto.util.RankingMessage;

public class TotalStatCalculator {

    private Player player;

    public TotalStatCalculator(Player player) {
        this.player = player;
    }

    public Map<String, Integer> getTotalLottoStats() {
        Map<String, Integer> totalStats = new HashMap<>();
        List<RankingMessage> rankingMessages = Arrays.stream(RankingMessage.values()).toList();

        for (RankingMessage rankingMessage : rankingMessages) {
            String message = rankingMessage.toString();
            int rankCount = getRankCount(message);
            int numberCount = player.getNumberCount(message, rankCount);

            totalStats.put(message, numberCount);
        }

        return totalStats;
    }

    private int getRankCount(String message) {
        return Integer.parseInt(message.split(LottoValues.SPLIT_PARAMETER)[0]);
    }
}