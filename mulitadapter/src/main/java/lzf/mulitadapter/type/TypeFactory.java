package lzf.mulitadapter.type;

import android.view.View;

import lzf.mulitadapter.holder.BaseViewHolder;
import lzf.mulitadapter.holder.ViewHolderFactory;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class TypeFactory implements TypeInterface {
    ViewHolderFactory viewHolderFactory;
    public TypeFactory() {
        viewHolderFactory=new ViewHolderFactory();
    }

    @Override
    public BaseViewHolder createViewHolder(int type, View itemView) {
        return null;
    }

    @Override
    public void addType(int type, BaseViewHolder baseViewHolder) {
        viewHolderFactory.addType(type,baseViewHolder);
    }
}
