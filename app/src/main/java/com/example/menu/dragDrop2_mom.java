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


public class dragDrop2_mom extends Activity implements View.OnTouchListener, View.OnDragListener, GestureDetector.OnGestureListener {

    int windowwidth;
    int windowheight;

    private LayoutParams layoutParams;
    private GestureDetector mGestureDetector;
    private static final String TAG = "MainActivity";

    private View checkDrag;
    boolean isTeacher = false;
    boolean isDoctor = false;
    boolean isPolice = false;
    boolean isTeacherVis = false;
    boolean isDoctorVis = false;
    boolean isPoliceVis = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop2_mom);
        Log.d(TAG, "onCreate: Working");
        super.onCreate(savedInstanceState);

        windowwidth = getWindowManager().getDefaultDisplay().getWidth();
        windowheight = getWindowManager().getDefaultDisplay().getHeight();

        final ImageView stethoscope = findViewById(R.id.stethoscope);
        final ImageView gun = findViewById(R.id.gun);
        final ImageView book = findViewById(R.id.book);
        final ImageView boxStethoscope = findViewById(R.id.box_doctor);
        final ImageView boxGun = findViewById(R.id.box_police);
        final ImageView boxBook = findViewById(R.id.box_teacher);


        stethoscope.setOnTouchListener(this);
        gun.setOnTouchListener(this);
        book.setOnTouchListener(this);
        boxStethoscope.setOnDragListener(this);
        boxGun.setOnDragListener(this);
        boxBook.setOnDragListener(this);
        mGestureDetector = new GestureDetector(this, this);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        checkDrag = v;
        int action = event.getAction();

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d(TAG, "Action was DOWN");
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, shadowBuilder, v,  0);
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
        ImageView boxStethoscope = findViewById(R.id.box_doctor); //goat
        ImageView boxGun = findViewById(R.id.box_police); //house
        ImageView boxBook = findViewById(R.id.box_teacher); //horse
        ImageView stethoscope = findViewById(R.id.stethoscope); //goat
        ImageView gun = findViewById(R.id.gun); //house
        ImageView book = findViewById(R.id.book); //horse

        if (v == boxStethoscope) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if(checkDrag==stethoscope){
                        stethoscope.setVisibility(View.INVISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    if(!isDoctorVis){
                        stethoscope.setVisibility(View.VISIBLE);
                    }

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //No action
                    break;
                case DragEvent.ACTION_DROP:
                    if (checkDrag == stethoscope) {
                        stethoscope.setVisibility(View.INVISIBLE);
                        boxStethoscope.setImageResource(R.drawable.stethoscope);
                        isDoctor=true;
                        isDoctorVis=true;
                    }
                case DragEvent.ACTION_DRAG_ENTERED:
                    //No action
                    break;
            }
        }

        else if(v==boxGun){
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if(checkDrag==gun) {
                        gun.setVisibility(View.INVISIBLE);
                        break;
                    }
                case DragEvent.ACTION_DRAG_ENDED:
                    if(!isPoliceVis){
                        gun.setVisibility(View.VISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //No action
                    break;
                case DragEvent.ACTION_DROP:
                    if (checkDrag == gun) {
                        gun.setVisibility(View.INVISIBLE);
                        boxGun.setImageResource(R.drawable.gun);
                        isPolice=true;
                        isPoliceVis = true;
                    }
                case DragEvent.ACTION_DRAG_ENTERED:
                    //No action
                    break;
            }
        }

        else if(v==boxBook){
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if(checkDrag==book) {
                        book.setVisibility(View.INVISIBLE);
                        break;
                    }
                case DragEvent.ACTION_DRAG_ENDED:
                    if(!isTeacherVis){
                        book.setVisibility(View.VISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //No action
                    break;
                case DragEvent.ACTION_DROP:
                    if (checkDrag == book) {
                        book.setVisibility(View.INVISIBLE);
                        boxBook.setImageResource(R.drawable.book);
                        isTeacher=true;
                        isTeacherVis = true;
                    }
                case DragEvent.ACTION_DRAG_ENTERED:
                    //No action
                    break;
            }
        }

        if(isDoctor==true && isPolice==true && isTeacher==true){
            TextView doctor_txt = findViewById(R.id.doctor_txt);
            TextView police_txt = findViewById(R.id.police_txt);
            TextView teacher_txt = findViewById(R.id.teacher_txt);

            doctor_txt.setVisibility(View.VISIBLE);
            police_txt.setVisibility(View.VISIBLE);
            teacher_txt.setVisibility(View.VISIBLE);
        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}