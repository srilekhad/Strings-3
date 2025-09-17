//Time Complexity (TC): O(1) — you scan a fixed list (~31 entries) and make a constant number of small recursive calls (max depth ≈ 3). 
//Space Complexity (SC): O(1) auxiliary — recursion depth is constant (≤3); 

//Approach:
//Keep an ordered list of (value, word) pairs from 1 Billion down to 1 and scan greedily from largest to smallest.
//When num ≥ value, if value ≥ 100 recursively convert num / value and append the unit word; else directly append the word for the tens/ones.
//Reduce num = num % value and continue, inserting spaces as needed; special-case num == 0 → "Zero".

class NumberWord {
    int value;
    String word;

    NumberWord(int value, String word) {
        this.value = value;
        this.word = word;
    }
}

class Solution {
    private static final List<NumberWord> numberToWordsList = Arrays.asList(
        new NumberWord(1000000000, "Billion"),
        new NumberWord(1000000, "Million"),
        new NumberWord(1000, "Thousand"),
        new NumberWord(100, "Hundred"),
        new NumberWord(90, "Ninety"),
        new NumberWord(80, "Eighty"),
        new NumberWord(70, "Seventy"),
        new NumberWord(60, "Sixty"),
        new NumberWord(50, "Fifty"),
        new NumberWord(40, "Forty"),
        new NumberWord(30, "Thirty"),
        new NumberWord(20, "Twenty"),
        new NumberWord(19, "Nineteen"),
        new NumberWord(18, "Eighteen"),
        new NumberWord(17, "Seventeen"),
        new NumberWord(16, "Sixteen"),
        new NumberWord(15, "Fifteen"),
        new NumberWord(14, "Fourteen"),
        new NumberWord(13, "Thirteen"),
        new NumberWord(12, "Twelve"),
        new NumberWord(11, "Eleven"),
        new NumberWord(10, "Ten"),
        new NumberWord(9, "Nine"),
        new NumberWord(8, "Eight"),
        new NumberWord(7, "Seven"),
        new NumberWord(6, "Six"),
        new NumberWord(5, "Five"),
        new NumberWord(4, "Four"),
        new NumberWord(3, "Three"),
        new NumberWord(2, "Two"),
        new NumberWord(1, "One")
    );

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        return convert(num).trim();
    }

    private String convert(int num) {
        StringBuilder sb = new StringBuilder();

        for (NumberWord nw : numberToWordsList) {
            if (num >= nw.value) {
                if (nw.value >= 100) {
                    sb.append(convert(num / nw.value)).append(" ");
                }
                sb.append(nw.word);

                num = num % nw.value;

                if (num != 0) {
                    sb.append(" ");
                } else {
                    break;
                }
            }
        }

        return sb.toString();
    }
}
