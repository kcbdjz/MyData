public class MyDate {
    private int year = 1970, month = 1, day = 1 ,hour = 0 ,minute = 0,second = 0;/*初始化数据*/
    private final int[][] Month = {{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
    /*储存闰年和平年的每月天数*/
    private final String[] strings = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    /*月份名称*/
    public MyDate() {
        setDate(System.currentTimeMillis());
    }

    public MyDate(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getDay() {
        return day;
    }
    public String getMonth() {
        return strings[month];
    }
    public int getYear() {
            return year;
    }

    public int getHour() {  return hour;}

    public int getMinute() { return minute;}

    public int getSecond() {    return second;}

    public void setDate(long elapsedTime) {
        int i = 0, j = 0;/*计数器*/
        int d = (int) ((elapsedTime+28800000) /86400000)+1;/*计算总天数*/
        d += 719527;
        int y1 = d/146097;/*每400年*/
        d = d % 146097;
        int y2 = d/36524;/*每100年*/
        d = d % 36524;
        int y3 = d / 1461;/*每四年*/
        d = d % 1461;
        year = y1*400 + y2*100 + y3*4 + d/365;
        d = d % 365;
        if (year % 4 == 0 && year % 100 != 0) {
            i = 1;
            d++;        /*由于先用闰年多出的那一天去算年份，所有在算闰年的时候天数少一*/
        }
        for (; d > Month[i][j]; j++)
            d -= Month[i][j];
        month = j;/*计算出月份*/
        day = d;/*计算出月中天*/
        if(j==0&&i==0){     /*由于先用天数算年份，所有有可能出现一月零号这种情况*/
            year--;
            month=11;
            day=31;
        }
        hms(elapsedTime);
    }
    public void hms(long elapsedTime) {
        int t = (int)((elapsedTime+28800000) %86400000);
        hour = t /3600000;
        t = t % 3600000;
        minute = t / 60000;
        t = t % 60000;
        second = t /1000;
    }
    public void showdate (MyDate myDate){
        System.out.println(myDate.getYear()+"year "+myDate.getMonth()+" "+myDate.getDay()+"day "+ myDate.getHour()+"hour "+myDate.getMinute()+"minute "+ myDate.getSecond()+"second");
    }
}
