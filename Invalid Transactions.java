class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> transactionsByPpl = new HashMap<>();
        List<Transaction> parsedTransactions = new ArrayList<>();
        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);
            parsedTransactions.add(t);
            List<Transaction> ts = transactionsByPpl.get(t.name);
            if (ts == null) {
                ts = new ArrayList<>();
                transactionsByPpl.put(t.name, ts);
            }
            ts.add(t);
        }
        
        List<String> invalid = new ArrayList<>();
        for (Transaction t : parsedTransactions) {
           if (!isValid(t, transactionsByPpl.get(t.name))) {
               invalid.add(t.original);
           }
        }
        return invalid;
        
    }
    
    private boolean isValid(Transaction t, List<Transaction> transactions) {
        if (t.amount > 1000) {
            return false;
        }   
        for (Transaction transaction : transactions) {
            if (Math.abs(transaction.time - t.time) <= 60 && !transaction.city.equals(t.city)) {
                return false;
            }
        }
        return true;
    }
    
    static class Transaction {
        final String name;
        final int time;
        final int amount;
        final String city;
        final String original;
        
        public Transaction(String transaction) {
            String[] parsed = transaction.split(",");
            this.name = parsed[0];
            this.time = Integer.parseInt(parsed[1]);
            this.amount = Integer.parseInt(parsed[2]);
            this.city = parsed[3];
            this.original = transaction;
        }
    }
}