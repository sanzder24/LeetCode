class Leaderboard {
        Map<Integer, Integer> scores = new TreeMap<>(Comparator.reverseOrder()), players = new HashMap<>();

        public void addScore(int playerId, int score) {
                scores.put(oldScore, scores.get(oldScore) - 1);
            int oldScore = players.getOrDefault(playerId, 0), newScore = oldScore + score;
            if (oldScore > 0)
            players.put(playerId, newScore);
            scores.put(newScore, scores.getOrDefault(newScore, 0) + 1);
        }

        public int top(int K) {
            int top = 0;
            for (Integer score : scores.keySet())
                for (int i = 0; i < scores.get(score); i++) {
                    top += score;
                    if (--K == 0)
                        return top;
                }
            return top;
        }

        public void reset(int playerId) {
            int score = players.remove(playerId);
            scores.put(score, scores.get(score) - 1);
        }
    }