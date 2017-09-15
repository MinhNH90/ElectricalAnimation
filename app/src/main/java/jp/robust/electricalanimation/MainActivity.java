package jp.robust.electricalanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements View.OnClickListener {

    private RelativeLayout lnLight;
    private View rlBackgroundLight;
    private View viewLight;

    private Animation animationScaleUp;
    private Animation animationScaleDown;

    private Animation animationShow;
    private Animation animationHidden;

    private boolean isScale = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        animationScaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        animationScaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        animationShow = AnimationUtils.loadAnimation(this, R.anim.alpha_show);
        animationHidden = AnimationUtils.loadAnimation(this, R.anim.alpha_hidden);

        lnLight = (RelativeLayout) findViewById(R.id.lnLight);
        rlBackgroundLight = (View) findViewById(R.id.rlBackgroundLight);
        viewLight = (View) findViewById(R.id.viewLight);

        lnLight.setOnClickListener(this);

        animationScaleUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                rlBackgroundLight.startAnimation(animationShow);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                viewLight.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animationScaleDown.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                rlBackgroundLight.startAnimation(animationHidden);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                viewLight.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animationShow.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rlBackgroundLight.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animationHidden.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rlBackgroundLight.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lnLight:
                if (!isScale) {
                    viewLight.startAnimation(animationScaleUp);
                    isScale = true;

                } else {
                    viewLight.startAnimation(animationScaleDown);
                    isScale = false;
                }
                break;

            default:
                break;
        }
    }
}
