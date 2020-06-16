package com.example.messaging2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView chatList = findViewById(R.id.chatList);

        final List<Chat> chatData = new ArrayList<Chat>();
        final ChatAdapter chatAdapter = new ChatAdapter(chatData);
        chatList.setAdapter(chatAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        chatList.setLayoutManager(layoutManager);

        final Spinner targetUser = findViewById(R.id.targetUser);
        String[] data = {"Tester A","Tester B"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,R.layout.support_simple_spinner_dropdown_item,data);
        targetUser.setAdapter(adapter);

        final EditText chatContent = findViewById(R.id.chatContent);

        Button chatSubmit = findViewById(R.id.chatSubmit);
        chatSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!chatContent.getText().toString().equals("")) {
                    String user = targetUser.getSelectedItem().toString();
                    chatData.add(new Chat(user, chatContent.getText().toString()));

                    chatAdapter.notifyItemInserted(chatData.size() - 1);
                    chatList.scrollToPosition(chatData.size() - 1);
                    chatContent.setText("");
                }
            }
        });
    }
}
