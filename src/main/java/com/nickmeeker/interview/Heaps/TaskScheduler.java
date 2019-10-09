/*
    put everything into a pq based on how many tasks it has left
    poll the pq and decrement everything, then reinsert it into the pq
    
    last question is to solve "cooldown" time 
    for every element i poll from the pq, increase timer
    if timer hits n, then stop
    
    otherwise, add (n + 1) - timer
    
    timer -> 2
    poll(a)
    poll(b)
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // freq
        Map<Character, Integer> map = new HashMap<>();
        // maxheap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int answer = 0;

        for (char label : tasks) {
            map.putIfAbsent(label, 0);
            map.put(label, map.get(label) + 1);
        }

        for (char label : map.keySet()) {
            heap.add(map.get(label));
        }

        while (!heap.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // a full cycle, plus one in case we have more elements than cooldown
            for (int i = 0; i < n + 1; i++) {
                if (!heap.isEmpty()) {
                    list.add(heap.poll());
                }
            }

            // add everything that's not done back to the heap
            for (int i : list)
                if (--i > 0)
                    heap.add(i);

            // if the heap is empty, we are going to sit idle for a bit. otherwise,
            // we took the full time
            answer += heap.isEmpty() ? list.size() : n + 1;
        }
        return answer;
    }
}