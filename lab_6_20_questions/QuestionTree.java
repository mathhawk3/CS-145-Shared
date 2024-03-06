

public class QuestionTree{

    //Represents the topmost node of the binary tree
    public QuestionNode overallRoot;
    public UserInterface ui;

    //Constructor Initializes a new question tree
    public QuestionTree(UserInterface ui){
        this.ui = ui;
        overallRoot = new QuestionNode("computer");
    }

    //Will run through one complete question game
    public void play(){
        //creating object root to keep track of current node we are on
        QuestionNode root = overallRoot;

        //to continue to play the game until an answer is reached
        while(root.yes != null || root.no != null){
            //asking the user a question to get user input
            ui.print(root.question);
            boolean isYes = ui.nextBoolean();
            String userInput;
            if(isYes){
                userInput = "yes";
            }else{
                userInput = "no";
            }
                if(userInput.equalsIgnoreCase("yes")){
                    root = root.yes;
                }else if(userInput.equalsIgnoreCase("no")){
                    root = root.no;
                }else{
                    ui.println("You need to input yes or no");
                }
        }
        //checking to see if the current node is the answer
        String finalGuess = root.question;
        ui.print("Is it " + finalGuess + " ?");
        boolean rightAnswer = ui.nextBoolean();

        if(rightAnswer){
            ui.println("Computer Wins!");
        }else{
            ui.println("Computer lost! Whats the answer?");
            String answer = ui.nextLine();
            
            ui.println("Give me a question that is true for" + answer);
            String newQuestion = ui.nextLine();

            ui.println("Is that answer yes or no for "  + newQuestion + " ?");
            boolean isAnswerYes = ui.nextBoolean();

            //updating the tree 
            root.question = newQuestion;
            //is answer is yes add the question to the yes subtree 
            if(isAnswerYes){
                root.yes = new QuestionNode(newQuestion);
                root.no = new QuestionNode(finalGuess);
            }else{// else add it to the no subtree
                root.yes = new QuestionNode(finalGuess);
                root.no = new QuestionNode(newQuestion);
            }
        }

    }
}