package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Controller {

//Окно отрисовки объектов
@FXML
private Canvas cBasic;

@FXML
private AnchorPane APMenu;

//Инициализация при запуске формы
@FXML
public void initialize(){

        //Частота отрисовки
        double deltaTime = 1./60;

        //Проверка на зажатие кнопки
        AtomicBoolean KeyHold = new AtomicBoolean(false);

        //Графический контекст для отрисовки объектов
        GraphicsContext gcBasic = cBasic.getGraphicsContext2D();

        //Прицел игрока
        Model.Aim aim = new Model.Aim(cBasic.getHeight(), cBasic.getWidth());

        //Описание настроек игры
        Model.GameOptions Game = new Model.GameOptions(1, 10);

        //Создание списка метеоритов
        ArrayList<Model.Meteor> MeteorList = new ArrayList<>();
        for (int i = 0; i < Game.MeteorsCount; i++)
            MeteorList.add(new Model.Meteor("Image/Asteroid.png", cBasic.getHeight(), cBasic.getWidth()));

        //Список нажатых клавишь
        ArrayList<String> KeyList = new ArrayList<>();

        //Добавление действий на форму | Действие при нажатие клавиши
        APMenu.setOnKeyPressed(
                (KeyEvent e) ->{
                    if (!KeyHold.get()) {
                        if (e.getCode().toString().equals("CONTROL") || e.getCode().toString().equals("ALT_GRAPH"))
                            KeyList.add("ALT_GRAPH");
                        else if (e.getCode().toString().equals("ALT"))
                            KeyList.add(e.getCode().toString());
                        else if (e.getText().length() == 1)
                            KeyList.add(new Model().RusText(e.getText().toCharArray()[0]));
                        KeyList.remove("");
                        System.out.println(KeyList);
                        KeyHold.set(true);
                    }
                }
        );

        //Добавление действий на форму | Действие при отпускание клавиши
        APMenu.setOnKeyReleased(
                (KeyEvent e) -> KeyHold.set(false)
        );

        //ArrayList<Method.Sprite> Bullet = new ArrayList<Method.Sprite>();

        //Поток анимации объектов
        AnimationTimer gameLoop = new AnimationTimer(){
            @Override
            public void handle(long nanotime){

                //Действие при нажатии правого альта
                if (KeyList.contains("ALT_GRAPH")){
                    aim.AimToMeteor(MeteorList, true);
                    KeyList.remove("ALT_GRAPH");
                }

                //Действие при нажатии левого альта
                if (KeyList.contains("ALT")){
                    aim.AimToMeteor(MeteorList, false);
                    KeyList.remove("ALT");
                }

                //Действие при вводе буквы
                if (new Model().IndexRusEng(KeyList) != -1){
                    aim.Fire(KeyList.get(0).toCharArray()[0]);
                    KeyList.remove(new Model().IndexRusEng(KeyList));
                }

                //Очитска формы
                gcBasic.clearRect(0,0, cBasic.getWidth(), cBasic.getHeight());

                //Обновление списка метеоритов
                for (Model.Sprite Meteor : MeteorList)
                    Meteor.update(deltaTime);

                //Обновление прицела
                aim.update(deltaTime);

                //Отрисовка списка метеоритов
                for (Model.Sprite Meteor : MeteorList)
                    Meteor.render(gcBasic);

                //Отрисовка прицела
                aim.render(gcBasic);

            }
        };

        gameLoop.start();


    }
}
