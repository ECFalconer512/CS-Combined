package assign02;

import java.util.ArrayList;

/**
 * This class represents a CS2420 University of Utah student, that extends U of U Student.
 * The class adds additional private instance variables and methods to initialize and call
 * those variables
 *
 * @author Erin Parker and Evan Falconer
 * @version January 20, 2022
 */

public class CS2420Student extends UofUStudent {

    private EmailAddress contactInfo;
    private ArrayList<Double> assignmentScores= new ArrayList<Double>();
    private ArrayList<Double> examScores= new ArrayList<Double>();
    private ArrayList<Double> labScores= new ArrayList<Double>();
    private ArrayList<Double> quizScores= new ArrayList<Double>();

    // constructor that sets the name, uNID, and email of students
    public CS2420Student(String firstName, String lastName, int uNID, EmailAddress contactInfo){
        super(firstName, lastName, uNID);
        this.contactInfo=contactInfo;
    }
    // simple getter that returns an assign02.EmailAddress object
    public EmailAddress getContactInfo(){
        return contactInfo;
    }

    // adds score to respective lists, unless it's out of the scoring bounds or not a valid category
    public void addScore(double score, String category){
        if(score<0 || score>100){
            return;
        }
        switch (category){
            case "assignment":
                assignmentScores.add(score);
                break;
            case "exam":
                examScores.add(score);
                break;
            case "lab":
                labScores.add(score);
                break;
            case "quiz":
                quizScores.add(score);
                break;
        }
    }

    public double computeFinalScore(){
        if(assignmentScores.size()==0||examScores.size()==0||labScores.size()==0||labScores.size()==0||quizScores.size()==0){
            return 0.0;
        }


        //find average score for each category
        double assignmentSum=0;
        for(Double a: assignmentScores){
            assignmentSum+=a;
        }
        double assAvg=assignmentSum/(double)assignmentScores.size();

        double examSum=0;
        for(Double e: examScores){
            examSum+=e;
        }
        double examAvg=examSum/(double)examScores.size();

        double labSum=0;
        for(Double l: labScores){
            labSum+=l;
        }
        double labAvg=labSum/(double)labScores.size();

        double quizSum=0;
        for(Double q: quizScores){
            quizSum+=q;
        }
        double quizAvg=quizSum/(double)quizScores.size();

        //determining the final course grade, and assigning it to the exam average if the exam average is less than 65%
        double finalGrade;
        if(examAvg>=65){
            finalGrade=(assAvg*.40)+(examAvg*.40)+(labAvg*.10)+(quizAvg*.10);
        }
        else{
            finalGrade=examAvg;
        }

        return finalGrade;
    }

    public String computeFinalGrade(){
        var finalGrade=computeFinalScore();
        if(assignmentScores.size()==0||examScores.size()==0||labScores.size()==0||labScores.size()==0||quizScores.size()==0){
            return "N/A";
        }

        if(finalGrade>=93){
            return"A";
        }
        if(finalGrade>=90){
            return"A-";
        }
        if(finalGrade>=87){
            return"B+";
        }
        if(finalGrade>=83){
            return"B";
        }
        if(finalGrade>=80){
            return"B-";
        }
        if(finalGrade>=77){
            return"C+";
        }
        if(finalGrade>=73){
            return"C";
        }
        if(finalGrade>=70){
            return"C-";
        }
        if(finalGrade>=67){
            return"D+";
        }
        if(finalGrade>=63){
            return"D";
        }
        if(finalGrade>=60){
            return"D-";
        }
        else {
            return "E";
        }

    }















}
