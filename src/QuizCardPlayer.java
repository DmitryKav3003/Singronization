import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class QuizCardPlayer {
    private JTextArea display;
    private JTextArea answer;
    private ArrayList <QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public JTextArea getAnswer() {
        return answer;
    }

    public static void main(String[] args) {
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }

    private void go() {
        frame = new JFrame("Quiz Card Player");
        JPanel miPanel = new JPanel();
        Font bihFont = new Font("sunderif", Font.BOLD, 24);
        display = new JTextArea(10, 20);
        display.setFont(bihFont);
        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        nextButton = new JButton("Show Question");
        miPanel.add(display);
        miPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load Card Set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, miPanel);
        frame.setSize(640, 500);
        frame.setVisible(true);
    }

    public class NextCardListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            if (isShowAnswer) {
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            }
            else {
                if (currentCardIndex < cardList.size()) {
                    showNextCard();
                }
                else {
                    display.setText("That was last card");
                    nextButton.setEnabled(false);
                }
            }
        }
    }
    public class OpenMenuListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            LoadFile(fileOpen.getSelectedFile());
        }

        private void LoadFile(File selectedFile) {
        }
    }
    private void LoadFile(File file){
        cardList = new ArrayList<QuizCard>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String Line = null;
            while ((Line = reader.readLine()) != null){
                makeCard(Line);
            }
            reader.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        showNextCard();
    }
    private void makeCard(String LineToParse){
        String[] result = LineToParse.split("/"); //позволяет разбивать строку на части
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }
    private void showNextCard(){
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion);
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }

    private class QuizCard {
        public String getQuestion;

        public QuizCard(String s, String s1) {
        }

        public String getAnswer() {
            return null;
        }
    }
}

