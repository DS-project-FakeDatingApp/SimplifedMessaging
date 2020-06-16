package com.example.messaging2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private List<Chat> chatList;

    public ChatAdapter(List<Chat> chatList) {
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Chat chat = chatList.get(i);
        viewHolder.chatText.setText(chat.getContent());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(viewHolder.chatText.getLayoutParams());
        if(chat.getTargetUser().equals("Tester A")) {
            params.gravity = Gravity.LEFT;
        } else {
            params.gravity = Gravity.RIGHT;
        }
        viewHolder.chatText.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    static  class ViewHolder extends  RecyclerView.ViewHolder {

        TextView chatText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            chatText = itemView.findViewById(R.id.chatText);
        }
    }
}