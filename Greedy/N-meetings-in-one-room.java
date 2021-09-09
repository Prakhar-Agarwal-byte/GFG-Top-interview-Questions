class Solution {
  public static int maxMeetings(int start[], int end[], int n) {
    Meeting[] arr = new Meeting[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Meeting(start[i], end[i]);
    }
    Arrays.sort(arr, (a, b) -> (a.end - b.end));
    int count = 1;
    int endC = arr[0].end;
    for (int i = 1; i < n; i++) {
      if (arr[i].start > endC) {
        count++;
        endC = arr[i].end;
      }
    }
    return count;
  }
}

class Meeting {
  int start;
  int end;

  Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
