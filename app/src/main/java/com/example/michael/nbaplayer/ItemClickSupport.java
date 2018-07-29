package com.example.michael.nbaplayer;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by michael on 12/10/17.
 */

public class ItemClickSupport {
    private final RecyclerView mRecylerView;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    private ItemClickSupport(RecyclerView recyclerView) {
        mRecylerView = recyclerView;
        mRecylerView.setTag(R.id.item_click_support, this);
        mRecylerView.addOnChildAttachStateChangeListener(mAttachListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(mOnItemClickListener != null) {
                RecyclerView.ViewHolder holder = mRecylerView.getChildViewHolder(view);
                mOnItemClickListener.onItemClicked(mRecylerView, holder.getAdapterPosition(), view);
            }
        }
    };

    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            if(mOnItemLongClickListener != null) {
                RecyclerView.ViewHolder holder = mRecylerView.getChildViewHolder(view);
                return mOnItemLongClickListener.onItemLongClicked(mRecylerView, holder.getAdapterPosition(), view);
            }
            return false;
        }
    };

    private RecyclerView.OnChildAttachStateChangeListener mAttachListener = new RecyclerView.OnChildAttachStateChangeListener() {
        @Override
        public void onChildViewAttachedToWindow(View view) {
            view.setOnClickListener(mOnClickListener);
        }

        @Override
        public void onChildViewDetachedFromWindow(View view) {
            view.setOnLongClickListener(mOnLongClickListener);
        }
    };

    public static ItemClickSupport addTo(RecyclerView view) {
        ItemClickSupport support = (ItemClickSupport) view.getTag(R.id.item_click_support);
        if (support == null) {
            support = new ItemClickSupport(view);
        }
        return support;
    }

    public static ItemClickSupport removeFrom(RecyclerView view) {
        ItemClickSupport support = (ItemClickSupport) view.getTag(R.id.item_click_support);
        if (support != null) {
            support.detach(view);
        }
        return  support;
    }

    public ItemClickSupport setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
        return this;
    }

    public ItemClickSupport setOnItemLongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClickListener = listener;
        return this;
    }

    public void detach(RecyclerView view) {
        view.removeOnChildAttachStateChangeListener(mAttachListener);
        view.setTag(R.id.item_click_support, null);
    }

    public interface OnItemClickListener {
        void onItemClicked(RecyclerView recyclerView, int position, View view);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClicked(RecyclerView recyclerView, int position, View view);
    }

}
