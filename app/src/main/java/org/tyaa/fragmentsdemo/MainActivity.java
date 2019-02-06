package org.tyaa.fragmentsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO
        //1. Добавить в класс NewsItem поля "дата", "автор", + опциональные на выбор
        //2. В макете fragment_items_list_item сделать более выразительным вид
        // (размеры шрифтов, цвета, расположение виджетов)
        //3. На представление второй пары активность-фрагмент добавить возможность редактирования всех полей открытой новости, кроме идентификатора. При возврате на представление первой пары (списка всех новостей)
        // в отредактированной новости должны отображаться отредактированные данные

    }

    @Override
    protected Fragment createFragment() {
        return new ItemsListFragment();
    }
}
