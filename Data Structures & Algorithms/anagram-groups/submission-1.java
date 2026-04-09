class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double, List<String>> lookup = new HashMap<Double, List<String>>();
        for (String s : strs) {
            double sum = 0.0;
            for (char c : s.toCharArray()) sum += (1.0 / (double) c);

            //Multiplies by 10^7
            //Converts to long (cuts extra decimals)
            //Divides back
            //Why? - Because floating-point numbers are imprecise
            //Without this: 0.123456789 ≠ 0.123456788999
            sum = (double) ( (long) (sum * 10000000.0) / 10000000.0 );
            lookup.putIfAbsent(sum, new ArrayList<String>());
            lookup.get(sum).add(s);
        }
        return new ArrayList<>(lookup.values());
    }
}
