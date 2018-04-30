package com.raju.dragonflyproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.raju.dragonflyproject.R;
import com.raju.dragonflyproject.Utils.CollectionUtils;
import com.raju.dragonflyproject.Utils.Helper;
import com.raju.dragonflyproject.datamanager.model.AddressLocation;
import com.raju.dragonflyproject.datamanager.model.DragonFly;
import com.raju.dragonflyproject.datamanager.service.ApiService;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Raju Yadav
 */

public class DragonAdapter extends RecyclerView.Adapter<DragonAdapter.ViewHolder> {

    public interface SendDataToDetail {
        void onSendDataToDetail(DragonFly schools, View image);
    }

    private SendDataToDetail nullSendDataToDetail = new SendDataToDetail() {
        @Override
        public void onSendDataToDetail(DragonFly schools, View image) {/*Ignore*/}
    };
    private SendDataToDetail sendDataToDetail = nullSendDataToDetail;
    private ArrayList<DragonFly> dragonData;
    private DragonFly dragonFly;
    private Context context;
    private ApiService apiService = ApiService.INSTANCE;

    public DragonAdapter(ArrayList<DragonFly> dragonData, SendDataToDetail sendDataToDetail) {
        this.dragonData = dragonData;
        this.sendDataToDetail = sendDataToDetail != null ? sendDataToDetail : nullSendDataToDetail;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.dragon_layout, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        dragonFly = dragonData.get(position);
        if (!TextUtils.isEmpty(dragonFly.getName())) {
            holder.dragonName.setVisibility(View.VISIBLE);
            holder.dragonName.setText(dragonFly.getName());

        }
        if (dragonFly.getLocation() != null) {
            holder.dragonAddress.setVisibility(View.VISIBLE);
            AddressLocation addressLocation = dragonFly.getLocation();
            holder.dragonAddress.setText("Address: " + addressLocation.getName() + "," + addressLocation.getAddress()
                    + "," + addressLocation.getCity() + "," + addressLocation.getState());
        }
        if (!TextUtils.isEmpty(dragonFly.getDescription())) {
            holder.dragonDescription.setVisibility(View.VISIBLE);
            holder.dragonDescription.setText(dragonFly.getDescription());
        }
        loadDragonImage(holder.image);
    }

    private void loadDragonImage(ImageView image) {
        if (!TextUtils.isEmpty(dragonFly.getId()) && !CollectionUtils.isCollectionEmpty(dragonFly.getImages())) {
            Helper.loadDragonImage(context, apiService, image, dragonFly.getId(), dragonFly.getImages().get(0).getId());
        }
    }

    @Override
    public int getItemCount() {
        if (dragonData == null) {
            return 0;
        }
        return dragonData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.dragon_name)
        TextView dragonName;
        @BindView(R.id.dragon_address)
        TextView dragonAddress;
        @BindView(R.id.image)
        CircleImageView image;
        @BindView(R.id.dragon_description)
        TextView dragonDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            sendDataToDetail.onSendDataToDetail(dragonData.get(getLayoutPosition()), image);
        }
    }
}

