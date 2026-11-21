class Solution {
    class Info implements Comparable<Info>{
        String word;
        int ct;
        public Info(String word,int ct){
            this.word=word;
            this.ct=ct;
        }

        @Override
        public int compareTo(Info s1){
            if(s1.ct==this.ct){
                return this.word.compareTo(s1.word);
            } return s1.ct-this.ct;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Info> pq=new PriorityQueue<>();
        HashMap<String,Integer> hm=new HashMap<>();

        //traverse the words and insert the frequencies into the hashmap.
        for(String str:words){
            if(hm.containsKey(str)){
                hm.put(str,hm.get(str)+1);
            }else{
                hm.put(str,1);
            }
        }

        //traverse the hashmap and store into priorityQueue.
        for(String key:hm.keySet()){
            pq.add(new Info(key,hm.get(key)));
        }


        //Store the top words in the list.
        ArrayList<String> res=new ArrayList<>();
        while(!pq.isEmpty() && k--!=0){
            Info curr=pq.remove();
            res.add(curr.word);
        }return res;
    }
}