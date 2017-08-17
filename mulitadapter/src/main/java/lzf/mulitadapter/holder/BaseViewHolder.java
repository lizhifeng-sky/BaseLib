package lzf.mulitadapter.holder;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import lzf.mulitadapter.MultiTypeAdapter;

/**
 * Created by Administrator on 2017/2/5 0005.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    private SparseArray<View> views;
    private View itemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        views = new SparseArray<>();
    }

    public View getViewById(@IdRes int resID) {
        View view = views.get(resID);
        if (view == null) {
            view = itemView.findViewById(resID);
            views.put(resID, view);
        }
        return view;
    }

    public abstract void setViewsData(T model, int position, MultiTypeAdapter
            multiTypeAdapter, Context context);
}
