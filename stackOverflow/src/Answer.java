public class Answer {
    private String aid;
    private String content;
    private User user;

    private Question question;

    public Answer(Question question,String aid,String content,User user){
        this.question=question;
        this.aid=aid;
        this.content=content;
        this.user=user;
    }
}
