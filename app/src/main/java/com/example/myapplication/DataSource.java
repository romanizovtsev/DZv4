package com.example.myapplication;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    static Integer t;
        private final List<NumbModel> mData;
        private static DataSource sInstance;

        public DataSource() {
            mData = new ArrayList<>();
            int color;
            for (int i = 0; i < 100; i++) {
                t=i+1;
                String titleNumb = t.toString();
                if(t%2==0)
               color = Color.RED;
                else
                    color=Color.BLUE;
                mData.add(new NumbModel(titleNumb, color));
            }
        }
        public List<NumbModel> getRemoteData() {
            return mData;
        }
        public synchronized static DataSource getInstance() {
            if (sInstance == null) {
                sInstance = new DataSource();
            }
            return sInstance;
        }
        public static NumbModel AddItem()
        {t++;
        int color;
            if(t%2==0)
                color = Color.RED;
            else
                color=Color.BLUE;
           return new NumbModel(t.toString(), color);

        }
    }

