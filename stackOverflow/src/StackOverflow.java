import java.util.ArrayList;
import java.util.List;

public class StackOverflow {

    public static StackOverflow instance;
    List<Question> questions;
    List<User> users;

    private StackOverflow(){
        questions=new ArrayList<>();
        users=new ArrayList<>();
    }

    public static StackOverflow getInstance(){
        if (instance==null){
            return new StackOverflow();
        }
        return instance;
    }

    public User createUser(String userId, String userName){
        User newUser = new User(userId, userName);
        users.add(newUser);
        return newUser;
    }

    public void addQuestion( User user,String qid,String content){
        Question q=user.createQuestion(qid, content);
        questions.add(q);
    }

    public void addAnswer(User user,Question question,String aid, String content){
        user.addAnswer(question,aid,content);
    }

}
