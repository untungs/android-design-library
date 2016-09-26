package com.example.android.materialdesigncodelab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TileContentFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(LayoutInflater layoutInflater, ViewGroup parent) {
            super(layoutInflater.inflate(R.layout.item_tile, parent, false));
        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final int LENGTH = 18;

        public ContentAdapter() {
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
