package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Groups Games = new Groups();
        Groups News = new Groups();
        Groups Joke = new Groups();
        Groups Csharp = new Groups();

        Users sub1 = new Users("RaDoN Rebirth");
        Users sub2 = new Users("XeNoN");
        Games.regObserver(sub1);
        Games.regObserver(sub2);
        News.regObserver(sub1);
        News.regObserver(sub2);
        Joke.regObserver(sub1);
        Joke.regObserver(sub2);
        Csharp.regObserver(sub2);

        Games.setNews("Рокстар сделали громкий анонс ГТА6" + "\n");
        News.setNews("В Бельгии из тюрьмы сбежал заключенный известный как Джон Марстон" + "\n");
        Joke.setNews("Перейдите по ссылке, чтобы просмотреть новую подборку шуток!" + "\n");
        Csharp.setNews("Новый метод перераспределения массива. Перейди чтобы узнать болье..." + "\n");

    }
}
interface Observable {
    void notifyObservers();
    void regObserver(Observer o);
}
interface Observer{
    void Notification(String news);
}
class Groups implements Observable{
    List<Observer> list = new ArrayList<>();
    String news;
    void setNews(String news){
        this.news = news;
        notifyObservers();
    }
    @Override
    public void notifyObservers() {
        for(Observer o: list){
            o.Notification(news);
        }
    }
    @Override
    public void regObserver(Observer o) {
        list.add(o);
    }
}
class Users implements Observer{
    String name;
    public Users(String name){
        this.name = name;
    }
    @Override
    public void Notification(String news) {
        System.out.println("Пользователю: " + name + " пришло уведомление: " + news);
    }
}
