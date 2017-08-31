package org.buffer.adaptablebottomnavigation.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

/**
 * Created by Saad on 8/26/17.
 */





public class SettingsFragment extends Fragment {

    private static String ARG_IMAGE_RESOURCE = "ARG_IMAGE_RESOURCE";
    private int imageRes;

    int myProgress = 0;
    ProgressBar progressBar;

    public static SettingsFragment newInstance(String imageRes) {
        SettingsFragment imageFragment = new SettingsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_IMAGE_RESOURCE, "");
        imageFragment.setArguments(bundle);
        return imageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageRes = getArguments().getInt(ARG_IMAGE_RESOURCE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.settings, container, false);

        // ImageView iconImage = (ImageView) fragmentView.findViewById(R.id.image_icon);
        //iconImage.setImageResource(imageRes);


        return fragmentView;
    }
}

