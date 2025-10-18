import java.util.List;

public class User {
    private String userId;
    private String userName;
    List<Question> questions;
    List<Answer> answers;

    public User(String userId, String userName){
        this.userId=userId;
        this.userName=userName;
    }


    public Question createQuestion(String qid,String content){
        Question newQuestion = new Question(qid, content,this);
        questions.add(newQuestion);
        return newQuestion;
    }

    public void addAnswer(Question question,String aid,String content){
        Answer newAnswer = new Answer(question, aid, content,this);
        question.addAnswer(newAnswer);
    }

}
