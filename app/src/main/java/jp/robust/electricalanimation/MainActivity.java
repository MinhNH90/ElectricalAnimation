package jp.robust.electricalanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements View.OnClickListener {

    private RelativeLayout rlBackgroundLight;
    private View viewLight;

    private Animation animationScaleUp;
    private Animation animationScaleDown;

    private boolean isScale = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        animationScaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        animationScaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        rlBackgroundLight = (RelativeLayout) findViewById(R.id.rlBackgroundLight);
        viewLight = (View) findViewById(R.id.viewLight);

        rlBackgroundLight.setOnClickListener(this);

        animationScaleUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

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

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                viewLight.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlBackgroundLight:
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
