package com.example.view_binding_tutorial;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.view_binding_tutorial.bookfragment.BookFragment;
import com.example.view_binding_tutorial.bookfragment.GroupFragment;
import com.example.view_binding_tutorial.languagefragment.LanguageFragment;
import com.example.view_binding_tutorial.userratingfragment.UserRatingFragment;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ResideMenu resideMenu;
    private Context mContext;
    private ResideMenuItem itemBooks;
    private ResideMenuItem itemRules;
    private ResideMenuItem itemAbout_us;
    private ResideMenuItem itemSignin;
    private ResideMenuItem itemUserRating;
    private ResideMenuItem itemChangeLanguage;
    private ResideMenuItem itemGroup;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        setUpMenu();
        if( savedInstanceState == null )
            changeFragment(new BookFragment());

    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.6f);

        // create menu items;
        itemBooks = new ResideMenuItem(this, R.drawable.ic_baseline_format_list_bulleted_24,     getResources().getString(R.string.Books));
        itemRules = new ResideMenuItem(this, R.drawable.ic_baseline_event_note_24, getResources().getString(R.string.Rules));
        itemGroup = new ResideMenuItem(this, R.drawable.ic_baseline_account_balance_24, getResources().getString(R.string.Groups));
        itemAbout_us = new ResideMenuItem(this, R.drawable.rotate, getResources().getString(R.string.About));
        itemSignin = new ResideMenuItem(this, R.drawable.ic_outline_exit_to_app_24, getResources().getString(R.string.Sign_in));
        itemChangeLanguage = new ResideMenuItem(this, R.drawable.ic_baseline_language_24, getResources().getString(R.string.Change_Language));
        itemUserRating = new ResideMenuItem(this, R.drawable.ic_baseline_supervised_user_circle_24, getResources().getString(R.string.Users_Rating));

        itemBooks.setOnClickListener(this);
        itemAbout_us.setOnClickListener(this);
        itemRules.setOnClickListener(this);
        itemGroup.setOnClickListener(this);
        itemSignin.setOnClickListener(this);
        itemChangeLanguage.setOnClickListener(this);
        itemUserRating.setOnClickListener(this);

        resideMenu.addMenuItem(itemBooks, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemGroup, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemSignin, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemUserRating, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemRules, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemAbout_us, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemChangeLanguage, ResideMenu.DIRECTION_LEFT);

        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {

        if (view == itemBooks){
            changeFragment(new BookFragment());
        } else if (view == itemGroup){
            changeFragment(new GroupFragment());
        }else if (view == itemRules){
            changeFragment(new RUlesFragment());
        }else if (view == itemAbout_us){
            changeFragment(new AboutUsFragment());
        }else if (view == itemSignin){
            changeFragment(new Sign_inFragment());
        }else if (view == itemChangeLanguage){
            changeFragment(new LanguageFragment());
        }else if (view == itemUserRating){
            changeFragment(new UserRatingFragment());
        }


        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu(){
        return resideMenu;
    }
}

