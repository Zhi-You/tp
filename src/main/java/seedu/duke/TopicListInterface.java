package seedu.duke;

import java.util.ArrayList;

public interface TopicListInterface {
    ArrayList<TopicInterface> getTopics();

    void showTopics();

    void addTopic(TopicInterface topic);

    void deleteTopic(TopicInterface topic);

    int getTopicCount();

}