import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctOption; // 1-based index

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // List of Questions
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
            "What is the size of int in Java?",
            new String[]{"2 bytes", "4 bytes", "8 bytes", "Depends on OS"},
            2
        ));
        questions.add(new Question(
            "Which of these is not a Java keyword?",
            new String[]{"static", "Boolean", "void", "private"},
            2
        ));
        questions.add(new Question(
            "What is the default value of a boolean variable?",
            new String[]{"true", "false", "null", "0"},
            2
        ));
        questions.add(new Question(
            "Which collection class allows dynamic resizing and indexed access?",
            new String[]{"ArrayList", "HashMap", "TreeSet", "LinkedList"},
            1
        ));
        questions.add(new Question(
            "Which method starts a thread execution in Java?",
            new String[]{"run()", "start()", "execute()", "init()"},
            2
        ));
        questions.add(new Question(
            "Which statement is used to exit from a loop prematurely?",
            new String[]{"continue", "exit", "break", "stop"},
            3
        ));
        questions.add(new Question(
            "Which interface does java.util.HashMap implement?",
            new String[]{"List", "Set", "Map", "Collection"},
            3
        ));
        questions.add(new Question(
            "Which of these is a marker interface?",
            new String[]{"Runnable", "Serializable", "Cloneable", "Both 2 and 3"},
            4
        ));
        questions.add(new Question(
            "What does JVM stand for?",
            new String[]{"Java Variable Machine", "Java Virtual Machine", "Java Verified Machine", "Java Virtual Memory"},
            2
        ));
        questions.add(new Question(
            "Which keyword is used to inherit a class in Java?",
            new String[]{"this", "super", "extends", "implements"},
            3
        ));

        // Shuffle questions for randomness
        Collections.shuffle(questions);

        int score = 0;

        System.out.println("===== Welcome to the Java Quiz! =====");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);

            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer;
            while (true) {
                try {
                    answer = Integer.parseInt(sc.nextLine());
                    if (answer >= 1 && answer <= 4) {
                        break;
                    } else {
                        System.out.print("Invalid choice! Enter 1-4: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input! Enter a number 1-4: ");
                }
            }

            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.options[q.correctOption - 1]);
            }
        }

        // Show final score
        System.out.println("\n===== Quiz Completed! =====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        sc.close();
    }
                         }
