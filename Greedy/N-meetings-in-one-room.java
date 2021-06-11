class Solution {
    public static int maxMeetings(int start[], int end[], int n) {
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.end > o2.end) return 1;
                return 0;
            }
        });
        
        int index = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (meetings[i].start > meetings[index].end) {
                index = i;
                count++;
            }
        }
        return count;
    }

    static class Meeting {
        int start;
        int end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
