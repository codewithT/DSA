class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        List<Character> lis = new ArrayList<>();
        int [] ar = new int[26];
        for(char c : tiles.toCharArray()){
            ar[c-'A'] ++;
        }
        dfs(tiles, set , "" , ar);
       // System.out.println(set);
        return set.size();
    }
    public void dfs(String tiles, Set<String> set, String psf, int []ar ){
         if(!psf.isEmpty()){
            set.add(psf);
         }
         for(int i =0;i<ar.length;i++){
            if(ar[i]>0){
                ar[i] --;
                dfs(tiles, set, psf + (char) 'A' + i, ar);
                ar[i] ++ ;
            }
         }
    }
}