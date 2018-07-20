import javafx.scene.control.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class MainGUI extends Application {
    static ArrayList<Subject> Obstacles = new ArrayList<>();
    static AnchorPane rootNode;
    static Panel LeftPanel;
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage LFStage)   {
        // Создание базы окна
        LFStage.setTitle("LI-FI TEST");
        rootNode = new AnchorPane();
        Scene LFScene = new Scene(rootNode, (1280), (720-50));
        LFStage.setScene(LFScene);
        // Добавление элементов
        // МенюБар
        MenuBar menuBar = new MenuBar();
        rootNode.setLeftAnchor(menuBar,(double) 0);
        rootNode.setTopAnchor(menuBar,(double) 0);
        rootNode.getChildren().addAll(menuBar);
        // Элементы меню
        Menu fileMenu = new Menu("Файл");
        Menu addMenu = new Menu("Добавить");
        Menu helpMenu = new Menu("Справка");
        menuBar.getMenus().addAll(fileMenu, addMenu, helpMenu);
        // Подэлементы Файл
        MenuItem NewfileMenu = new MenuItem("Новый");
        MenuItem OpenfileMenu = new MenuItem("Открыть");
        MenuItem ExitfileMenu = new MenuItem("Выход");
        ExitfileMenu.setOnAction((ae) -> System.exit(0));  //Реакция подэлемента меню
        fileMenu.getItems().addAll(NewfileMenu, OpenfileMenu, ExitfileMenu);
        // Подэлементы Добавить
        MenuItem IstochikaddMenu = new MenuItem("Источник");
        MenuItem SubjectaddMenu = new MenuItem("Объект");
        MenuItem PriemnikaddMenu = new MenuItem("Приемник");
        addMenu.getItems().addAll(IstochikaddMenu, SubjectaddMenu, PriemnikaddMenu);

        // Создание левого подокна
        LeftPanel = new Panel(10,50, 600, 500);
        // Задать помещение
        LeftPanel.setPomeshenie(rootNode, 600, 600, 500);
        // Добавление диода (-1 для середины, -2 для правого/нижнего края)
        // Методы для точного расположения переделаю позже, надо смотреть библиотеку анализа изображений
        LeftPanel.addDiod(rootNode, "img/diod.png", 0, -1, 0);
        // Добавление приемника
        Priemnik priem = LeftPanel.addPriemnik(rootNode, 10, -1, -2, 18);

        // Разделяющая линия
        Line SepLine = new Line(630, 50, 630, 1000);
        SepLine.setStrokeWidth(10);
        SepLine.setStroke(Color.BLACK);
        rootNode.getChildren().addAll(SepLine);

        // Создание правого подокна, оно пока сделано чисто для красоты, здесь ничего не прописано
        Panel RightPanel = new Panel(650,50, 600, 500);
        // Задать помещение
        RightPanel.setPomeshenie(rootNode, 600, 600, 500);
        // Добавление диода (-1 для середины, -2 для правого/нижнего края)
        // Методы для точного расположения переделаю позже, надо смотреть библиотеку анализа изображений
        RightPanel.addDiod(rootNode, "img/diod.png", 0, -1, 0);

        // Добавление приемника
        Priemnik priemr = RightPanel.addPriemnik(rootNode, 10, -1, -2,180);

        // Надпись
        Label EnOut = new Label("Нажми кнопку");
        rootNode.setLeftAnchor(EnOut, 100.0);
        rootNode.setTopAnchor(EnOut, 630.0);
        rootNode.getChildren().addAll(EnOut);

        //Кнопка
        Button buttongetE = new Button("getE()");
        buttongetE.setOnAction((ae) -> {
            double sum = 0;
            double[] luchinfo;
            for (int i=0; i<=180; i=(i+(180/priem.tochn))) {
                luchinfo = priem.getE(i);
                sum = sum + luchinfo[0];
                MainGUI.LeftPanel.addLuch(MainGUI.rootNode, luchinfo[1], luchinfo[2], luchinfo[3], luchinfo[4]);
            }
            //System.out.println("Приемник получил "+sum+" энергии");
            EnOut.setText("Приемник получил "+sum+" энергии");
        });
        rootNode.setLeftAnchor(buttongetE, 100.0);
        rootNode.setTopAnchor(buttongetE, 600.0);
        rootNode.getChildren().addAll(buttongetE);

        //Показать сцену
        LFStage.show();
    }
}


