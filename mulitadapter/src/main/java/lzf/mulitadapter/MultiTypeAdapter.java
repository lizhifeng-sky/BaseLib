package lzf.mulitadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lzf.mulitadapter.holder.BaseViewHolder;
import lzf.mulitadapter.model.TypeModel;
import lzf.mulitadapter.type.TypeFactory;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class MultiTypeAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private TypeFactory typeFactory;
    private List<TypeModel> models;
    private Context context;

    public MultiTypeAdapter(List<TypeModel> models, Context context) {
        this.models = models;
        this.context = context;
        typeFactory=new TypeFactory();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(viewType,parent,false);
        return typeFactory.createViewHolder(viewType,view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setViewsData(models.get(position),position,this,context);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public int getItemViewType(int position) {
        return models.get(position).layoutId();
    }
}
