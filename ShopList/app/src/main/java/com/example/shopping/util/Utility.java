package com.example.shopping.util;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.shopping.R;
import com.example.shopping.adt.ItemList;
import com.example.shopping.childActivities.LikeActivity;

import java.util.ArrayList;
import java.util.List;

public class Utility {



    public enum Category {home, fish, meat, bake, drink, office, sauce, fruit, vege,
        digital, chick, cow, pig, egg, alcoh, milk, soy_drink, other}


    public static void setNavigationBarColor(Activity activity, String color) {
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setNavigationBarColor(Color.parseColor(color));
        }
    }

    public static void setFullScreen(Activity activity) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static boolean containsCaseInsensitive(String s1, String s2) {
        return s1.toLowerCase().contains(s2.toLowerCase());
    }

    public static void setBtnBackground(Button btn, Category category) {
        switch (category) {
            case soy_drink:
                btn.setBackgroundResource(R.drawable.soy_drink_btn_style);
                return;
            case sauce:
                btn.setBackgroundResource(R.drawable.soy_sauce_btn_style);
                return;
            case digital:
                btn.setBackgroundResource(R.drawable.digital_btn_style);
                return;
            case fish:
                btn.setBackgroundResource(R.drawable.fish_btn_style);
                return;
            case milk:
                btn.setBackgroundResource(R.drawable.milk_btn_style);
                return;
            case bake:
                btn.setBackgroundResource(R.drawable.cake_btn_style);
                return;
            case egg:
                btn.setBackgroundResource(R.drawable.egg_btn_style);
                return;
            case chick:
                btn.setBackgroundResource(R.drawable.chick_btn_style);
                return;
            case home:
                btn.setBackgroundResource(R.drawable.home_btn_style);
                return;
            case office:
                btn.setBackgroundResource(R.drawable.office_btn_style);
                return;
            case drink:
                btn.setBackgroundResource(R.drawable.drink_btn_style);
                return;
            case cow:
                btn.setBackgroundResource(R.drawable.cow_btn_style);
                return;
            case pig:
                btn.setBackgroundResource(R.drawable.pig_btn_style);
                return;
            case vege:
                btn.setBackgroundResource(R.drawable.vege_btn_style);
                return;
            case meat:
                btn.setBackgroundResource(R.drawable.meat_btn_style);
                return;
            case alcoh:
                btn.setBackgroundResource(R.drawable.alcoh_btn_style);
                return;
            case fruit:
                btn.setBackgroundResource(R.drawable.fruit_btn_style);
                return;
            default:
                btn.setBackgroundResource(R.drawable.item_btn_style);
                return;
        }
    }

    public static void setImgBackground(ImageView imageView, Category category) {
        switch (category) {
            case soy_drink:
                imageView.setBackgroundResource(R.drawable.soy_drink);
                return;
            case sauce:
                imageView.setBackgroundResource(R.drawable.soy_sauce);
                return;
            case digital:
                imageView.setBackgroundResource(R.drawable.digital);
                return;
            case fish:
                imageView.setBackgroundResource(R.drawable.fish);
                return;
            case milk:
                imageView.setBackgroundResource(R.drawable.milk);
                return;
            case bake:
                imageView.setBackgroundResource(R.drawable.cake);
                return;
            case egg:
                imageView.setBackgroundResource(R.drawable.egg);
                return;
            case chick:
                imageView.setBackgroundResource(R.drawable.chicken);
                return;
            case home:
                imageView.setBackgroundResource(R.drawable.home);
                return;
            case office:
                imageView.setBackgroundResource(R.drawable.office);
                return;
            case drink:
                imageView.setBackgroundResource(R.drawable.drink);
                return;
            case cow:
                imageView.setBackgroundResource(R.drawable.cow);
                return;
            case pig:
                imageView.setBackgroundResource(R.drawable.pig);
                return;
            case vege:
                imageView.setBackgroundResource(R.drawable.vege);
                return;
            case meat:
                imageView.setBackgroundResource(R.drawable.meat);
                return;
            case alcoh:
                imageView.setBackgroundResource(R.drawable.alco);
                return;
            case fruit:
                imageView.setBackgroundResource(R.drawable.apple);
                return;
            default:
                imageView.setBackgroundResource(R.drawable.item);
                return;
        }
    }

    private static boolean isInArray(String name, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (containsCaseInsensitive(name, array[i]))
                return true;
        }
        return false;
    }

    public static Category categorize(String name) {

        String[] milk = {"奶", "milk"};
        if (isInArray(name, milk))
            return Category.milk;

        String[] soyDrink = {"豆浆", "soy"};
        if (isInArray(name, soyDrink))
            return Category.soy_drink;

        String[] digital = {"键盘", "鼠标", "主机", "主板", "显卡", "网卡", "声卡", "电脑", "笔记本", "平板", "手机", "硬盘", "耳机", "音箱", "游戏机",
                "keyboard", "mouse", "mother board", "computer", "laptop", "phone", "graphic card", "play station", "xbox", "macbook", "ipad", "pixel",
                "beats", "bose", "switch", "game", "thinkpad"};
        if (isInArray(name, digital))
            return Category.digital;

        String[] fish = {"鱼", "fish", "salmon", "三文", "虾", "shrimp", "lobster", "sea", "海", "蟹", "crab", "eel", "鳝", "oyster", "mussel", "cockle",
                "贝", "蛤", "蚝", "花甲", "abalone"};
        if (isInArray(name, fish))
            return Category.fish;

        String[] bake = {"糕", "cake", "bread", "面包", "松饼", "muffin"};
        if (isInArray(name, bake))
            return Category.bake;

        String[] egg = {"蛋", "egg"};
        if (isInArray(name, egg))
            return Category.egg;

        String[] sauce = {"酱", "sauce"};
        if (isInArray(name, sauce))
            return Category.sauce;

        String[] chick = {"鸡", "chick", "wing"};
        if (isInArray(name, chick))
            return Category.chick;

        String[] home = {"家", "餐巾", "餐厨", "home", "napkin", "toilet", "towel", "soap", "肥皂", "洗洁精", "dishwashing", "dish washing", "dish-washing"};
        if (isInArray(name, home))
            return Category.home;

        String[] office = {"book", "本", "纸", "paper", "订书", "笔", "墨", "打印", "美工刀", "ink", "pen", "staple", "print", "尺", "橡皮", "量角器", "protractor",
                "eraser", "ruler"};
        if (isInArray(name, office))
            return Category.office;

        String[] drink = {"饮料", "雪碧", "芬达", "茶", "drinking", "sprite", "fanta", "tea"};
        if (isInArray(name, drink))
            return Category.drink;

        String[] cow = {"牛", "beef", "veal", "steak", "sirloin"};
        if (isInArray(name, cow))
            return Category.cow;

        String[] pig = {"猪", "pig", "pork", "bacon", "培根"};
        if (isInArray(name, pig))
            return Category.pig;

        String[] vege = {"菜", "cabbage", "西兰花", "broccoli", "玉米", "corn", "黄瓜", "cucumber", "lettuce",
                "南瓜", "pumpkin", "beetroot", "sprout", "豆", "peas", "萝卜", "radish", "蒜", "garlic", "bean",
                "姜", "ginger"};
        if (isInArray(name, vege))
            return Category.vege;

        String[] meat = {"肉", "meat", "肠", "sausage", "肺", "心", "腰", "kidney"};
        if (isInArray(name, meat))
            return Category.meat;

        String[] alcoh = {"酒", "龙舌兰", "威士忌", "伏特加", "beer", "rum", "tequila", "wine",
                "whiskey", "margarita", "vodka"};
        if (isInArray(name, alcoh))
            return Category.alcoh;

        String[] fruit = {"果", "香蕉", "瓜", "葡萄", "莓", "菠萝", "橘", "榴莲", "荔枝", "山竹", "梨", "石榴",
                "桃", "banana", "香蕉", "apple", "melon", "cherry", "cherries", "peach", "cantaloupe", "carambola", "coconut", "椰", "durian",
                "lemon", "柠檬", "kumquat", "mango", "mandarin", "lychee", "pear", "pomegranate"};
        if (isInArray(name, fruit))
            return Category.fruit;

        return Category.other;
    }

    public static String[] readInput(String input) {
        String[] items = input.split(",");
        List<String> allitems = new ArrayList();
        for (int i=0; i<items.length; i++) {
            String[] subItems = items[i].trim().split("，");
            for (int j=0; j<subItems.length; j++) {
                allitems.add(subItems[j]);
            }
        }
        String[] all = new String[allitems.size()];
        for (int i=0; i<allitems.size(); i++)
            all[i] = allitems.get(i);
        return all;
    }


    public static void main(String[] args) {
        System.out.println("Apple".contains("apple"));
        System.out.println(categorize(("chicken")));
    }
}
