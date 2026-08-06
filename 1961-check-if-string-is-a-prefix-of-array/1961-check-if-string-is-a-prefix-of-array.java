class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder str = new StringBuilder();
        for(String word : words){
            str.append(word);

            if(str.toString().equals(s)){
                return true;
            }

            if(str.length()>s.length()){
                return false;
            }
        }
        return false;
    }
}