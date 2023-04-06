class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Double.compare(a[0], b[0]));
        ArrayList<ArrayList<Integer> > x = new ArrayList<ArrayList<Integer> >();
        x.add(new ArrayList<Integer>());
        x.get(0).addAll(Arrays.asList(intervals[0][0],intervals[0][1]));
        int a=0;
        int max=x.get(0).get(1);
        for(int i=1;i<intervals.length;i++){
            if(max>=intervals[i][0]){
                max=Math.max(intervals[i][1],max);
                //System.out.println("max= "+max);
                x.get(a).set(1,max);
               // System.out.println(x.get(a));
            }
            else{
                a++;
                x.add(new ArrayList<Integer>());
                x.get(a).addAll(Arrays.asList(intervals[i][0],intervals[i][1]));
                max=intervals[i][1];
               // System.out.println(x.get(a));
            }
        }
        int[][] arr = x.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        return arr;
    }
}