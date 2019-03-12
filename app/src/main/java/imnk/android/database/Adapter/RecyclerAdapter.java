package imnk.android.database.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import imnk.android.database.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<RecyclerData> dataList;
    private Context context;

    public RecyclerAdapter(List<RecyclerData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView summary, description;
        CheckBox status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            summary = itemView.findViewById(R.id.tv_summary);
            description = itemView.findViewById(R.id.tv_description);
            status = itemView.findViewById(R.id.cb_checkbox);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_data_list, parent, false);
        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        final RecyclerData current = dataList.get(position);
        holder.summary.setText(current.getSummary());
        holder.description.setText(current.getDescription());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
