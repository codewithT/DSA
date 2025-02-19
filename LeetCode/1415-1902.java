class Solution {
    public String getHappyString(int n, int k) {
        boolean [] vis =new boolean [4];
        List<String> lis = new LinkedList<>();
        solve(n,"",0, vis, lis, k);
        Collections.sort(lis);
        System.out.println(lis);
        return lis.size() >=k ? lis.get(k-1) : "";
    }
    public void solve(int n , String res ,int index, boolean[] vis, List<String>lis,
    int k ){
        if(res.length()== n){
            lis.add(res);
            return;
        }
        for(int i = 0;i<3;i++){
            // if(!vis[i] ){
                if(index ==0 || (res.charAt(res.length()-1) != (char)('a'+i)) ){
                vis[i] = true;
                solve(n, res+ (char) ('a'+i) , index+1, vis, lis, k);
                vis[i] = false;
                }
            // }
        }
    }
}