package lzf.mulitadapter.holder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class ViewHolderFactory {
    private Map<Integer,BaseViewHolder> map=new HashMap<>();
    public void createViewHolder(int type){

    }

    public void addType(int type,BaseViewHolder baseViewHolder){
        map.put(type,baseViewHolder);
    }
}
