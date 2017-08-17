package lzf.mulitadapter.type;

import android.view.View;

import lzf.mulitadapter.holder.BaseViewHolder;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public interface TypeInterface {
    BaseViewHolder createViewHolder(int type, View itemView);

    void addType(int type, BaseViewHolder baseViewHolder);
}
