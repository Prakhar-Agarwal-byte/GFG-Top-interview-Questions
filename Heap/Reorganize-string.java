class Solution {
    public class Pair{
        char ch;
        int a;
        Pair(char ch,int a){
            this.ch=ch;
            this.a=a;
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.get(ch) == null){
                map.put(ch,1);
            }
            else{
                int x=map.get(ch)+1;
                map.put(ch,x);
            }
        }
        PriorityQueue<Pair> q=new PriorityQueue<>((aa,bb) -> bb.a -aa.a);
        for(Map.Entry<Character,Integer> m:map.entrySet()){
            char key=m.getKey();
            int value=m.getValue();
            q.add(new Pair(key,value));
        }
        StringBuilder ans=new StringBuilder();
        while(q.size() >= 2){
            Pair x=q.remove();
            Pair y=q.remove();
            int f1=x.a;
            int f2=y.a;
            ans.append(x.ch);
            ans.append(y.ch);
            if(f1>1)
            q.add(new Pair(x.ch , f1-1));
            if(f2>1)
            q.add(new Pair(y.ch , f2-1));
        }
        if(!q.isEmpty()){
            Pair x=q.remove();
            int f=x.a;
            if(f>1)
                return "";
            else
                ans.append(x.ch);
        }
        return new String(ans);
    }
}
