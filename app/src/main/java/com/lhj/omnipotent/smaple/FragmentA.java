package com.lhj.omnipotent.smaple;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lhj.omnipotent.OmnipotentManager;

public class FragmentA extends Fragment {
    int count = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,null);
        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                //发送数据，并接收返回值
                String s = OmnipotentManager.getInstance().invokeInterface("btn1",count,String.class);
                Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


}
