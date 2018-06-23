package com.hankkin.compustrading.test.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hankkin.compustrading.R;
import com.hankkin.compustrading.test.bean.ProductInfo;
import com.hankkin.compustrading.view.RoundedImageView;

import java.util.List;

/**
 *
 */
public class ProductInfoAdapter extends BaseAdapter {

    private List<ProductInfo> data;
    private LayoutInflater inflater;
    private Context context;

    public ProductInfoAdapter(List<ProductInfo> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.product_infos_item, null);
            holder.ivProduct = convertView.findViewById(R.id.iv_product);
            holder.rivUserIcon = (RoundedImageView) convertView.findViewById(R.id.riv_usericon);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.tv_price);
            holder.tvPubTime = (TextView) convertView.findViewById(R.id.tv_pub_time);
            holder.tvSchool = (TextView) convertView.findViewById(R.id.tv_school);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ProductInfo product = data.get(position);
        holder.tvSchool.setText(product.getSchool());
        holder.tvPubTime.setText(product.getCreatedAt());
        if (!TextUtils.isEmpty(product.getUsername())) {
            holder.tvName.setText(product.getUsername());
        } else {
            holder.tvName.setText(product.getUser_tel());
        }
        /*if (!TextUtils.isEmpty(product.getUser_icon_url())) {
            ImageLoader.getInstance().displayImage(product.getUser_icon_url(), holder.rivUserIcon);
        } else {
            holder.rivUserIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.defaut));
        }*/
        holder.rivUserIcon.setImageResource(R.drawable.default_avatar);
        holder.tvPrice.setText("￥" + product.getPrice());
        holder.tvContent.setText(product.getName());
//        ImageLoader.getInstance().displayImage(product.getProduct_url(), holder.ivProduct);
        if (!TextUtils.isEmpty(product.getProduct_url())) {
            holder.ivProduct
                    .setImageURI(Uri.parse(product.getProduct_url()));
        }
        return convertView;
    }

    class ViewHolder {
        TextView tvPrice, tvPubTime, tvName, tvSchool, tvContent;
        SimpleDraweeView ivProduct;
        RoundedImageView rivUserIcon;
    }
}
