package model;

public class Question {
    private String mQuestionNumber;
    private String mQuestionText;
    private String mAnswer;

    public Question(String questionNumber, String questionText){
        mQuestionNumber = questionNumber;
        mQuestionText = questionText;
    }

    public String getQuestionNumber() {
        return mQuestionNumber;
    }

    public String getQuestionText() {
        return mQuestionText;
    }

    public String getAnswer() { return mAnswer; }

    public void setAnswer(String mAnswer) {
        this.mAnswer = mAnswer;
    }
}
