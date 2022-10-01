package com.example.raspisanie;

public class Lesson {

    private String subject, teacher, place, type, timeOf;

    private String makeTime(int i){
        String time = "";
        switch(i){
            case 0:
                time = "8:00";
                break;
            case 1:
                time = "9:50";
                break;
            case 2:
                time = "11:40";
                break;
            case 3:
                time = "13:45";
                break;
            case 4:
                time = "15:35";
                break;
            case 5:
                time = "17:25";
                break;
            default:
                time = "Nasa";
        }
        return time;
    }

    private String makeType(int typeOf){
        switch (typeOf){
            case 0:
                final String prac = "Prac";
                return prac;
            case 1:
                final String lec = "Lec";
                return lec;
            default:
                final String weekend = "Week";
                return weekend;
        }
    }

    public Lesson(Day AllDay, int LessonNum){
            subject = AllDay.subject[LessonNum];
            teacher = AllDay.teacher[LessonNum];
            place = AllDay.place[LessonNum];
            type = makeType(AllDay.type[LessonNum]);
            timeOf = makeTime(LessonNum);
    }

    public String getSubject(){
        return subject;
    }

    public String getPlace(){
        return place;
    }

    public String getTeacher(){
        return teacher;
    }

    public String getType(){
        return type;
    }

    public String getTimeOf(){
        return timeOf;
    }
}
