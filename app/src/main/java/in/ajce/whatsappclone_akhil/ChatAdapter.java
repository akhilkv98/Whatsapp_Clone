package in.ajce.whatsappclone_akhil;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    Context context;
    List<ChatModel> chatModelList;

    public ChatAdapter(Context context,List<ChatModel> chatModelList) {
        this.context = context;
        this.chatModelList=chatModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.textViewName.setText(chatModelList.get(position).name);
        viewHolder.textViewMessage.setText(chatModelList.get(position).message);
        viewHolder.textViewTime.setText(chatModelList.get(position).time);
        Glide.with(context).load(chatModelList.get(position).imgUrl).into(viewHolder.imageViewProfile);

    }

    @Override
    public int getItemCount() {
        return chatModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewMessage;
        TextView textViewTime;
        ImageView imageViewProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView3);
            textViewMessage=itemView.findViewById(R.id.textView4);
            textViewTime=itemView.findViewById(R.id.textView5);
            imageViewProfile=itemView.findViewById(R.id.imageView);
        }
    }
}
