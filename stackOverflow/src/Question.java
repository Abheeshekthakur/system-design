import java.util.List;

public class Question {
    private String id;
    private String content;
    private User user;

    List<Answer> answers;


    public Question(String id, String content, User user){
        this.id=id;
        this.content=content;
        this.user=user;

    }


    public void addAnswer(Answer answer){
        answers.add(answer);
    }

}
