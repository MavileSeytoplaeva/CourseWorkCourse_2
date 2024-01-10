package pro.sky.courseworkcouse_2;

import pro.sky.courseworkcouse_2.models.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Consts {
    public static final String QUESTION = "question";
    public static final String ANSWER = "answer";
    public static final Collection<Question> QUESTION_COLLECTION = new HashSet<>(Set.of(
            new Question("question", "answer"),
            new Question("why", "because"),
            new Question("when", "then"),
            new Question("where", "there")));

    public static final Collection<Question> COLLECTION_FOR_RANDOM_1 = new HashSet<>(Set.of(
            new Question("when", "then")));

    public static final Set<Question> QUESTION_SET = new HashSet<>(Set.of(
            new Question("question", "answer")));

}
