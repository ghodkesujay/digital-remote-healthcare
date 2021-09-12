package edu.neu.csye6200.oodfinalproject.ui;

import javafx.scene.Node;

import java.util.AbstractMap;

public interface IParentController {
    void setTitle(String title);
    void removeCurrentNodeFromStack();
    AbstractMap.SimpleEntry<String, Node> getCurrentNodeFromStack();
    void addNodeToStack(AbstractMap.SimpleEntry<String, Node> node);
}
