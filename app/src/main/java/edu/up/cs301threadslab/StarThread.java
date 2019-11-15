package edu.up.cs301threadslab;

import android.util.Log;

public class StarThread extends Thread {
    private AnimationView myAV;

    public StarThread(AnimationView av) {
        myAV = av;
    }

    @Override
    public void run() {
        while(true) {
            Log.i("msg", "twinkle");
            myAV.postInvalidate();
            try {
                this.sleep(50);
            } catch (InterruptedException e) {
                Log.i("msg", "Bad");
            }
        }
    }
}
