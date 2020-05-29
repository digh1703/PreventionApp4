package com.example.preventionapp;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

class Listener implements OnCompleteListener<QuerySnapshot> {
    ArrayList<BoardContentsListItem> contentsList = new ArrayList<BoardContentsListItem>();
    Task<QuerySnapshot> task;

    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                contentsList.add(new BoardContentsListItem(
                        document.getData().get("title").toString(),
                        document.getData().get("nickname").toString(),
                        document.getData().get("date").toString(),
                        document.getData().get("contents").toString(),
                        (Long)document.getData().get("replyNum"),
                        (Long)document.getData().get("recommendNum")
                ));
            }
        }
    }

    public ArrayList<BoardContentsListItem> getContentsList(){
        return contentsList;
    }
}
