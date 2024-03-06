//Class for the binary tree system based on yes or no answers
public class QuestionNode{
    public String question; // The computers question 
    public QuestionNode yes; // Yes subtree 
    public QuestionNode no; // No subtree

    //leaf node that stores the answer 
    public QuestionNode(String question){
        this(question, null, null);
    }
    //branch node with data that stores a question
    public QuestionNode(String question, QuestionNode yes, QuestionNode no){
        this.question = question;
        this.yes = yes;
        this.no = no;
    }
    }