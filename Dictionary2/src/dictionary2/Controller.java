package dictionary2;

import com.sun.speech.freetts.VoiceManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

public class Controller implements Initializable {

    @FXML
    ListView<String> list;
    @FXML
    TextField search;
    @FXML
    TextArea search_word;
    @FXML
    TextArea meaning;
    @FXML
    ObservableList<String> obList = FXCollections.observableArrayList();
    @FXML
    FilteredList<String> filteredList = new FilteredList<>(obList, s -> true);
    @FXML
    Button readWord;

    @FXML
    TextField WordAdded;
    @FXML
    TextField WordMeanAdded;
    @FXML
    Button AddWordButton;
    @FXML
    TextField WordDeleted;
    @FXML
    Button DeleteWord;
    @FXML
    Text Notification;

    @FXML
    WebView webView;
    @FXML
    WebEngine webEngine;
    
    Dictionary ad = new Dictionary();
    DictionaryManagement input = new DictionaryManagement();

    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        input.insertFromFile();
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        for (Word word : ad.list) {
            obList.add(word.getWord_target());
        }
        filterListWord();
        showMeaning();
        readWord();
        addNewWord();
        deleteWord();

        searchKeyPressEnter();
        ggtran();
    }
    
    public void showMeaning() {
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String lookup = newValue;
            String line = input.dictionaryLookup(lookup);
            String[] meanLine = line.split("\t");
            String str = "";
            for (int i = 0; i < meanLine.length; i++) {
                str = str + meanLine[i] + "\n";
            }
            search_word.setText(lookup);
            meaning.setText(str);
        });
    }
    
    public void filterListWord() {
        list.setItems(filteredList);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(element -> {
                if (newValue == null || newValue.trim().isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (element.toLowerCase().startsWith(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
    }

   
     public void readWord(){
        readWord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VoiceManager voiceManager = VoiceManager.getInstance();
                com.sun.speech.freetts.Voice syntheticVoice = voiceManager.getVoice("kevin16");
                syntheticVoice.allocate();
                syntheticVoice.speak(search_word.getText());
                syntheticVoice.deallocate();
            }
        });
    }
    
    public void addNewWord() {
        AddWordButton.setOnAction(event -> {
            String word_target = WordAdded.getText();
            String word_explain = WordMeanAdded.getText();
            if (input.dictionaryLookup(word_target).equals("Khong tim thay tu!")) {
                input.addWord(word_target, word_explain);
                obList.add(word_target);
                Notification.setText("Đã thêm từ " + word_target);
            } else {
                input.removeWord(word_target);
                input.addWord(word_target, word_explain);
                Notification.setText("Đã sửa từ " + word_target);
            }
        });

    }

   
    public void deleteWord() {
        DeleteWord.setOnAction(event -> {
            String word_target = WordDeleted.getText();
            input.removeWord(word_target);
            obList.remove(word_target);
            Notification.setText("Đã xóa từ " + word_target);
        });
    }

    public void ggtran() {
        webEngine = webView.getEngine();
        webEngine.load("https://translate.google.com/?hl=vi");
    }

    public void searchKeyPressEnter() {
        search.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    String lookup = search.getText();
                    String line = input.dictionaryLookup(lookup);
                    search_word.setText(lookup);
                    String target = search.getText();
                    ArrayList<String> tar = input.dictionarySearcher(target);
                    for (String word_target : tar) {
                         obList.add(word_target);
                    }
                    String[] meanLine = line.split("\t");
                    String str = "";
                    for (int i = 0; i < meanLine.length; i++) {
                        str = str + meanLine[i] + "\n";
                    }
                    meaning.setText(str);

                }
            }
        });
    }
}
