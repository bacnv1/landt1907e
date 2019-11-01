package com.t3h.buoi6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {
    private Button btnAlpha;
    private Button btnTranslate;
    private Button btnScale;
    private Button btnRotate;
    private Button btnSet;
    private ImageView imRotate;

    private Animation alpha;
    private Animation translate;
    private Animation scale;
    private Animation rotate;
    private Animation set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initAnimations();
    }

    private void initAnimations() {
        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        set = AnimationUtils.loadAnimation(this, R.anim.set);

        alpha.setAnimationListener(this);
        rotate.setAnimationListener(this);
        scale.setAnimationListener(this);
        translate.setAnimationListener(this);
        set.setAnimationListener(this);

        imRotate.setVisibility(View.GONE);
    }

    private void initViews() {
        btnAlpha = findViewById(R.id.btn_alpha);
        btnRotate =  findViewById(R.id.btn_rotate);
        btnScale = findViewById(R.id.btn_scale);
        btnTranslate = findViewById(R.id.btn_translate);
        btnSet = findViewById(R.id.btn_set);

        imRotate = findViewById(R.id.im_rotate);

        btnSet.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha:
                imRotate.startAnimation(alpha);
                break;
            case R.id.btn_rotate:
                imRotate.startAnimation(rotate);
                break;
            case R.id.btn_scale:
                imRotate.startAnimation(scale);
                break;
            case R.id.btn_set:
                imRotate.startAnimation(set);
                break;
            case R.id.btn_translate:
                imRotate.setVisibility(View.VISIBLE);
                imRotate.startAnimation(translate);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {
        if (animation.equals(alpha)) {
            Toast.makeText(this, "Alpha", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Other", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
