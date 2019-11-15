package edu.up.cs301threadslab;

import android.util.Log;

public class StarAutoAddRemoveThread extends Thread {
    private AnimationView myAV;
    private StarAnimation mySA;

    public StarAutoAddRemoveThread(AnimationView av) {
        myAV = av;
        mySA = (StarAnimation)av.getStarAnimation();
    }

    @Override
    public void run() {
        while(true) {
            int rando = (int) (Math.random() * 2);
            if (rando == 0) {
                //Log.i("msg", "remove");
                mySA.removeStar();
                myAV.postInvalidate();
            } else {
                //Log.i("msg", "add");
                mySA.addStar();
                myAV.postInvalidate();
            }

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                Log.i("msg", "Bad");
            }
        }
    }
}
