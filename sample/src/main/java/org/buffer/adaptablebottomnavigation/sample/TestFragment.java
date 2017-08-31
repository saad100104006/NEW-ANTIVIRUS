package org.buffer.adaptablebottomnavigation.sample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.buffer.adaptablebottomnavigation.view.AdaptableBottomNavigationView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Saad on 8/26/17.
 */



public class TestFragment extends Fragment {

    private static String ARG_IMAGE_RESOURCE = "ARG_IMAGE_RESOURCE";
    private int imageRes;

    int myProgress = 0;
  //  ProgressBar progressBar;
    private Timer timer;
    private Timer timer2;
    ArcProgress arcProcess;
    TextView capacity;

    LinearLayout antiVirus;

    ArcProgress arcStore;

    private AdaptableBottomNavigationView bottomNavigationView;


    public static TestFragment newInstance(String imageRes) {
        TestFragment imageFragment = new TestFragment();
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

    @Override
    public void onResume() {
        super.onResume();
        fillData();
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        timer2.cancel();
        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main1, container, false);

       // ImageView iconImage = (ImageView) fragmentView.findViewById(R.id.image_icon);
        //iconImage.setImageResource(imageRes);

    //     progressBar = (ProgressBar)fragmentView. findViewById(R.id.progressBarStyleHorizontal);

         arcProcess = (ArcProgress) fragmentView. findViewById(R.id.arc_process);

        capacity=(TextView) fragmentView. findViewById(R.id.capacity);

        arcStore=(ArcProgress) fragmentView. findViewById(R.id.arc_store);

        antiVirus=(LinearLayout)fragmentView. findViewById(R.id.antivirus);


        antiVirus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),AntivirusActivity.class);
                startActivity(intent);
            }
        });


     //   progressBar.setProgress(65);




    /*     Runnable myThread = new Runnable(){
            @Override
            public void run() {
                while (myProgress<100){
                    try{
                        System.out.println("SSS");
                        progressBar.setProgress(myProgress);
                     //   progressBar.setText(myProgress+"/100");
                        myHandle.sendMessage(myHandle.obtainMessage());
                        Thread.sleep(500);
                    }
                    catch(Throwable t){
                    }
                }
            }

            Handler myHandle = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    myProgress++;
                    progressBar.setProgress(myProgress);
                   // pb.setText(myProgress+"/100");
                }
            };
        };*/

        //new Thread(myThread).start();

        return fragmentView;
    }

    private void fillData() {
        // TODO Auto-generated method stub
        timer = null;
        timer2 = null;
        timer = new Timer();
        timer2 = new Timer();


        long l = AppUtil.getAvailMemory(getActivity());
        long y = AppUtil.getTotalMemory(getActivity());
        final double x = (((y - l) / (double) y) * 100);
        //   arcProcess.setProgress((int) x);

        arcProcess.setProgress(0);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        if (arcProcess.getProgress() >= (int) x) {
                            timer.cancel();
                        } else {
                            arcProcess.setProgress(arcProcess.getProgress() + 1);
                        }

                    }
                });
            }
        }, 50, 20);

        SDCardInfo mSDCardInfo = StorageUtil.getSDCardInfo();
        SDCardInfo mSystemInfo = StorageUtil.getSystemSpaceInfo(getActivity());

        long nAvailaBlock;
        long TotalBlocks;
        if (mSDCardInfo != null) {
            nAvailaBlock = mSDCardInfo.free + mSystemInfo.free;
            TotalBlocks = mSDCardInfo.total + mSystemInfo.total;
        } else {
            nAvailaBlock = mSystemInfo.free;
            TotalBlocks = mSystemInfo.total;
        }

        final double percentStore = (((TotalBlocks - nAvailaBlock) / (double) TotalBlocks) * 100);

        capacity.setText(StorageUtil.convertStorage(TotalBlocks - nAvailaBlock) + "/" + StorageUtil.convertStorage(TotalBlocks));
        arcStore.setProgress(0);

        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        if (arcStore.getProgress() >= (int) percentStore) {
                            timer2.cancel();
                        } else {
                            arcStore.setProgress(arcStore.getProgress() + 1);
                        }

                    }
                });
            }
        }, 50, 20);


    }
}
