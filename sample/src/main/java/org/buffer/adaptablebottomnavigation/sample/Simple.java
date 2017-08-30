package org.buffer.adaptablebottomnavigation.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.glomadrian.dashedcircularprogress.DashedCircularProgress;

/**
 * @author Adrián García Lomas
 */
public class Simple extends Fragment {

    private static String ARG_IMAGE_RESOURCE = "ARG_IMAGE_RESOURCE";

    private Button restartButton;
    private DashedCircularProgress dashedCircularProgress;
    private TextView numbers;

    public static Simple newInstance(String imageRes) {
        Simple imageFragment = new Simple();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_IMAGE_RESOURCE, "");
        imageFragment.setArguments(bundle);
        return imageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.scan, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        restartButton = (Button) view.findViewById(R.id.restart);
        dashedCircularProgress = (DashedCircularProgress) view.findViewById(R.id.simple);
        numbers = (TextView) view.findViewById(R.id.number);
        animate();

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart();
            }
        });

        dashedCircularProgress.setOnValueChangeListener(
                new DashedCircularProgress.OnValueChangeListener() {
                    @Override
                    public void onValueChange(float value) {
                        numbers.setText((int) value + "");
                    }
                });
    }

    public static Simple getInstance() {
        return new Simple();
    }

    private void restart() {
        dashedCircularProgress.reset();
        animate();
    }

    private void animate() {
        dashedCircularProgress.setValue(999);
    }
}
