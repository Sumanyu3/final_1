package com.example.menu;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class dragDrop_supergirls extends Activity implements View.OnTouchListener, GestureDetector.OnGestureListener, View.OnDragListener {

    int windowwidth;
    int windowheight;

    private LayoutParams layoutParams;
    private GestureDetector mGestureDetector;
    private static final String TAG = "MainActivity";

    private View checkDrag;
    boolean isGoat = false;
    boolean isHorse = false;
    boolean isHouse = false;
    boolean isGoatVis = false;
    boolean isHorseVis = false;
    boolean isHouseVis = false;

    boolean[] item_list = new boolean[10];






    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Working");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop_supergirls);

        windowwidth = getWindowManager().getDefaultDisplay().getWidth();
        windowheight = getWindowManager().getDefaultDisplay().getHeight();

        final TextView non_contagious_1 = findViewById(R.id.non_contagious_1);
        final TextView non_contagious_2 = findViewById(R.id.non_contagious_2);
        final TextView non_contagious_3 = findViewById(R.id.non_contagious_3);
        final TextView non_contagious_4 = findViewById(R.id.non_contagious_4);
        final TextView non_contagious_5 = findViewById(R.id.non_contagious_5);
        final TextView contagious_1 = findViewById(R.id.contagious_1);
        final TextView contagious_2 = findViewById(R.id.contagious_2);
        final TextView contagious_3 = findViewById(R.id.contagious_3);
        final TextView contagious_4 = findViewById(R.id.contagious_4);
        final TextView contagious_5 = findViewById(R.id.contagious_5);
        final ImageView box11 = findViewById(R.id.box11);
        final ImageView box21 = findViewById(R.id.box21);
        final ImageView box31 = findViewById(R.id.box31);
        final ImageView box41 = findViewById(R.id.box41);
        final ImageView box51 = findViewById(R.id.box51);
        final ImageView box12 = findViewById(R.id.box12);
        final ImageView box22 = findViewById(R.id.box22);
        final ImageView box32 = findViewById(R.id.box32);
        final ImageView box42 = findViewById(R.id.box42);
        final ImageView box52 = findViewById(R.id.box52);


        non_contagious_1.setOnTouchListener(this);
        non_contagious_2.setOnTouchListener(this);
        non_contagious_3.setOnTouchListener(this);
        non_contagious_4.setOnTouchListener(this);
        non_contagious_5.setOnTouchListener(this);
        contagious_1.setOnTouchListener(this);
        contagious_2.setOnTouchListener(this);
        contagious_3.setOnTouchListener(this);
        contagious_4.setOnTouchListener(this);
        contagious_5.setOnTouchListener(this);

        box11.setOnDragListener(this);
        box21.setOnDragListener(this);
        box31.setOnDragListener(this);
        box41.setOnDragListener(this);
        box51.setOnDragListener(this);
        box12.setOnDragListener(this);
        box22.setOnDragListener(this);
        box32.setOnDragListener(this);
        box42.setOnDragListener(this);
        box52.setOnDragListener(this);

        mGestureDetector = new GestureDetector(this, this);


    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        checkDrag = v;
        Log.d(TAG, "onTouch: " + v.getId());
        int action = event.getAction();

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d(TAG, "Action was DOWN");
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, shadowBuilder, v, 0);
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.d(TAG, "Action was MOVE");
                Log.d(TAG, "onTouch: " + event.getX() + " , " + event.getY());

                return true;
            case (MotionEvent.ACTION_UP):
                Log.d(TAG, "Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.d(TAG, "Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d(TAG, "Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default:
                return super.onTouchEvent(event);
        }


//        mGestureDetector.onTouchEvent(event);
//
//        return true;

    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d(TAG, "onTouch: ");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d(TAG, "onShowPress: ");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d(TAG, "onSingleTapUp: ");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d(TAG, "onScroll: ");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d(TAG, "onLongPress: ");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d(TAG, "onFling: ");
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        TextView non_contagious_1 = findViewById(R.id.non_contagious_1);
        TextView non_contagious_2 = findViewById(R.id.non_contagious_2);
        TextView non_contagious_3 = findViewById(R.id.non_contagious_3);
        TextView non_contagious_4 = findViewById(R.id.non_contagious_4);
        TextView non_contagious_5 = findViewById(R.id.non_contagious_5);
        TextView contagious_1 = findViewById(R.id.contagious_1);
        TextView contagious_2 = findViewById(R.id.contagious_2);
        TextView contagious_3 = findViewById(R.id.contagious_3);
        TextView contagious_4 = findViewById(R.id.contagious_4);
        TextView contagious_5 = findViewById(R.id.contagious_5);
        ImageView box11 = findViewById(R.id.box11);
        ImageView box21 = findViewById(R.id.box21);
        ImageView box31 = findViewById(R.id.box31);
        ImageView box41 = findViewById(R.id.box41);
        ImageView box51 = findViewById(R.id.box51);
        ImageView box12 = findViewById(R.id.box12);
        ImageView box22 = findViewById(R.id.box22);
        ImageView box32 = findViewById(R.id.box32);
        ImageView box42 = findViewById(R.id.box42);
        ImageView box52 = findViewById(R.id.box52);
        TextView text11 = findViewById(R.id.text11);
        TextView text21 = findViewById(R.id.text21);
        TextView text31 = findViewById(R.id.text31);
        TextView text41 = findViewById(R.id.text41);
        TextView text51 = findViewById(R.id.text51);
        TextView text12 = findViewById(R.id.text12);
        TextView text22 = findViewById(R.id.text22);
        TextView text32 = findViewById(R.id.text32);
        TextView text42 = findViewById(R.id.text42);
        TextView text52 = findViewById(R.id.text52);

        if (v == box11 || v == box21 || v == box31 || v == box41 || v == box51) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:

                    checkDrag.setVisibility(View.INVISIBLE);
                    Log.d(TAG, "onDrag: completed");
                    break;


                case DragEvent.ACTION_DRAG_ENDED:
                    if (item_list[corr_val(checkDrag)] == false) {
                        checkDrag.setVisibility(View.VISIBLE);
                    }

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //No action
                    break;
                case DragEvent.ACTION_DROP:


                    if (checkDrag == contagious_1 || checkDrag == contagious_2 || checkDrag == contagious_3 || checkDrag == contagious_4 || checkDrag == contagious_5) {
                        v.setVisibility(View.INVISIBLE);
                        corr_txt(v).setText(get_text((TextView)checkDrag));
                        corr_txt(v).setVisibility(View.VISIBLE);
                        // house_img_dark.setImageResource(R.drawable.house_colour);
                        item_list[corr_val(checkDrag)] = true;
                    }

                case DragEvent.ACTION_DRAG_ENTERED:
                    //No action


                    break;
            }
        } else if (v == box12 || v == box22 || v == box32 || v == box42 || v == box52) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d(TAG, "onDrag: non contagious");
                    checkDrag.setVisibility(View.INVISIBLE);
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    if (item_list[corr_val(checkDrag)] == false) {
                       checkDrag.setVisibility(View.VISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //No action
                    break;
                case DragEvent.ACTION_DROP:


                    if (checkDrag==non_contagious_1||checkDrag==non_contagious_2||checkDrag==non_contagious_3||checkDrag==non_contagious_4||checkDrag==non_contagious_5) {
                        v.setVisibility(View.INVISIBLE);
                        corr_txt(v).setText(get_text((TextView)checkDrag));
                        corr_txt(v).setVisibility(View.VISIBLE);
                       // house_img_dark.setImageResource(R.drawable.house_colour);
                        item_list[corr_val(checkDrag)] = true;
                    }
                case DragEvent.ACTION_DRAG_ENTERED:
                    //No action
                    break;
            }
        }




        if(isGoat==true && isHorse==true && isHouse==true){
            TextView horse_later = findViewById(R.id.horse_later);
            TextView house_later = findViewById(R.id.house_later);
            TextView goat_later = findViewById(R.id.goat_later);

            horse_later.setVisibility(View.VISIBLE);
            house_later.setVisibility(View.VISIBLE);
            goat_later.setVisibility(View.VISIBLE);
        }
        return true;
    }

    public int corr_val(View item){
        if(item.getId()==R.id.contagious_1){
            return 0;
        }
        else if(item.getId()==R.id.contagious_2){
            return 1;
        }
        else if(item.getId()==R.id.contagious_3){
            return 2;
        }
        else if(item.getId()==R.id.contagious_4){
            return 3;
        }
        else if(item.getId()==R.id.contagious_5){
            return 4;
        }
        else if(item.getId()==R.id.non_contagious_1){
            return 5;
        }
        else if(item.getId()==R.id.non_contagious_2){
            return 6;
        }
        else if(item.getId()==R.id.non_contagious_3){
            return 7;
        }
        else if(item.getId()==R.id.non_contagious_4){
            return 8;
        }
        else if(item.getId()==R.id.non_contagious_5){
            return 9;
        }
        else{
            return -1;
        }

    }
    public TextView corr_txt(View item){
        if(item.getId()==R.id.box11){
            return findViewById(R.id.text11);
        }
        else if(item.getId()==R.id.box21){
            return findViewById(R.id.text21);
        }
        else if(item.getId()==R.id.box31){
            return findViewById(R.id.text31);
        }
        else if(item.getId()==R.id.box41){
            return findViewById(R.id.text41);
        }
        else if(item.getId()==R.id.box51){
            return findViewById(R.id.text51);
        }
        else if(item.getId()==R.id.box12){
            return findViewById(R.id.text12);
        }
        else if(item.getId()==R.id.box22){
            return findViewById(R.id.text22);
        }
        else if(item.getId()==R.id.box32){
            return findViewById(R.id.text32);
        }
        else if(item.getId()==R.id.box42){
            return findViewById(R.id.text42);
        }
        else if(item.getId()==R.id.box52){
            return findViewById(R.id.text52);
        }
        else{
            return null;
        }

    }

    public String get_text(TextView v){
        return v.getText().toString();
    }
}